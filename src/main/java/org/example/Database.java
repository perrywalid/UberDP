package org.example;

import org.example.Trip.Builder.TripBuilder;
import org.example.Trip.Trip;
import org.example.Trip.User.Customer;
import org.example.Trip.User.Employee;
import org.example.Trip.User.User;
import org.example.Trip.User.Driver;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class Database {

    private static Database instance;
    static Connection connection;

    private Database() {
        try {
            String url = "jdbc:sqlite:uber.db";
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
    public static Connection getConnection() {
        return connection;
    }
    public User getUser(String email, String password, String type) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + type + " WHERE Email = ? AND Password = ?");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return UserFactory.createUser(type, resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("email"), null, resultSet.getString("phone"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public Driver getDriver(String email, String password) {
        return (Driver) getUser(email, password, "driver");
    }
    public Customer getCustomer(String email, String password) {
        return (Customer) getUser(email, password, "customer");
    }
    public Employee getEmployee(String email, String password) {
        return (Employee) getUser(email, password, "employee");
    }
    private void addUser(User user, String type) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO " + type + " (name, email, password, phone) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addDriver(Driver driver) {
        addUser(driver, "driver");
    }
    public void addCustomer(Customer customer) {
        addUser(customer, "customer");
    }
    public void addEmployee(Employee employee) {
        addUser(employee, "employee");
    }

    public void saveTrip(Trip trip) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO trip (pickupLocation, dropoffLocation, pickupTime, fare, distance, duration, customer_id, driver_id) VALUES (?, ?, ?, ?, ?, ?, ?,?)");
            preparedStatement.setString(1, trip.getPickupLocation());
            preparedStatement.setString(2, trip.getDropoffLocation());
            preparedStatement.setString(3, trip.getPickupTime());
            preparedStatement.setDouble(4, trip.getFare());
            preparedStatement.setDouble(5, trip.getDistance());
            preparedStatement.setDouble(6, trip.getDuration());
            preparedStatement.setInt(7, trip.getCustomer().getId());
            if(trip.getDriver() == null) {
                preparedStatement.setNull(8, Types.INTEGER);
            } else {
                preparedStatement.setInt(8, trip.getDriver().getId());
            }
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void updatePersonalInfo(User user, String type) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE " + type + " SET name = ?, email = ?, password = ?, phone = ? WHERE id = ?");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setInt(5, user.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public List<Trip> findAvailableTrips() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM trip WHERE isCompleted = 0");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            List<Trip> trips = new LinkedList<>();
            while (resultSet.next()) {
                Trip trip = new TripBuilder()
                        .setPickupLocation(resultSet.getString("pickupLocation"))
                        .setDestination(resultSet.getString("dropoffLocation"))
                        .setPickupTime(resultSet.getString("pickupTime"))
                        .setFare(resultSet.getDouble("fare"))
                        .setDistance(resultSet.getDouble("distance"))
                        .setDuration(resultSet.getDouble("duration"))
                        .setCustomer(getCustomerById(resultSet.getInt("customer_id")))
                        .setDriver(getDriverById(resultSet.getInt("driver_id")))
                        .build();
                trips.add(trip);
            }
            return trips;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public Customer getCustomerById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customer WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return (Customer) UserFactory.createUser("customer", resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("email"), null, resultSet.getString("phone"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public Driver getDriverById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM driver WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return (Driver) UserFactory.createUser("driver", resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("email"), null, resultSet.getString("phone"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public void assignDriverToTrip(Driver driver, Trip trip) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE trip SET driver_id = ? WHERE id = ?");
            preparedStatement.setInt(1, driver.getId());
            preparedStatement.setInt(2, trip.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void completeTrip(Trip trip) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE trip SET isCompleted = 1 WHERE id = ?");
            preparedStatement.setInt(1, trip.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public List<Trip> getTripsByCustomer(Customer customer) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM trip WHERE customer_id = ?");
            preparedStatement.setInt(1, customer.getId());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            List<Trip> trips = new LinkedList<>();
            while (resultSet.next()) {
                Trip trip = new TripBuilder()
                        .setPickupLocation(resultSet.getString("pickupLocation"))
                        .setDestination(resultSet.getString("dropoffLocation"))
                        .setPickupTime(resultSet.getString("pickupTime"))
                        .setFare(resultSet.getDouble("fare"))
                        .setDistance(resultSet.getDouble("distance"))
                        .setDuration(resultSet.getDouble("duration"))
                        .setCustomer(getCustomerById(resultSet.getInt("customer_id")))
                        .setDriver(getDriverById(resultSet.getInt("driver_id")))
                        .build();
                trips.add(trip);
            }
            return trips;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
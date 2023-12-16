package org.example;

import org.example.Trip.Trip;
import org.example.Trip.TripFacade;
import org.example.Trip.User.Customer;
import org.example.Trip.User.Driver;
import org.example.Trip.User.Employee;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //Register to the system as a customer
        UserService userService = new UserService();
        //userService.registerCustomer("John", "john1@gmail.com", "john123", "123456789");
        //Login as a customer
        Customer customer = (Customer) userService.loginUser("john1@gmail.com", "john123", "customer");
        System.out.println(customer.getName());
        //Update personal info
        customer.setName("Amr");
        userService.updateUser(customer, "customer");
        userService.sendComplaint(customer, "Bad service moot");
        //Request a trip
        TripFacade tripFacade = new TripFacade();
        //tripFacade.requestTrip("123 Main St", "456 Main St", "12:00", customer);
        List<Trip> trips = tripFacade.getTripsByCustomer(customer, false);
        System.out.println(trips.size());
        List<Trip> trips1 = tripFacade.getTripsByCustomer(customer, true);
        System.out.println(trips1.size());


        //Register to the system as a driver
        userService.registerDriver("Mahmoud", "mahmoud@gmail.com", "mahmoud123", "123456789");
        //Login as a driver
        Driver driver = (Driver) userService.loginUser("mahmoud@gmail.com", "mahmoud123", "driver");
        System.out.println(driver.getName());
        List<Trip> availableTrips = tripFacade.findAvailableTrips();
        System.out.println(availableTrips.size());
        //Accept trip
        //tripFacade.assignDriverToTrip(driver, trips.get(0));
        //Get trip by driver
        List<Trip> trips2 = tripFacade.getTripsByDriver(driver);
        System.out.println(trips2.size());
        //Complete a trip
        //tripFacade.completeTrip(trips.get(0), 5);
        //Register to the system as an employee
        userService.registerEmployee("Ahmed", "ahmed@gmail.com", "ahmed123", "123456789");
        //Login as an employee
        Employee employee = (Employee) userService.loginUser("ahmed@gmail.com", "ahmed123", "employee");
        System.out.println(employee.getName());
        EmployeeService employeeService = new EmployeeService();
        List<Complaint> complaints = employeeService.viewComplaints();
        System.out.println(complaints.size());
        //Add a car
        //Car car = new Car(null, null, "2019", "8982845", "White");
        //List cars
        List<Car> cars = employeeService.listCars();
        //Assign a car to a driver
        employeeService.assignCarToDriver(cars.get(0), driver);
        //Unassign a car from a driver
        employeeService.unassignCarFromDriver(driver);

    }
}
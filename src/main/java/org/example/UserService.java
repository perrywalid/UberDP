package org.example;

import org.example.Trip.User.Customer;
import org.example.Trip.User.Driver;
import org.example.Trip.User.Employee;
import org.example.Trip.User.User;

public class UserService {
    public void registerCustomer(String name, String email, String password, String phone, String type) {
        Customer customer = new Customer(name, email, password, phone);
        Database.getInstance().addCustomer(customer);

    }
    public void registerDriver(String name, String email, String password, String phone, String type) {
        Driver driver = new Driver(name, email, password, phone);
        Database.getInstance().addDriver(driver);
    }
    public void registerEmployee(String name, String email, String password, String phone, String type) {
        Employee employee = new Employee(name, email, password, phone);
        Database.getInstance().addEmployee(employee);
    }

    public void loginUser(String email, String password, String type) {
        if(Database.getInstance().getUser(email, password, type) != null) {
            //Login successful
        } else {
            //Login failed
        }
    }
    public void updateUser(User user, String type) {
        Database.getInstance().updatePersonalInfo(user, type);
    }
}

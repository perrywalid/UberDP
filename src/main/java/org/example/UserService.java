package org.example;

import org.example.Trip.User.Customer;
import org.example.Trip.User.Driver;
import org.example.Trip.User.Employee;
import org.example.Trip.User.User;

public class UserService {
    public void registerCustomer(String name, String email, String password, String phone) {
        Customer customer = new Customer(name, email, password, phone);
        Database.getInstance().addCustomer(customer);

    }
    public void registerDriver(String name, String email, String password, String phone) {
        Driver driver = new Driver(name, email, password, phone);
        Database.getInstance().addDriver(driver);
    }
    public void registerEmployee(String name, String email, String password, String phone) {
        Employee employee = new Employee(name, email, password, phone);
        Database.getInstance().addEmployee(employee);
    }

    public User loginUser(String email, String password, String type) {
        User user = Database.getInstance().loginUser(email, password, type);
        if(user != null) {
            //Login successful
        } else {
            //Login failed
        }
        return user;
    }
    public void updateUser(User user, String type) {
        Database.getInstance().updatePersonalInfo(user, type);
    }

    public void sendComplaint(Customer customer, String description) {
        Complaint complaint = new Complaint(customer, description);
        Database.getInstance().addComplaint(complaint);
    }
}

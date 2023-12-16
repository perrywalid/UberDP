package org.example;

import org.example.Trip.TripFacade;
import org.example.Trip.User.Customer;
import org.example.Trip.User.Driver;
import org.example.Trip.User.Employee;

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
        //Request a trip
        TripFacade tripFacade = new TripFacade();
        tripFacade.requestTrip("123 Main St", "456 Main St", "12:00", customer);
        //Register to the system as a driver
        userService.registerDriver("Gamal", "gamal@gmail.com", "gamal123", "123456789");
        //Login as a driver
        Driver driver = (Driver) userService.loginUser("gamal@gmail.com", "gamal123", "driver");
        System.out.println(driver.getName());
        //Register to the system as an employee
        userService.registerEmployee("Ahmed", "ahmed@gmail.com", "ahmed123", "123456789");
        //Login as an employee
        Employee employee = (Employee) userService.loginUser("ahmed@gmail.com", "ahmed123", "employee");
        System.out.println(employee.getName());




        //TripFacade tripFacade = new TripFacade();
        //Customer customer = new Customer("John", "john@gmail.com", "john123", "123456789");
        //Database.getInstance().addUser(customer, "customer");
        //Customer c = Database.getInstance().getCustomer("john@gmail.com", "john123");
        //System.out.println(c.getId());
        //tripFacade.requestTrip("123 Main St", "456 Main St", "12:00", c);
    }
}
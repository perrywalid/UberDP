package org.example;

import org.example.Trip.TripFacade;
import org.example.Trip.User.Customer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        TripFacade tripFacade = new TripFacade();
        //Customer customer = new Customer("John", "john@gmail.com", "john123", "123456789");
        //Database.getInstance().addUser(customer, "customer");
        Customer c = Database.getInstance().getCustomer("john@gmail.com", "john123");
        System.out.println(c.getId());
        //tripFacade.requestTrip("123 Main St", "456 Main St", "12:00", c);
    }
}
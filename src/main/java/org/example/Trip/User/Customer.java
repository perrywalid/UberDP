package org.example.Trip.User;

import org.example.Complaint;
import org.example.Database;
import org.example.Trip.Trip;

import java.util.List;

public class Customer extends User {
    private List<Trip> trips;
    private List<Complaint> complaints;
    public Customer(String name, String email, String password, String phone) {
        super(name, email, password, phone);
    }
    public static Customer login(String email, String password) {
        return Database.getInstance().getCustomer(email, password);
    }
}

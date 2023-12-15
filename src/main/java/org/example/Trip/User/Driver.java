package org.example.Trip.User;

import org.example.Car;

public class Driver extends User {

    public Driver(String name, String email, String password, String phone) {
        super(name, email, password, phone);
    }
    private Car car;
}

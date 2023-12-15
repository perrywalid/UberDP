package org.example;

import org.example.Trip.User.Customer;
import org.example.Trip.User.Driver;
import org.example.Trip.User.Employee;
import org.example.Trip.User.User;

public class UserFactory {
    public static User createUser(String type, int id, String name, String email, String password, String phone) {
        User user = null;
        if (type.equals("driver")) {
            user = new Driver(name, email, password, phone);
        } else if (type.equals("customer")) {
            user = new Customer(name, email, password, phone);
        } else if (type.equals("employee")) {
            user = new Employee(name, email, password, phone);
        } else {
            return null;
        }
        user.setId(id);
        return user;
    }
}

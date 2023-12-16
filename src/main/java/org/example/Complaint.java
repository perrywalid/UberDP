package org.example;

import org.example.Trip.User.Customer;

public class Complaint {
    Customer customer;
    String description;

    public Complaint(Customer customer, String description) {
        this.customer = customer;
        this.description = description;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

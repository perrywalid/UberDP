package org.example.Trip.User;

import org.example.Car;
import org.example.Database;
import org.example.Trip.Trip;

import java.util.List;

public class Driver extends User {

    public Driver(String name, String email, String password, String phone) {
        super(name, email, password, phone);
    }

    private List<Trip> trips;
    private Car car;
    private int numberOfTrips;
    private double totalRating;
    private double averageRating;

    public Car getCar()
    {
        Database.getInstance().getCarByDriver(this);
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getNumberOfTrips() {
        return numberOfTrips;
    }

    public void setNumberOfTrips(int numberOfTrips) {
        this.numberOfTrips = numberOfTrips;
    }

    public double getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(double totalRating) {
        this.totalRating = totalRating;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public List<Trip> getTrips() {
        trips = Database.getInstance().getTripsByDriver(this);
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

}

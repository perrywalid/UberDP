package org.example.Trip.Strategy;

import org.example.Trip.Trip;

public interface FareCalculatorStrategy {
    public double calculateFare(Trip trip);
}

package org.example;

import org.example.Trip.User.Driver;

import java.util.List;

public class EmployeeService {
    public List<Complaint> viewComplaints() {
        List<Complaint> complaints = Database.getInstance().getAllComplaints();
        return complaints;
    }
    public void addCar(Car car) {
        Database.getInstance().addCar(car);
    }
    public void assignCarToDriver(Car car, Driver driver) {
        driver.setCar(car);
        Database.getInstance().assignCarToDriver(car, driver);
    }
    public List<Car> listCars() {
        List<Car> cars = Database.getInstance().getAllCars();
        return cars;
    }
    public void unassignCarFromDriver(Driver driver) {
        driver.setCar(null);
        Database.getInstance().unassignCarFromDriver(driver);
    }
}

package org.example;

public class Car {
    Integer id;
    Integer driverId;
    String model;
    String plateNumber;
    String color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Car(Integer id, Integer driverId, String model, String plateNumber, String color) {
        this.id = id;
        this.driverId = driverId;
        this.model = model;
        this.plateNumber = plateNumber;
        this.color = color;
    }
}

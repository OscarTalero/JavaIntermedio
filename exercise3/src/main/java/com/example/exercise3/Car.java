package com.example.exercise3;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;
    private String manufacturer;
    private String model;
    private Integer yearCreated;

    public Car(){

    }

    public Car(Long carId, String manufacturer, String model, Integer yearCreated) {
        this.carId = carId;
        this.manufacturer = manufacturer;
        this.model = model;
        this.yearCreated = yearCreated;
    }

    public Long getId() {
        return carId;
    }

    public void setId(Long carId) {
        this.carId = carId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYearCreated() {
        return yearCreated;
    }

    public void setYearCreated(Integer year) {
        this.yearCreated = yearCreated;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + carId +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", year=" + yearCreated +
                '}';
    }
}

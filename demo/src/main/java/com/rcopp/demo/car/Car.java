package com.rcopp.demo.car;

import jakarta.persistence.*;

@Entity
@Table
public class Car {

    @SequenceGenerator(
            name = "car_sequence",
            sequenceName = "car_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "car_sequence"
    )
    @Id
    private Long id;
    private String licensePlate;
    private String brand;
    private String model;
    private String version;
    private Integer year;
    private Integer mileage;

    public Car (){

    }

    public Car(String licensePlate,
               String brand,
               String model,
               String version,
               Integer year,
               Integer mileage) {

        this.licensePlate = licensePlate;
        this.brand = brand;
        this.model = model;
        this.version = version;
        this.year = year;
        this.mileage = mileage;
    }

    public Car(Long id,
               String licensePlate,
               String brand,
               String model,
               String version,
               Integer year,
               Integer mileage) {

        this.id = id;
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.model = model;
        this.version = version;
        this.year = year;
        this.mileage = mileage;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", licensePlate='" + licensePlate + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", version='" + version + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                '}';
    }
}

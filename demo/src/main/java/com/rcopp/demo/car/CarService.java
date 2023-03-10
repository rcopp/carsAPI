package com.rcopp.demo.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CarService {

    private static final int MAXMILEAGE = 1000000;
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getCars(){
        return carRepository.findAll();
    }

    public void addCar(Car car){

        Optional<Car> carByLicensePlate = carRepository.findCarByLicensePlate(car.getLicensePlate());
        if(carByLicensePlate.isPresent()){
            throw new IllegalStateException("Vehicle already exists");
        }
        carRepository.save(car);
    }

    public void deleteCar(Long id){
        boolean exists = carRepository.existsById(id.toString());
        if(!exists){
            throw new IllegalStateException("Vehicle with id " + id + " does not exists");
        }
        carRepository.deleteById(id.toString());
    }

    @Transactional
    public void updateCar(Long id,
                          String licensePlate,
                          String brand,
                          String model,
                          String version,
                          Integer year,
                          Integer mileage) {

        Car car = carRepository.findById(id.toString())
                .orElseThrow(() -> new IllegalStateException(
                        "Vehicle with id " + id + " does not exists"
                ));

        //THIS LOGIC SHOULD BE DIFFERENT IN ORDER TO CHECK THE NEW LICENSE PLATE CORRECTLY
        if (licensePlate != null && licensePlate.length() > 0 && !Objects.equals(car.getLicensePlate(), licensePlate)) {
            Optional<Car> carOptional = carRepository.findCarByLicensePlate(licensePlate);
            if (carOptional.isPresent()) {
                throw new IllegalStateException("Vehicle already exists");
            }
            car.setLicensePlate(licensePlate);
        }

        if (brand != null && brand.length() > 0 && !Objects.equals(car.getBrand(), brand)) {
            car.setBrand(brand);
        }

        if (model != null && model.length() > 0 && !Objects.equals(car.getModel(), model)) {
            car.setModel(model);
        }

        if (version != null && version.length() > 0 && !Objects.equals(car.getVersion(), version)) {
            car.setVersion(version);
        }

        if (year != null && year > 1960 && year <= LocalDate.now().getYear() && !Objects.equals(car.getYear(), year)) {
            car.setYear(year);
        }

        if (mileage != null && mileage >= 0 && mileage < MAXMILEAGE && !Objects.equals(car.getMileage(), mileage)) {
            car.setMileage(mileage);
        }
    }
}

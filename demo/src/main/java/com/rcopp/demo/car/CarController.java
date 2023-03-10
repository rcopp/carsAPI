package com.rcopp.demo.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/car")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getCars(){
        return carService.getCars();
    }

    @PostMapping
    public void addCar(@RequestBody  Car car){
        carService.addCar(car);
    }

    @DeleteMapping(path = "{carId}")
    public void deleteCar(@PathVariable("carId") Long id){
        carService.deleteCar(id);
    }

    @PutMapping(path = "{carId}")
    public void updateCar(
            @PathVariable("carId") Long id,
            @RequestParam(required = false) String licensePlate,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) String version,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer mileage){

        carService.updateCar(id, licensePlate, brand, model, version, year, mileage);
    }
}

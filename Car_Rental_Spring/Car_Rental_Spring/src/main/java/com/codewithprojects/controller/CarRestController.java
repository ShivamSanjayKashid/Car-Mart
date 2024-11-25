package com.codewithprojects.controller;

import com.codewithprojects.entity.Car;
import com.codewithprojects.Service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarRestController {

    private final CarService carService;

    // Endpoint to get all available cars
    @GetMapping
    public ResponseEntity<List<Car>> getAvailableCars() {
        List<Car> cars = carService.getAvailableCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    // Endpoint to create a new car
    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car createdCar = carService.createCar(car);
        return new ResponseEntity<>(createdCar, HttpStatus.CREATED);
    }

    // Endpoint to update an existing car
    @PutMapping("/{carId}")
    public ResponseEntity<Car> updateCar(@PathVariable("carId") int carId, @RequestBody Car car) {
        Optional<Car> existingCar = carService.getCarById(carId);

        if (existingCar.isPresent()) {
            // Update the car details
            car.setId(carId);  // Ensure we keep the same car ID when updating
            Car updatedCar = carService.updateCar(car);
            return new ResponseEntity<>(updatedCar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if car not found
        }
    }

    // Endpoint to delete a car
    @DeleteMapping("/{carId}")
    public ResponseEntity<Void> deleteCar(@PathVariable("carId") int carId) {
        Optional<Car> existingCar = carService.getCarById(carId);

        if (existingCar.isPresent()) {
            carService.deleteCar(carId); // Delete the car
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return 204 for successful deletion
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if car not found
        }
    }
}

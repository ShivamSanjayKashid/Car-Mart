package com.codewithprojects.Service;

import com.codewithprojects.entity.Car;
import com.codewithprojects.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    // Method to get all available cars
    public List<Car> getAvailableCars() {
        return carRepository.findAll();
    }

    // Method to create a new car
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    // Method to get a car by its ID
    public Optional<Car> getCarById(int carId) {
        return carRepository.findById(carId);  // This fetches the car from the repository by its ID
    }

    // Method to update an existing car
    public Car updateCar(Car car) {
        return carRepository.save(car);  // Save method works for both creating and updating
    }

    // Method to delete a car by its ID
    public void deleteCar(int carId) {
        carRepository.deleteById(carId);  // Deletes the car with the given ID
    }
}

package com.codewithprojects.repository;

import com.codewithprojects.entity.Car;  // Correct import for Car entity
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
    // You can define custom queries if needed
}

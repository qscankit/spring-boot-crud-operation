package com.qsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.dto.Car;

// Make a Interface repository
public interface CarRepository extends JpaRepository<Car, Integer> {

}

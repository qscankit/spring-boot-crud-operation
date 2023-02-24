package com.qsp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.dto.Car;
import com.qsp.repository.CarRepository;

// to communicate with database we use @Repository or to make the class part of springframe work
@Repository
public class CarDao {

//	to get the object reference class we use @Autowired
	@Autowired
	CarRepository carRepository;

//	insert method
	public void insertCar(Car car) {
		carRepository.save(car);
	}

//	getById method
	public int getById(int id) {
		Optional<Car> optional = carRepository.findById(id);

		if (optional.isPresent()) {
			Car car = optional.get();
			return car.getId();
		} else {
			return 0;
		}
	}
	//getalldetails
	public List<Car> viewCar() {
		return  carRepository.findAll();
		
	}

//	update Car
	public void updateCar(int id, Car car) {
		Optional<Car> optional = carRepository.findById(id);

		if (!optional.isEmpty()) {
			Car car2 = optional.get();

//		logic
			if ((car.getName() != null) && (car.getPrice() != 0.0)) {
				car2.setName(car.getName());
				car2.setPrice(car.getPrice());

				carRepository.save(car2);
			} else if (car.getPrice() != 0.0) {
				car2.setPrice(car.getPrice());

				carRepository.save(car2);
			} else {
				car2.setName(car.getName());
				carRepository.save(car2);
			}
		}
	}
	//delete
	public Car deleteCar(int id) {
		Optional<Car> optional = carRepository.findById(id);

		if (optional.isPresent()) {
			 carRepository.delete(optional.get());
			return optional.get();
		} else {
			return null;
		}
	}
}

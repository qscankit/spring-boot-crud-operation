package com.qsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.dto.Car;
import com.qsp.service.CarService;

//Create restAPI for inserting the car
@RestController
public class CarController {

	@Autowired
	CarService carService;
	
	@PostMapping("/insertCar")
	public  Car insertCar(@RequestBody Car car) {
		carService.insertCar(car);
		return car;
		
	}
//	getById API
	@GetMapping("/getByid/{id}")
	public int getById(@PathVariable int id) {
		return carService.getById(id);
	}
	
//	update 
	@PutMapping("/updateCar/{id}")
	public String updateCar(@PathVariable int id,@RequestBody Car car) {
		return carService.updateCar(id, car);
	}
	//getalldetails
	@GetMapping("/viewcar")
	//getalldetails
		public List<Car> viewCar(){
		return carService.viewCar();
	}
	
	//delete
	@DeleteMapping("/delete/{id}")
	public Car deleteCar(@PathVariable int id) {
				return carService.deleteCar(id);
			}
}

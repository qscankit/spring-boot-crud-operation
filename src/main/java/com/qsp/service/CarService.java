package com.qsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsp.dao.CarDao;
import com.qsp.dto.Car;

@Service
public class CarService {

	@Autowired
	CarDao dao;
	
//	insert method
	public void insertCar(Car car) {
		 dao.insertCar(car);
	}
	
//	getById method
	public int getById(int id) {
		return dao.getById(id);
	}
	
//	update Car
	public String updateCar(int id, Car car) {
	int id1 = dao.getById(id);
		
		System.out.println(id1);
		if(dao.getById(id1)==id) {
			dao.updateCar(id, car);
			
			return "Data is Update from table..";
		}else {
			
			return "Data is not updated from the table..";
		}
		
	}
	
	//getalldetails
		public List<Car> viewCar(){
			return dao.viewCar();
		}
		
		//delete
		public Car deleteCar(int id) {
			return dao.deleteCar(id);
		}
}

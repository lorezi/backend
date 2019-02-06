package com.learn.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.domain.Car;
import com.learn.domain.CarRepository;

@RestController
public class CarController {

	@Autowired
	private CarRepository carRepository;
	@GetMapping("/cars")
	public Iterable<Car> getCars(){
		return carRepository.findAll();
	}
//	@GetMapping("/login")
//	public String loginSuccess() {
//		return "Successful";
//	}
}

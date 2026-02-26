package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.Car;
import com.example.service.CarService;

@RestController
@RequestMapping("/cars") //use REST APIs
public class CarController {
	
	private CarService cs;
	public CarController(CarService cs) {
        this.cs = cs;
    }
	@PostMapping
	public Car addCar(@RequestBody Car car) {
		return cs.addCar(car);
	}
	@GetMapping
	public List<Car> getCar() {
		return cs.getCar();
	}
	@GetMapping("/{id}")
	public Car getCarById(@PathVariable int id) {
		return cs.getCarById(id);
	}
	@PutMapping("{id}")
	public Car updateCar(@RequestBody Car car,@PathVariable int id) {
		car.setCarId(id);
		return cs.updateCar(car);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		cs.delete(id);
	}
}

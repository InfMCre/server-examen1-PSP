package com.example.MCrego;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.MCrego.model.CarPutRequest;
import com.example.MCrego.model.CarServiceModel;
import com.example.MCrego.model.ReparationPostRequest;
import com.example.MCrego.model.ReparationServiceModel;
import com.example.MCrego.persistence.Car;
import com.example.MCrego.persistence.Reparation;
import com.example.MCrego.repository.CarRepository;
import com.example.MCrego.repository.ReparationRepository;

@RestController
@RequestMapping("/api")
public class CarController {

	@Autowired
	CarRepository carRepository;

	@Autowired
	ReparationRepository reparationRepository;

	
	@GetMapping("/cars")
	public ResponseEntity<List<CarServiceModel>> getCar() {
		
		List<CarServiceModel> response = new ArrayList<CarServiceModel>();
		Iterable<Car> carList = carRepository.findAll();
		
		for (Car car: carList) {
			CarServiceModel carServiceModel = new CarServiceModel(
				car.getId(),
				car.getCarRegistration(),
				car.getModel(),
				car.getColor()
			);
			response.add(carServiceModel);
			
		}

		return new ResponseEntity<List<CarServiceModel>>(response, HttpStatus.OK);
	}
	
	
	@GetMapping("/cars/{carId}")
	public ResponseEntity<CarServiceModel> getCar(
		@PathVariable("carId") Integer carId
	) {
		
		Car car = carRepository.findById(carId).orElseThrow(
			() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "No encontrado")
		);
		
		CarServiceModel response = new CarServiceModel(
			car.getId(),
			car.getCarRegistration(),
			car.getModel(),
			car.getColor()
		);
		
		return new ResponseEntity<CarServiceModel>(response, HttpStatus.OK);
	}
	
	
	@PutMapping("/cars/{id}")
	public ResponseEntity<CarServiceModel> updateCar(
		@PathVariable("id") Integer carId,
		@RequestBody CarPutRequest carPutRequest
	) {
		
		Car car = carRepository.findById(carId).orElseThrow(
			() -> new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "No encontrado")
		);
		
		car.setCarRegistration(carPutRequest.getCarRegistration());
		car.setColor(carPutRequest.getColor());
		car.setModel(carPutRequest.getModel());
		try {
			car = carRepository.save(car);
			
			CarServiceModel response = new CarServiceModel(
				car.getId(),
				car.getCarRegistration(),
				car.getModel(),
				car.getColor()
			);
			
			return new ResponseEntity<CarServiceModel>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<CarServiceModel>(HttpStatus.CONFLICT);
		}
	}
	
	
	@GetMapping("/cars/{carId}/reparations")
	public ResponseEntity<List<ReparationServiceModel>> getCarReparations(
			@PathVariable("carId") Integer carId
	) {
		
		Car car = carRepository.findById(carId).orElseThrow(
			() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "No encontrado")
		);
		
		
		List<ReparationServiceModel> response = new ArrayList<ReparationServiceModel>();
		
		for (Reparation currentReparation : car.getReparationList()) {
			ReparationServiceModel element = new ReparationServiceModel(
				currentReparation.getId(), 
				currentReparation.getReparationDate(),
				currentReparation.getPrice(),
				currentReparation.getIdCar()
			);
			response.add(element);
		};
		
		return new ResponseEntity<List<ReparationServiceModel>>(response, HttpStatus.OK);
	}
	

	@PostMapping("/cars/{carId}/reparations")
	public ResponseEntity<ReparationServiceModel> createCarReparations(
			@PathVariable("carId") Integer carId,
			@RequestBody ReparationPostRequest reparationPostRequest
	) {
		
		Car car = carRepository.findById(carId).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.CONFLICT, "No encontrado")
		);
		
		Reparation reparation = new Reparation(
			reparationPostRequest.getReparationDate(), 
			reparationPostRequest.getPrice(),
			carId
		);
		reparation.setCar(car);
		
		reparation = reparationRepository.save(reparation);
		
		ReparationServiceModel response = new ReparationServiceModel(
			reparation.getId(),
			reparation.getReparationDate(),
			reparation.getPrice(),
			reparation.getIdCar()
		);
		return new ResponseEntity<ReparationServiceModel>(response, HttpStatus.CREATED);
	}
	

	@DeleteMapping("/reparations/{id}")
	public ResponseEntity<?> deleteReparation(
		@PathVariable("id") Integer reparationId
	) {
		reparationRepository.deleteById(reparationId);
		return new ResponseEntity<CarServiceModel>(HttpStatus.NO_CONTENT);
	}
	
	
	
}

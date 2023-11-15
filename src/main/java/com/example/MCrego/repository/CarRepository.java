package com.example.MCrego.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.MCrego.persistence.Car;

public interface CarRepository extends CrudRepository<Car, Integer>{
	Optional<Car> findByCarRegistration(String carRegistration);
}

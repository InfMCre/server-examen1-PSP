package com.example.MCrego.persistence;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="cars")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String carRegistration;
	@Column
	private String model;
	@Column
	private String color;
	@OneToMany(mappedBy = "car", fetch = FetchType.LAZY)
	@JsonBackReference
	private List<Reparation> reparationList;
	
	
	
	
	public Car() {}
	public Car(Integer id, String carRegistration, String model, String color) {
		super();
		this.id = id;
		this.carRegistration = carRegistration;
		this.model = model;
		this.color = color;
	}
	
	public Car(String carRegistration, String model, String color) {
		super();
		this.carRegistration = carRegistration;
		this.model = model;
		this.color = color;
	}
	
	public Car(Integer id, String carRegistration, String model, String color, List<Reparation> reparationList) {
		super();
		this.id = id;
		this.carRegistration = carRegistration;
		this.model = model;
		this.color = color;
		this.reparationList = reparationList;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCarRegistration() {
		return carRegistration;
	}
	public void setCarRegistration(String carRegistration) {
		this.carRegistration = carRegistration;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
	public List<Reparation> getReparationList() {
		return reparationList;
	}
	public void setReparationList(List<Reparation> reparationList) {
		this.reparationList = reparationList;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", carRegistration=" + carRegistration + ", model=" + model + ", color=" + color + "]";
	}
	
}

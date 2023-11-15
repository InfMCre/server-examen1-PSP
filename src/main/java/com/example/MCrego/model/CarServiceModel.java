package com.example.MCrego.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

public class CarServiceModel {

	private Integer id;
	private String carRegistration;
	private String model;
	private String color;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<ReparationServiceModel> reparationList;
	
	
	
	
	public CarServiceModel() {}
	public CarServiceModel(Integer id, String carRegistration, String model, String color) {
		super();
		this.id = id;
		this.carRegistration = carRegistration;
		this.model = model;
		this.color = color;
	}
	
	public CarServiceModel(Integer id, String carRegistration, String model, String color, List<ReparationServiceModel> reparationList) {
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
	
	
	public List<ReparationServiceModel> getReparationList() {
		return reparationList;
	}
	public void setReparationList(List<ReparationServiceModel> reparationList) {
		this.reparationList = reparationList;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", carRegistration=" + carRegistration + ", model=" + model + ", color=" + color + "]";
	}
}

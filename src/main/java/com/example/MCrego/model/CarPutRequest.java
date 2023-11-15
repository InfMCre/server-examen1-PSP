package com.example.MCrego.model;


public class CarPutRequest {

	private String carRegistration;
	private String model;
	private String color;
	public CarPutRequest( String carRegistration, String model, String color) {
		super();
		this.carRegistration = carRegistration;
		this.model = model;
		this.color = color;
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
	
	@Override
	public String toString() {
		return "CarPostRequest [carRegistration=" + carRegistration + ", model=" + model + ", color="
				+ color + "]";
	}
	
}

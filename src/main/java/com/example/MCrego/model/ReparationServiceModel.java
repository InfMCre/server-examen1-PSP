package com.example.MCrego.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;


public class ReparationServiceModel {
	private Integer id;
	private Date reparationDate;
	private Float price;
	private Integer idCar;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private CarServiceModel car;

	public ReparationServiceModel() {}
	public ReparationServiceModel(Integer id, Date reparationDate, Float price, Integer idCar) {
		super();
		this.id = id;
		this.reparationDate = reparationDate;
		this.price = price;
		this.idCar = idCar;
	}
	
	public ReparationServiceModel(Integer id, Date reparationDate, Float price, Integer idCar, CarServiceModel car) {
		super();
		this.id = id;
		this.reparationDate = reparationDate;
		this.price = price;
		this.idCar = idCar;
		this.car = car;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getReparationDate() {
		return reparationDate;
	}
	public void setReparationDate(Date reparationDate) {
		this.reparationDate = reparationDate;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getIdCar() {
		return idCar;
	}
	public void setIdCar(Integer idCar) {
		this.idCar = idCar;
	}
	
	
	
	public CarServiceModel getCar() {
		return car;
	}
	public void setCar(CarServiceModel car) {
		this.car = car;
	}
	@Override
	public String toString() {
		return "Reparation [id=" + id + ", reparationDate=" + reparationDate + ", price=" + price + ", idCar=" + idCar
				+ "]";
	}
	
}

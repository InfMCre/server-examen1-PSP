package com.example.MCrego.persistence;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="reparations")
public class Reparation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private Date reparationDate;
	@Column
	private Float price;
	
	@Column(name="id_car", insertable=false, updatable=false)
	private Integer idCar;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_car")
	@JsonManagedReference
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	// private Department department;
	private Car car;
	
	

	public Reparation() {}
	public Reparation(Date reparationDate, Float price, Integer idCar) {
		super();
		this.reparationDate = reparationDate;
		this.price = price;
		this.idCar = idCar;
	}
	public Reparation(Integer id, Date reparationDate, Float price, Integer idCar) {
		super();
		this.id = id;
		this.reparationDate = reparationDate;
		this.price = price;
		this.idCar = idCar;
	}
	
	public Reparation(Integer id, Date reparationDate, Float price, Integer idCar, Car car) {
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
	
	
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	@Override
	public String toString() {
		return "Reparation [id=" + id + ", reparationDate=" + reparationDate + ", price=" + price + ", idCar=" + idCar
				+ "]";
	}
	
	
}

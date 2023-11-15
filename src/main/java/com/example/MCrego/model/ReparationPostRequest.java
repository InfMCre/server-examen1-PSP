package com.example.MCrego.model;

import java.util.Date;

public class ReparationPostRequest {
	
	private Date reparationDate;
	private Float price;
	
	public ReparationPostRequest() {
	}
	
	public ReparationPostRequest(Date reparationDate, Float price) {
		super();
		this.reparationDate = reparationDate;
		this.price = price;
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

	@Override
	public String toString() {
		return "ReparationPostRequest [reparationDate=" + reparationDate + ", price=" + price + "]";
	}
}

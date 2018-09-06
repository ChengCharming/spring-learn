package com.test.java.fdi;

public class Car {
	private String brand ="N/A";
	private String model ="N/A";
	
	public void launch() {
		System.out.println(model+" has been launched");
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String toString() {
		return brand+"-"+model;
	}
	
}

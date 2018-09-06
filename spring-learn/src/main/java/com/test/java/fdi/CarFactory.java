package com.test.java.fdi;

public class CarFactory {
		public Car createCar(String brand ,String model) {
			Car car = new Car();
			car.setBrand(brand);
			car.setModel(model);
			return car;
		}
}

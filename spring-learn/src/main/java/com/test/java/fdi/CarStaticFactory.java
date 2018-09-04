package com.test.java.fdi;

public class CarStaticFactory {
        public static Car createCar(String brand) {
        	Car car =new Car();
        	car.setBrand(brand);
        	return car;
        }
}

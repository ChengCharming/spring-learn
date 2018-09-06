package com.test.java.fdi;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryDiDemo {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("fdi.xml");
		Car car = context.getBean("car",Car.class);
		System.out.println(car.toString());
		
		Car car2 =context.getBean("car2",Car.class);
		System.out.println(car2.toString());
	}

}

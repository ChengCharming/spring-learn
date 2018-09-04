package com.java.bean;

import org.springframework.core.env.SystemEnvironmentPropertySource;

public class User {
	private String name;
	private Integer age;
	private Car car;
	
	
	public User(String name, Car car) {
		System.out.println("using gouzao");
		this.name = name;
		this.car = car;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public User() {
		System.out.println("User 被创建");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void init() {
		System.out.println("init");
	}
	public void destroy() {
	  System.out.println("destroy");
	}
	
}

package com.test.java.beandef;

public class HelloWorldBean {
	private String message;

	public void setMessage(String message) {
		this.message = message;
	}
	public void sayHello() {
		System.out.println("Hello, from "+message+"!");
	}
}

package com.test.java.beandef;

public class HelloChinaBean {
	private String message;
	private String message2;
	public void sayHello() {
		System.out.println("Hello, from "+message+"!");
	}
	public void sayHello2() {
		System.out.println("Hello, from "+message2+"!");
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage2() {
		return message2;
	}
	public void setMessage2(String message2) {
		this.message2 = message2;
	}
	public void init() {
		System.out.println("HelloChina init...");
	}
	public void destroy() {
		System.out.println("HelloChina destroy...");
	}
	
}

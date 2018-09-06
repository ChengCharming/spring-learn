package com.test.java.beanfactory;

public class MyBeanDefinition {
	private String name;
	private String className;
	private boolean singleton =true;
	
	public MyBeanDefinition() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public boolean isSingleton() {
		return singleton;
	}

	public void setSingleton(boolean singleton) {
		this.singleton = singleton;
	}
	
}

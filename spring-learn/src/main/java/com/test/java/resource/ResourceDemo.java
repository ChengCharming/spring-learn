package com.test.java.resource;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

public class ResourceDemo {
	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
		
		Resource r = context.getResource("applicationContext.xml");
		System.out.println(r.getClass());
		r = context.getResource("/applicationContext.xml");

		System.out.println(r.getClass());
		r = context.getResource("file:applicationContext.xml");
		System.out.println(r.getClass());

		r = context.getResource("classpath:applicationContext.xml");
		System.out.println(r.getClass());

		context.close();
	}
}

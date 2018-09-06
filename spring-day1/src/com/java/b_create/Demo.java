package com.java.b_create;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.bean.User;

public class Demo {
	@Test
	public void fun() {
		//创建容器对象
		//向容器要User对象
		//打印
		ClassPathXmlApplicationContext ac =new ClassPathXmlApplicationContext("/com/java/c_injection/applicationContext.xml");
		
		User u = (User) ac.getBean("user");
		
		System.out.println(u.getName()+":"+u.getAge()+u.getCar());

	}
	

}

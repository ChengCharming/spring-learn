package com.java.c_hello;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.bean.User;

public class Demo {
	@Test
	public void fun1() {
		//创建容器对象
		//向容器要User对象
		//打印
		ApplicationContext ac =new ClassPathXmlApplicationContext("applicationContext.xml");
		
		User user = (User) ac.getBean("user");
		
		System.out.println(user);
	}
}

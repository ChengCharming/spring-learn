package com.java.aop_annotation;



import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.java.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/com/java/aop_annotation/applicationContext.xml")
public class Demo {
	@Resource(name ="userService")
	private UserService us ;
	@Test
	public void fun() {
		//创建容器对象
		//向容器要User对象
		//打印
		us.save();
	}

}

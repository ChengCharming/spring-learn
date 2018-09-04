package com.java.a_annotation;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.java.bean.User;
@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class Demo {
	@Autowired
	private User u1 ;
	@Test
	public void fun() {
		//创建容器对象
		//向容器要User对象
		//打印
		System.out.println(u1);
	}

}

package com.java.b_create;

import com.java.bean.User;

public class UserFactory {
	
	public static  User createUser() {
		System.out.println("使用静态工厂创建对象");
		return new User();
	}
	public  User createUser2() {
		System.out.println("使用实例工厂创建对象");
		return new User();
	}
	
}

package com.java.c_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.java.service.UserService;
import com.java.service.UserServiceImp;

public class UserServiceProxyFactory implements InvocationHandler{
	 private UserService us;
	 
	public UserServiceProxyFactory(UserService us) {
		super();
		this.us = us;
	}

	public UserService getUserServiceProxy() {
		UserService userProxy= (UserService) Proxy.newProxyInstance(UserServiceProxyFactory.class.getClassLoader(), 
								UserServiceImp.class.getInterfaces(), this);
		return userProxy;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("开启事务");
		Object invoke = method.invoke(us, args);
		System.out.println("关闭事务");
		return invoke;
	}
}

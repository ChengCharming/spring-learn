package com.java.c_proxy;

import org.junit.Test;

import com.java.service.UserService;
import com.java.service.UserServiceImp;

public class Demo {
	@Test
	public void fun() {
		UserService us = new UserServiceImp();
		UserServiceProxyFactory factory = new UserServiceProxyFactory(us);
		UserService usProxy = factory.getUserServiceProxy();
		usProxy.delete();
	}
	
}

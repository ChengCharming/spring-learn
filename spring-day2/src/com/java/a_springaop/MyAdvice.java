package com.java.a_springaop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {
	//前置通知
	//后置通知（出现异常不会调用）
	//环绕通知
	//异常拦截通知
	//后置通知（无论是否出现异常都调用）
//----------------------------------------	
	//前置通知
	public void before() {
		System.out.println("这是前置通知");
	}
	//后置通知
	public void afterReturning() {
		System.out.println("这是后置通知（出现异常不会调用）");
	}
	//环绕通知
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("这是环绕通知（前）");
		Object proceed = pjp.proceed();//调用目标方法
		System.out.println("这是环绕通知（后）");
		return proceed;
	}
	//异常拦截通知
	public void afterException() {
		System.out.println("出事了！！！");
	}
	public void after() {
		System.out.println("这是后置通知（出现异常也会调用）");
	}
}

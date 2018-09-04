package com.java.aop_annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
//表示该类是一个通知类
public class MyAdvice {

	@Pointcut("execution(* com.java.service.*ServiceImp.*(..))")
	public void pc() {}
	//前置通知
	@Before("MyAdvice.pc()")
	public void before() {
		System.out.println("这是前置通知");
	}
	//后置通知
	@AfterReturning("MyAdvice.pc()")
	public void afterReturning() {
		System.out.println("这是后置通知（出现异常不会调用）");
	}
	//环绕通知
	@Around("MyAdvice.pc()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("这是环绕通知（前）");
		Object proceed = pjp.proceed();//调用目标方法
		System.out.println("这是环绕通知（后）");
		return proceed;
	}
	//异常拦截通知
	@AfterThrowing("MyAdvice.pc()")
	public void afterException() {
		System.out.println("出事了！！！");
	}
	@After("MyAdvice.pc()")
	public void after() {
		System.out.println("这是后置通知（出现异常也会调用）");
	}
}

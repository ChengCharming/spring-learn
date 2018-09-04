package com.test.java.beanref;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanRefDemo {

	public static void main (String agrs[]) {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("beanRef.xml");
		BeanWapper bean =context.getBean("beanWapper",BeanWapper.class);
		
		bean.getInnerBean().hello();
		bean.hello();
		System.out.println(bean.getInnerBean().getName());
		context.close();
	}
}

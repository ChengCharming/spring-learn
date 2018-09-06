package com.test.java.beandef;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanDefinitionDemo {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("beanDefinition.xml");
		
		HelloChinaBean chinaBean = context.getBean(HelloChinaBean.class);
		chinaBean.sayHello();
		chinaBean.sayHello2();
		context.close();
	}

}

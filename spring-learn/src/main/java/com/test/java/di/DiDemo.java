package com.test.java.di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DiDemo {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("di.xml");
		ConstructDiBean cdiBean = context.getBean("constructDiBean", ConstructDiBean.class);
		cdiBean.sayHello();

		PropertyDiBean pdiBean = context.getBean("pdiBean", PropertyDiBean.class);
		pdiBean.sayHello();
		pdiBean.listProperties();
		pdiBean.printMapProperties();

		context.close();
	}

}

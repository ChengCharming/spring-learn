package com.test.java.beanfactory;

public class MyBeanFactioryDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyBeanFactory factory = new MyBeanFactory();
		MyBean bean1=  factory.getBean("myBean",MyBean.class);
		bean1.say();
		MyBean bean2=  factory.getBean("myBean",MyBean.class);
		bean2.say();
		System.out.println("bean1 equals bean2:"+(bean1==bean2));

	}

}

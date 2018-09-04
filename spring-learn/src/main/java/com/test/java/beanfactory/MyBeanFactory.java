package com.test.java.beanfactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class MyBeanFactory {
	private List<MyBeanDefinition> beanDefinitions;

	private Map<String, Object> singletonBeans;
	private Map<String, MyBeanDefinition> prototypeBeans;

	public MyBeanFactory() {
		beanDefinitions = new ArrayList();
		singletonBeans = new HashMap();
		prototypeBeans = new HashMap();

		parse();
		resolveBeanDefinitions();

	}
	public <T> T getBean(String beanName,Class<T> clazz) {
			Object bean =getBean(beanName);
			if(bean.getClass().equals(clazz)) {
				return (T)bean;
			}
			throw new RuntimeException("The class is not match bena"+clazz+"but get the class"+bean.getClass());
			
	}
	public Object getBean(String beanName) {
		if (singletonBeans.containsKey(beanName)) {
			return singletonBeans.get(beanName);
		}
		MyBeanDefinition beanDefinition = prototypeBeans.get(beanName);
		if (beanDefinition != null) {

			try {
				String className = beanDefinition.getClassName();
				return Class.forName(className).newInstance();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		throw new RuntimeException("invalid bean name" + beanName);

	}

	public void parse() {
		SAXBuilder builder = new SAXBuilder();

		try {
			Document document = builder.build(new File("mybean.xml"));
			Element root = document.getRootElement();
			List<Element> beanElements = root.getChildren("bean");
			for (Element beanElement : beanElements) {
				String id = beanElement.getAttributeValue("id");
				String clazz = beanElement.getAttributeValue("class");
				String singleton = beanElement.getAttributeValue("singleton");

				MyBeanDefinition beanDefinition = new MyBeanDefinition();
				beanDefinition.setName(id);
				beanDefinition.setClassName(clazz);
				if (singleton != null) {
					boolean isSingleton = Boolean.parseBoolean(singleton);
					beanDefinition.setSingleton(isSingleton);
				}
				beanDefinitions.add(beanDefinition);
			}
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void resolveBeanDefinitions() {
		for (MyBeanDefinition beanDefinition : beanDefinitions) {
			if (beanDefinition.isSingleton()) {
				String className = beanDefinition.getClassName();
				try {
					Class<?> clazz = Class.forName(className);
					Object instance = clazz.newInstance();
					singletonBeans.put(beanDefinition.getName(), instance);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} else {
				prototypeBeans.put(beanDefinition.getName(), beanDefinition);
			}

		}
	}

}

package com.test.java.beanref;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class BeanWapper {
	@Value("ss")
	private String name;
	@Autowired
	private BeanDemo innerBean;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public BeanDemo getInnerBean() {
		return innerBean;
	}
	public void setInnerBean(BeanDemo innerBean) {
		this.innerBean = innerBean;
	}
	public void hello () {
		System.out.println("get from beanWapper "+ name );
	}
}

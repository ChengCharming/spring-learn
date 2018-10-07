package com.java.junit;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.dao.mapper.ItemsMapper;
import com.java.pojo.Items;

public class TestThis {
	
	@Test
	public void fun() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		ItemsMapper mapper = (ItemsMapper) ac.getBean("itemsMapper");
		
		
		List<Items> list = mapper.selectAll();
		for(Items i : list) {
			System.out.println(i);
		}
	}
	
}

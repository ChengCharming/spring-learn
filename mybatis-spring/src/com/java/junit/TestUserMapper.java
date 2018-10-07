package com.java.junit;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.java.mapper.UserMapper;

public class TestUserMapper {
	
	@Test
	public void testMapper() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	//	UserMapper mapper = ac.getBean(UserMapper.class);
		UserMapper mapper = (UserMapper) ac.getBean("userMapper");
		Integer c = mapper.countUser();
		System.out.println(c);
	}

}

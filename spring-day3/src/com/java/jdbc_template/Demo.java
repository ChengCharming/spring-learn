package com.java.jdbc_template;

import java.beans.PropertyVetoException;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.java.bean.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo {
	@Resource(name = "userDao")
	private UserDao us;

	@Test
	public void fun1() throws PropertyVetoException {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		// ?serverTimezone=UTC&amp;characterEncoding=UTF-8
		cpds.setDriverClass("com.mysql.jdbc.Driver");
		cpds.setJdbcUrl("jdbc:mysql://localhost:3306/sh");
		cpds.setUser("root");
		cpds.setPassword("root");

		JdbcTemplate jt = new JdbcTemplate(cpds);

		String sql = "insert into user values(null,'jn','0918')";
		jt.update(sql);

	}

	@Test
	public void fun2() {
		User u = new User();
		u.setUsername("cc");
		u.setPassword("tctc");
		us.save(u);
	}

	@Test
	public void fun3() {
		User u = new User();
		u.setUsername("cc");
		u.setId(5);
		us.update(u);
	}

	@Test
	public void fun4() {

		us.delete(3);

	}

	@Test
	public void fun5() {

		User u = us.getById(5);
		System.out.println(u);

	}
	
	@Test
	public void fun6() {

		List<User> users = us.getAll();
		for (User u : users) {
		System.out.println(u);
		}

	}
	
	@Test
	public void fun7() {

		int count =us.getTotalCount();
		System.out.println(count);

	}
}

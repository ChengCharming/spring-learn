package com.java.junit;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.java.mapper.OrderMapper;
import com.java.mapper.UserMapper;
import com.java.pojo.Orders;
import com.java.pojo.QueryVo;
import com.java.pojo.User;

public class MybatisThirdTest {

	@Test
	public void test() throws Exception {
		// 加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		// 创建sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		
		System.out.println("Do you think that our love can create miracles \n"
				+ "Yes , i do . That's what brings you back to me each time");
		
	/*	List<Orders> os = orderMapper.selectOrders();
		for (Orders orders : os) {
			System.out.println(orders);
		}*/
		
		List<User> us = orderMapper.selectUserList();
		for (User user : us) {
			System.out.println(user);
		}
		

	}
	@Test
	public void test2() throws Exception {
		// 加载核心配置文件
		String resource = "sqlSessionConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		// 创建sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		
		System.out.println("Do you think that our love can create miracles \n"
				+ "Yes , i do . That's what brings you back to me each time");
		
	/*	List<Orders> os = orderMapper.selectOrders();
		for (Orders orders : os) {
			System.out.println(orders);
		}*/
		
		List<User> us = orderMapper.selectUserList();
		for (User user : us) {
			System.out.println(user);
		}
		

	}

}

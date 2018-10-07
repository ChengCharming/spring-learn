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

public class MybatisSecondTest {

	@Test
	public void testOrders() throws Exception {
		// 加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		// 创建sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		
	/*	
		
		 * List <Orders> orders =orderMapper.selectOrdersList(); for (Orders o : orders)
		 * { System.out.println(o); }
		 
		Orders o = new Orders();
		o.setId(1);
		o.setNumber("100200");
		List <Orders> os = orderMapper.selectOrdersByidnumber(o);
		for (Orders orders : os) {
			System.out.println(orders);
		}
		Integer ids [] = new Integer [3];
		ids[0] = 1;
		ids[1] = 2;
		ids[2] = 5;
		List<Orders> os = orderMapper.selectOrdersByids(ids);
		for (Orders orders : os) {
			System.out.println(orders);
		}*/

	}

	@Test
	public void testUsers() throws Exception {
		// 加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		// 创建sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/*
		 * //1. User user = sqlSession.getMapper(UserMapper.class).findUserByid(1);
		 * System.out.println(user);
		 * 
		 * //2. List<User> us =
		 * sqlSession.getMapper(UserMapper.class).findUserByname("jn"); for(User u:us) {
		 * System.out.println(u); }
		 * 
		 * //3. User user = new User(); user.setUsername("cjb");
		 * user.setPassword("0227");
		 * sqlSession.getMapper(UserMapper.class).insertUser(user); sqlSession.commit();
		 * System.out.println(user.getId());
		 * 
		 * //4.pojo包装类 QueryVo qv =new QueryVo(); User user =new User();
		 * user.setUsername("haha"); qv.setUser(user); List<User> us =
		 * sqlSession.getMapper(UserMapper.class).findUserByQueryvo(qv); for (User u :
		 * us) { System.out.println(u); }
		 */

		// 5.输出参数之简单类型
		Integer c = sqlSession.getMapper(UserMapper.class).countUser();
		System.out.println(c);
	}

}

package com.java.junit;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.java.mapper.UserMapper;
import com.java.pojo.User;

public class MybatisSecondTest {
	
	@Test
	public void test() throws Exception {
		//加载核心配置文件
		String resource ="sqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		//创建sqlsession
		SqlSession sqlSession =sqlSessionFactory.openSession();
	
		
/*		User user = sqlSession.getMapper(UserMapper.class).findUserByid(1);
		System.out.println(user);
		
		
		List<User> us = sqlSession.getMapper(UserMapper.class).findUserByname("jn");
		for(User u:us) {
			System.out.println(u);
		}*/
		
		
		User user = new User();
		user.setUsername("cjb");
		user.setPassword("0227");
		sqlSession.getMapper(UserMapper.class).insertUser(user);
		sqlSession.commit();
		System.out.println(user.getId());
		
		
	}

	

}

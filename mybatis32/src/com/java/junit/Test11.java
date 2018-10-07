package com.java.junit;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.java.pojo.User;

public class Test11 {
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void before() throws Exception {
		//加载核心配置文件
		String resource ="sqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
	}
	
	@Test
	public void test() throws Exception {

		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行SQL
		List<User> users =sqlSession.selectList("findUserBylimit");
		for(User u:users) {
		System.out.println(u);
		}
	} 
	
	@Test
	public void test2() throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行SQL
		List<User> users =sqlSession.selectList("user.findUserByname", "jn");
		for(User u:users) {
		System.out.println(u);
		}
	} 
}

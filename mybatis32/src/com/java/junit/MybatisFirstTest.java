package com.java.junit;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.java.pojo.User;

public class MybatisFirstTest {
	
	@Test
	public void testMybatis1() throws Exception {
		//加载核心配置文件
		String resource ="sqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行SQL
		User user = sqlSession.selectOne("user.findUserByid", 1);
		
		System.out.println(user);
	
	} 
	
	@Test
	public void testMybatis2() throws Exception {
		//加载核心配置文件
		String resource ="sqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行SQL
		List<User> users =sqlSession.selectList("user.findUserByname", "jn");
		for(User u:users) {
		System.out.println(u);
		}
	} 
	
	@Test
	public void testMybatis3() throws Exception {
		//加载核心配置文件
		String resource ="sqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行SQL
		User u = new User();
		u.setUsername("heihei");
		u.setPassword("12234");
		sqlSession.insert("insertUser",u);
		sqlSession.commit();
		System.out.println(u.getId());
	} 
	@Test
	public void testMybatis4() throws Exception {
		//加载核心配置文件
		String resource ="sqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行SQL
		User u = new User();
		u.setPassword("15153");
		u.setUsername("djas");
		u.setId(4);
		sqlSession.update("updateByid", u);
		sqlSession.commit();
	} 
	@Test
	public void testMybatis5() throws Exception {
		//加载核心配置文件
		String resource ="sqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行SQL
		sqlSession.delete("deleteByid", 7);
		sqlSession.commit();
	} 
	@Test
	public void testMybatis6() throws Exception {
		//加载核心配置文件
		String resource ="sqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行SQL
		List<User> users =sqlSession.selectList("findUserBylimit");
		for(User u:users) {
		System.out.println(u);
		}
	} 
	
}

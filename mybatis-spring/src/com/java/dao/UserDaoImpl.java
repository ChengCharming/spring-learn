package com.java.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.java.pojo.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	public List<User> selectUser() {
		List<User> us =  this.getSqlSession().selectList("findUserBylimit");
		return  us;
	}
	public static void main (String args[]) {
		
		UserDaoImpl ud = new UserDaoImpl();
		List<User> us = ud.selectUser();
		for (User user : us) {
			System.out.println(user);
		}
	}
	

}

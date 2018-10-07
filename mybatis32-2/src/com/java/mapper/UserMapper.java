package com.java.mapper;

import java.util.List;

import com.java.pojo.QueryVo;
import com.java.pojo.User;

public interface UserMapper {
	public User findUserByid (Integer id) ;
	public List<User> findUserByname (String name);
	public void insertUser(User user);
	public List<User> findUserByQueryvo(QueryVo qv);
	public Integer countUser();
}

package com.java.jdbc_template;

import java.util.List;

import com.java.bean.User;

public interface UserDao {
	void save(User user);
	void delete(Integer id);
	void update(User user);
	User getById(Integer id);
	int getTotalCount();
	List<User> getAll();
} 

package com.java.pojo;

import java.io.Serializable;

public class QueryVo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}

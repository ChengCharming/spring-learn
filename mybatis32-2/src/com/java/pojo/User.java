package com.java.pojo;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id ;
	private String username;
	private String password;
	private List<Orders> ordersList;
	
	
	public List<Orders> getOrders() {
		return ordersList;
	}
	public void setOrders(List<Orders> ordersList) {
		this.ordersList = ordersList;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", ordersList=" + ordersList
				+ "]";
	}
	
	
}

package com.java.dao;

public interface AccountDao {
	//加钱
	void increaseMoney(Integer id ,double money);
	//减钱
	void decreaseMoney(Integer id ,double money); 
	
}

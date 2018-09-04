package com.java.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
 //   private JdbcTemplate jt ;
	@Override
	public void increaseMoney(Integer id, double money) {
		
	//	getJdbcTemplate()
		
	}

	@Override
	public void decreaseMoney(Integer id, double money) {
		// TODO Auto-generated method stub

	}

}

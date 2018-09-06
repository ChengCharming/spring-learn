package com.java.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
 //   private JdbcTemplate jt ;
	@Override
	public void increaseMoney(Integer id, double money) {
	String sql ="update account set money =money +? where id = ?";
	getJdbcTemplate().update(sql,money,id);
		
	}

	@Override
	public void decreaseMoney(Integer id, double money) {
		String sql ="update account set money =money -? where id = ?";
		getJdbcTemplate().update(sql,money,id);
			

	}

}

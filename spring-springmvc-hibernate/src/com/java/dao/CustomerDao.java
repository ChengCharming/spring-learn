package com.java.dao;

import java.util.List;

import com.java.bean.Customer;
import com.java.bean.QueryVo;
import com.java.utils.Page;

public interface CustomerDao {
		
	//根据四个条件查询
	public List<Customer> selectCustomerListByQueryVo(QueryVo vo);
	//查询总数
	public Integer customerCount(QueryVo vo);
	
}

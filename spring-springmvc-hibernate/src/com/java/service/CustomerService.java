package com.java.service;

import com.java.bean.Customer;
import com.java.bean.QueryVo;
import com.java.utils.Page;

public interface CustomerService {

	// 根据四个条件查询
	public Page<Customer> selectPageByQueryVo(QueryVo vo);
	
}

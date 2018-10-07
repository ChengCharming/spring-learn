package com.java.crm.service;

import com.java.crm.pojo.Customer;
import com.java.crm.pojo.QueryVo;
import com.java.crm.utils.Page;

/**
 * 客户管理
 * @author CharMing
 *
 */
public interface CustomerService {
	
	//根据四个条件查询
	public Page<Customer> selectPageByQueryVo(QueryVo vo);
	//根据id 查 customer
	public Customer selectCustomerById(Integer id);
	//修改custome
	public void updateCustomerById(Customer customer);
	//通过id 删除 customer
	public void deleteCustomerById(Integer id);
}

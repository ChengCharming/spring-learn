package com.java.crm.mapper;

import java.util.List;

import com.java.crm.pojo.Customer;
import com.java.crm.pojo.QueryVo;

public interface CustomerMapper {

	//查询总条数
	public Integer customerCount(QueryVo vo);
	//结果集
	public List<Customer> selectCustomerListByQueryVo(QueryVo vo);
	//通过id查 customer
	public Customer selectCustomerById(Integer id);
	//通过 id 修改 custome
	public void updateCustomerById(Customer customer);
	//通过id 删除 customer
	public void deleteCustomerById(Integer id);
}

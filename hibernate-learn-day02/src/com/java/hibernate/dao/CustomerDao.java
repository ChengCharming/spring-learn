package com.java.hibernate.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.java.hibernate.bean.Customer;



public interface CustomerDao {
	
	public void save(Customer c);
	public List<Customer> getCustomerAll();
	public Customer getById(Long cust_id);
	public List<Customer> getCustomerAll(DetachedCriteria dc);
}

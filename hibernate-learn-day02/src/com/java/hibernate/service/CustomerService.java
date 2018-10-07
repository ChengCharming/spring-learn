package com.java.hibernate.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.java.hibernate.bean.Customer;



public interface CustomerService {

	public void save(Customer c);
	public List<Customer> getCustomerAll();
	
	public List<Customer> getCustomerAll(DetachedCriteria dc);
}

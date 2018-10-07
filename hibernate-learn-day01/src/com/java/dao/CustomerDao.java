package com.java.dao;

import java.util.List;

import com.java.domain.Customer;

public interface CustomerDao {
	
	public void save(Customer c);
	public List<Customer> getCustomerAll();
	
}

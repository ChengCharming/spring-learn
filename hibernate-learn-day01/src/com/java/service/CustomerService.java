package com.java.service;

import java.util.List;

import com.java.domain.Customer;

public interface CustomerService {

	public void save(Customer c);
	public List<Customer> getCustomerAll();
}

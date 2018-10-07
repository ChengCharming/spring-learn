package com.java.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.java.domain.Customer;
import com.java.utils.HibernateUtils;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public void save(Customer c) {
		Session session = HibernateUtils.getCurrenSession();
		session.save(c);
	}

	@Override
	public List<Customer> getCustomerAll() {
		Session session = HibernateUtils.getCurrenSession();
		String hql ="from Customer";
		Query<Customer> query = session.createQuery(hql);
		List<Customer> list = query.list();
		return list;
	}

}

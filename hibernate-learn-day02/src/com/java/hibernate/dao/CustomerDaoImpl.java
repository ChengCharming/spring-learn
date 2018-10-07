package com.java.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.query.Query;

import com.java.hibernate.bean.Customer;
import com.java.hibernate.utils.HibernateUtils;



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

	@Override
	public Customer getById(Long cust_id) {
		Session session = HibernateUtils.getCurrenSession();
		return session.get(Customer.class, cust_id);
	}

	@Override
	public List<Customer> getCustomerAll(DetachedCriteria dc) {
		Session session = HibernateUtils.getCurrenSession();
		Criteria c = dc.getExecutableCriteria(session);
		return c.list();
	}

}

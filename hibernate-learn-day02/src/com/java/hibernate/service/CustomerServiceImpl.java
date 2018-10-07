package com.java.hibernate.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import com.java.hibernate.bean.Customer;
import com.java.hibernate.dao.CustomerDao;
import com.java.hibernate.dao.CustomerDaoImpl;
import com.java.hibernate.utils.HibernateUtils;



public class CustomerServiceImpl implements CustomerService{
	
	private CustomerDao customerDao =new CustomerDaoImpl();
	
	public void save(Customer c) {
		Session session = HibernateUtils.getCurrenSession();
		Transaction tx =session.beginTransaction();
		
		try {
			customerDao.save(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
		}
		
		tx.commit();
	}

	@Override
	public List<Customer> getCustomerAll() {
		Session session = HibernateUtils.getCurrenSession();
		Transaction tx =session.beginTransaction();
		List<Customer> list = null;
		try {
			list = customerDao.getCustomerAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
		}
		
		tx.commit();
		return  list;
	}

	@Override
	public List<Customer> getCustomerAll(DetachedCriteria dc) {
		Session session = HibernateUtils.getCurrenSession();
		Transaction tx =session.beginTransaction();
		List<Customer> list = null;
		try {
			list = customerDao.getCustomerAll(dc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
		}
		
		tx.commit();
		return  list;
	}
}

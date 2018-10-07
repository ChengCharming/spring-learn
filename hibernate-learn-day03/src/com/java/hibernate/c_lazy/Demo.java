package com.java.hibernate.c_lazy;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.java.hibernate.bean.Customer;
import com.java.hibernate.utils.HibernateUtils;

//学习Criteria语法
public class Demo {
	
	//投影查询
	@Test
	public void fun() {
		Session session = HibernateUtils.openSession();
		Transaction tx =session.beginTransaction();
		
	/*	Customer c = session.load(Customer.class, 2l);*/
		Customer c = session.get(Customer.class, 2l);
		System.out.println(c);
		
		tx.commit();
		session.close();
	}
	
	
}

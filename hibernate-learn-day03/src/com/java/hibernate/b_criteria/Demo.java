package com.java.hibernate.b_criteria;

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
		
		Criteria c =session.createCriteria(Customer.class);
	    List<Customer> list = c.list();
	    for (Customer customer : list) {
			System.out.println(customer);
		}
		
		tx.commit();
		session.close();
	}
	
	
}

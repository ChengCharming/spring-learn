package com.java.hibernate.d_lazy_fetch;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.java.hibernate.bean.Customer;
import com.java.hibernate.bean.LinkMan;
import com.java.hibernate.utils.HibernateUtils;

//学习Criteria语法
public class Demo {
	
	//集合级别的关联
	@Test
	public void fun() {
		Session session = HibernateUtils.openSession();
		Transaction tx =session.beginTransaction();
		
		Customer c = session.get(Customer.class, 2l);
		
		Set<LinkMan> set = c.getLinkMans();
		for (LinkMan lm : set) {
			System.out.println(lm);
		}
		tx.commit();
		session.close();
	}
	
	
}

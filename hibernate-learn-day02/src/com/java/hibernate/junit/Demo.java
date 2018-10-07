package com.java.hibernate.junit;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.java.hibernate.bean.Customer;
import com.java.hibernate.bean.LinkMan;
import com.java.hibernate.utils.HibernateUtils;

public class Demo {
	@Test
	public void fun() {
		Session session = HibernateUtils.getCurrenSession();
		Transaction tx = session.beginTransaction();
		
		Customer c =new Customer();
		c.setCust_name("charming");
		
		LinkMan lkm1= new LinkMan();
		lkm1.setLkm_name("lkm1");
		LinkMan lkm2= new LinkMan();
		lkm2.setLkm_name("lkm2");
		
		c.getLinkMans().add(lkm1);
		c.getLinkMans().add(lkm2);
		
	/*	lkm1.setCustomer(c);
		lkm2.setCustomer(c);
		*/
		session.save(c);
		session.save(lkm1);
		session.save(lkm2);
		
		tx.commit();
	}
	@Test
	//为客户增加联系人
	public void fun1() {
		Session session = HibernateUtils.getCurrenSession();
		Transaction tx = session.beginTransaction();
		
		Customer c = session.get(Customer.class, 1l);
		
		LinkMan lkm = new LinkMan();
		lkm.setLkm_name("lkm3");
		c.getLinkMans().add(lkm);
		lkm.setCustomer(c);
		session.save(lkm);
		
		tx.commit();
	}
	@Test
	//为客户删除联系人
	public void fun2() {
		Session session = HibernateUtils.getCurrenSession();
		Transaction tx = session.beginTransaction();
		
		Customer c = session.get(Customer.class, 1l);
		
		LinkMan lkm = session.get(LinkMan.class, 3l);
		c.getLinkMans().remove(lkm);
		lkm.setCustomer(null);
//		session.delete(lkm);
		
		tx.commit();
	}
	
}

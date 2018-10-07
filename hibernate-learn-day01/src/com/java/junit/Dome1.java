package com.java.junit;

import java.util.Arrays;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

import com.java.domain.Customer;
import com.java.utils.HibernateUtils;

public class Dome1 {

	@Test
	public void fun1() {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		
		Customer customer = new Customer();
		customer.setCust_name("char");
		session.save(customer);
		
		
		tx.commit();
		session.close();
		sf.close();
	}
	@Test
	public void fun2() {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		
		Customer customer = session.get(Customer.class, 1l);
		System.out.println(customer);
		
		
		tx.commit();
		session.close();
		sf.close();
	}
	@Test
	public void fun3() {
		Session session = HibernateUtils.openSession();
		//4 session获得操作事务的Transaction对象
		//获得操作事务的tx对象
		//Transaction tx = session.getTransaction();
		//开启事务并获得操作事务的tx对象(建议使用)
		Transaction tx =session.beginTransaction();
		
		Customer customer = session.get(Customer.class, 1l);
		System.out.println(customer);
		
		
		tx.commit();
		session.close();
	}
	//修改id为1的customer的name 为  jinnan
	@Test
	public void fun4() {
		Session session = HibernateUtils.openSession();
		//4 session获得操作事务的Transaction对象
		//获得操作事务的tx对象
		//Transaction tx = session.getTransaction();
		//开启事务并获得操作事务的tx对象(建议使用)
		Transaction tx =session.beginTransaction();
		
		Customer customer = session.get(Customer.class, 1l);
		customer.setCust_name("jinnan");
		session.update(customer);
		
		tx.commit();
		session.close();
	}
	@Test
	public void fun5() {
		Session session = HibernateUtils.getCurrenSession();
		Transaction tx =session.beginTransaction();
		
		String hql ="from Customer where cust_id =1 ";
		
		Query query = session.createQuery(hql);
		
		Customer c = (Customer) query.uniqueResult();
		tx.commit();
		System.out.println(c);
	}
	@Test
	public void fun6() {
		Session session = HibernateUtils.getCurrenSession();
		Transaction tx =session.beginTransaction();
		
		String sql="select * from cst_customer";
		
		SQLQuery query =session.createSQLQuery(sql);
		List<Object[]> list = query.list();
		
	//	query.addEntity(Customer.class);
	//	List<Customer> list =query.list();
		
		tx.commit();
		
		for(Object[] obj: list)
		{
		System.out.println(Arrays.toString(obj));
		}
	}
	
	
}

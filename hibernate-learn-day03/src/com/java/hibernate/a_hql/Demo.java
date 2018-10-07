package com.java.hibernate.a_hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import com.java.hibernate.bean.LinkMan;
import com.java.hibernate.utils.HibernateUtils;
//HQL 学习
public class Demo {
	
	//投影查询
	@Test
	public void fun6() {
		Session session = HibernateUtils.openSession();
		Transaction tx =session.beginTransaction();
		
	    String hql ="select lkm_name from LinkMan";
	   
	    Query query = session.createQuery(hql);
	    List list = query.list();
	    
	    System.out.println(list);
	    
		tx.commit();
		session.close();
	}
	//统计查询
	/*
	count
	sum
	max
	avg
	min
	*/
	@Test
	public void fun5() {
		Session session = HibernateUtils.openSession();
		Transaction tx =session.beginTransaction();
		
	    String hql ="select count(*) from LinkMan";
	    String hql2 ="select sum(lkm_id) from LinkMan";
	    String hql3 ="select avg(lkm_id) from LinkMan";
	    String hql4 ="select min(lkm_id) from LinkMan";
	    String hql5 ="select max(lkm_id) from LinkMan";
	  
	    Query query = session.createQuery(hql2);
		
		Number no = (Number) query.uniqueResult();
	    System.out.println(no);
		tx.commit();
		session.close();
	}
	//分页
	@Test
	public void fun4() {
		Session session = HibernateUtils.openSession();
		Transaction tx =session.beginTransaction();
		
	    String hql ="from LinkMan";
	  
	    Query query = session.createQuery(hql);
	    query.setFirstResult(0);
	    query.setMaxResults(2);
	    
		List<LinkMan> list = query.list();
		
		for (LinkMan lm : list) {
			System.out.println(lm);
		}
		
		
		tx.commit();
		session.close();
	}

	
	//条件查询
	@Test
	public void fun3() {
		Session session = HibernateUtils.openSession();
		Transaction tx =session.beginTransaction();
		
	    String hql ="from LinkMan where lkm_id =?0";
	    String hql2 ="from LinkMan where lkm_id =:id ";
	
	    Query query = session.createQuery(hql2);
	    query.setParameter("id", 3l);
	    
	    
		List<LinkMan> list = query.list();
		
		for (LinkMan lm : list) {
			System.out.println(lm);
		}
		
		
		tx.commit();
		session.close();
	}
	
	//排序
	@Test
	public void fun2() {
		Session session = HibernateUtils.openSession();
		Transaction tx =session.beginTransaction();
		
	    String hql ="from LinkMan order by lkm_mobile asc";
	    String hql2 ="from LinkMan order by lkm_mobile desc";
		Query query = session.createQuery(hql2);
		
		List<LinkMan> list = query.list();
		
		for (LinkMan lm : list) {
			System.out.println(lm);
		}
		
		
		tx.commit();
		session.close();
	}
	//基本语法
	@Test
	public void fun() {
		Session session = HibernateUtils.openSession();
		Transaction tx =session.beginTransaction();
		
		String hql1 = "from com.java.hibernate.bean.Customer";
		String hql2 = "from Customer";
		String hql3 = "from java.lang.Object";
		Query query = session.createQuery(hql3);
		
		List list = query.list();
		
		for (Object object : list) {
			System.out.println(object);
		}
		
		
		tx.commit();
		session.close();
	}
	
}

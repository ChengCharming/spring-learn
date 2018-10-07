package com.java.hibernate.a_hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import com.java.hibernate.bean.Customer;
import com.java.hibernate.utils.HibernateUtils;


//HQL 学习 - 多表查询
public class Demo2 {
	
	//内连接 迫切 把结果封装成一个对象
		@Test
		public void fun2() {
			Session session = HibernateUtils.openSession();
			Transaction tx =session.beginTransaction();
			// select * from A inner join B on a.id = b.id
		    String hql =" from Customer c inner join fetch c.linkMans ";
		    Query query = session.createQuery(hql);
		    List<Customer> list = query.list();
		    
		    for (Customer arr : list) {
				System.out.println(arr);
			}
		    
		    
			tx.commit();
			session.close();
		}
	
	//内连接
	@Test
	public void fun() {
		Session session = HibernateUtils.openSession();
		Transaction tx =session.beginTransaction();
		// select * from A inner join B on a.id = b.id
	    String hql =" from Customer c inner join c.linkMans order by cust_id asc";
	    Query query = session.createQuery(hql);
	    List<Object[]> list = query.list();
	    
	    for (Object[] arr : list) {
			System.out.println(Arrays.toString(arr));
		}
	    
	    
		tx.commit();
		session.close();
	}
	
	
}

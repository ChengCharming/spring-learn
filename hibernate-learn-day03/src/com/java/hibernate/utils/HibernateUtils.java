package com.java.hibernate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
	private static SessionFactory sf;
	
	static {
		Configuration cfg =new Configuration().configure();
		sf = cfg.buildSessionFactory();
	}
	public static Session openSession() {
		Session session=sf.openSession();
		return session;
	}
	//获得与线程绑定的session
	public static Session getCurrenSession() {
		//通过 getCurrentSession 方法获得的 session 在 提交事务的时候会自动 关闭
		Session session=sf.getCurrentSession();
		return session;
	}
	public static void main(String args[]) {
		System.out.println(HibernateUtils.openSession());
	}
	
}

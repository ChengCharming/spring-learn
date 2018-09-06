package com.java.spihibernate.service;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.spihibernate.bean.User;

@Repository
public class HibernateManager {

	@Autowired
	protected SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public Session getNewSession() {
		return sessionFactory.openSession();
	}

	public void flush() {
		getSession().flush();
	}

	public void clear() {
		getSession().clear();
	}

	public <T> T get(Class<T> c, String id) {
		Session session = getSession();
		return session.load(c, id);
	}

	public <T> List<T> getAllList(Class<T> c) {
		Session session = getSession();
		DetachedCriteria dc = DetachedCriteria.forClass(c);
		return dc.getExecutableCriteria(session).list();
	}

	public <T> long getTatleCount(Class<T> c) {
		return getAllList(c).size();
	}
	public <T> T getObjectByName(Class<T> clazz ,String name) {
		DetachedCriteria criteria = DetachedCriteria.forClass(clazz);
		criteria.add(Restrictions.eq("name", name));
		Criteria result = criteria.getExecutableCriteria(getSession());
		T object =(T) result.uniqueResult();
		return object;
	}
	
	public <T> T getObjectByCode(Class<T> clazz, String code) {
		DetachedCriteria criteria = DetachedCriteria.forClass(clazz);
		criteria.add(Restrictions.eq("code", code));
		Criteria result = criteria.getExecutableCriteria(getSession());
		T object = (T) result.uniqueResult();
		return object;
	}
	public <T> T getObjectByUser(Class<T> clazz, String username,String password) {
		DetachedCriteria criteria = DetachedCriteria.forClass(clazz);
		criteria.add(Restrictions.eq("username", username));
		criteria.add(Restrictions.eq("password", password));
		Criteria result = criteria.getExecutableCriteria(getSession());
		T object = (T) result.uniqueResult();
		return object;
		
	}
	public void save(Object bean) {
		try {
			getSession().save(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

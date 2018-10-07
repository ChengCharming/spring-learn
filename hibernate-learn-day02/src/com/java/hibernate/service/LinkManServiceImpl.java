package com.java.hibernate.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.java.hibernate.bean.Customer;
import com.java.hibernate.bean.LinkMan;
import com.java.hibernate.dao.CustomerDao;
import com.java.hibernate.dao.CustomerDaoImpl;
import com.java.hibernate.dao.LinkManDao;
import com.java.hibernate.dao.LinkManDaoImpl;
import com.java.hibernate.utils.HibernateUtils;

public class LinkManServiceImpl implements LinkManService {

	private LinkManDao linkManDao =new LinkManDaoImpl();
	private CustomerDao customerDao= new CustomerDaoImpl();
	@Override
	public void save(LinkMan lm) {
		HibernateUtils.getCurrenSession().beginTransaction();
		
		
		try {
			Customer c = customerDao.getById(lm.getCust_id());
			lm.setCustomer(c);
			linkManDao.save(lm);
		} catch (Exception e) {
			e.printStackTrace();
			HibernateUtils.getCurrenSession().getTransaction().rollback();
		}
		
		HibernateUtils.getCurrenSession().getTransaction().commit();
	}
	@Override
	public List<LinkMan> getLinkManAll() {
	HibernateUtils.getCurrenSession().beginTransaction();
		
		List<LinkMan> list = null;
		try {
			list = linkManDao.getLinkManAll();
		} catch (Exception e) {
			e.printStackTrace();
			HibernateUtils.getCurrenSession().getTransaction().rollback();
		}
		
		HibernateUtils.getCurrenSession().getTransaction().commit();
		return list;
	}
	@Override
	public List<LinkMan> getLinkMan(DetachedCriteria dc) {
HibernateUtils.getCurrenSession().beginTransaction();
		
		List<LinkMan> list = null;
		try {
			list = linkManDao.getLinkMan(dc);
		} catch (Exception e) {
			e.printStackTrace();
			HibernateUtils.getCurrenSession().getTransaction().rollback();
		}
		
		HibernateUtils.getCurrenSession().getTransaction().commit();
		return list;
	}
		
}

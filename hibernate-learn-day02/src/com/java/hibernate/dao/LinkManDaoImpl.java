package com.java.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.query.Query;

import com.java.hibernate.bean.LinkMan;
import com.java.hibernate.utils.HibernateUtils;

public class LinkManDaoImpl implements LinkManDao {

	@Override
	public void save(LinkMan lm) {
		Session session = HibernateUtils.getCurrenSession();
		session.save(lm);
	}

	@Override
	public List<LinkMan> getLinkManAll() {
		Session session = HibernateUtils.getCurrenSession();
		Query query = session.createQuery("from LinkMan");
		List<LinkMan> list = query.list();
		
		return list;
	}

	@Override
	public List<LinkMan> getLinkMan(DetachedCriteria dc) {
		Session session = HibernateUtils.getCurrenSession();
		Criteria c = dc.getExecutableCriteria(session);
		return c.list();
	}

}

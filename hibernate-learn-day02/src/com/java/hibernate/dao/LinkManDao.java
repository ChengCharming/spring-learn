package com.java.hibernate.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.java.hibernate.bean.LinkMan;

public interface LinkManDao {

	public void save(LinkMan lm);
	public List<LinkMan> getLinkManAll();
	public List<LinkMan> getLinkMan(DetachedCriteria dc);
}

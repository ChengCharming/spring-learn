package com.java.hibernate.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.java.hibernate.bean.LinkMan;

public interface LinkManService {
	
	public void save(LinkMan lm);
	public List<LinkMan> getLinkManAll();
	public List<LinkMan> getLinkMan(DetachedCriteria dc);
}

package com.java.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java.bean.BaseDict;
@Repository
@Transactional
public class BaseDictDaoImpl implements BaseDictDao {
	@Resource
	private SessionFactory sessionFactory;
	
/*	获得当前session*/
    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }  
	@Override
	public List<BaseDict> selectBaseDictByCode(String code) {
		Query query =this.getSession().createQuery("from BaseDict where dict_type_code = ?");
		query.setParameter(0, code);
		return query.list();
	}

}

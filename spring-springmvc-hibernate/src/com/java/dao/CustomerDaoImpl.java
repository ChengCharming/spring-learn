package com.java.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java.bean.Customer;
import com.java.bean.QueryVo;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private SessionFactory sessionFactory;

	/*	获得当前session*/
    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

	@Override
	public Integer customerCount(QueryVo vo) {
		String hql = "select count(1) from Customer where 1=1";
		
		Query query = this.getSession().createQuery(hql);

		if (vo.getCustName() != null && !"".equals(vo.getCustName())) {
			hql =hql+ " and cust_name like ?";
			query = this.getSession().createQuery(hql);
			query.setParameter(0,vo.getCustName());
		}
		if (vo.getCustIndustry() != null && !"".equals(vo.getCustIndustry())) {
			hql =hql+" and cust_industry = :cust_industry";
			query = this.getSession().createQuery(hql);
			query.setParameter("cust_industry", vo.getCustIndustry());
		}
		if (vo.getCustSource() != null && !"".equals(vo.getCustSource())) {
			hql =hql+" and cust_source = :cust_source";
			query = this.getSession().createQuery(hql);
			query.setParameter("cust_source", vo.getCustSource());
		}
		if (vo.getCustLevel() != null && !"".equals(vo.getCustLevel())) {
			hql =hql+" and cust_level = :cust_level";
			query = this.getSession().createQuery(hql);
			query.setParameter("cust_level", vo.getCustLevel());
		}
		long temp = (Long) query.uniqueResult(); 
		int result = (int) temp;
		return result;

	}
    
    @Override
	public List<Customer> selectCustomerListByQueryVo(QueryVo vo) {
		String hql = "from Customer where 1=1";

		Query query = this.getSession().createQuery(hql);

		if (vo.getCustName() != null && !"".equals(vo.getCustName())) {
			hql =hql+ " and cust_name like ?";
			query = this.getSession().createQuery(hql);
			query.setParameter(0,vo.getCustName());
		}
		if (vo.getCustIndustry() != null && !"".equals(vo.getCustIndustry())) {
			hql =hql+" and cust_industry = :cust_industry";
			query = this.getSession().createQuery(hql);
			query.setParameter("cust_industry", vo.getCustIndustry());
		}
		if (vo.getCustSource() != null && !"".equals(vo.getCustSource())) {
			hql =hql+" and cust_source = :cust_source";
			query = this.getSession().createQuery(hql);
			query.setParameter("cust_source", vo.getCustSource());
		}
		if (vo.getCustLevel() != null && !"".equals(vo.getCustLevel())) {
			hql =hql+" and cust_level = :cust_level";
			query = this.getSession().createQuery(hql);
			query.setParameter("cust_level", vo.getCustLevel());
		}
		return query.list();
	}



}

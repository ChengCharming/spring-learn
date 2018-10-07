package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.bean.Customer;
import com.java.bean.QueryVo;
import com.java.dao.CustomerDao;
import com.java.utils.Page;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	// 根据四个条件查询
	@Override
	public Page<Customer> selectPageByQueryVo(QueryVo vo) {
		Page<Customer> page = new Page<Customer>();
		//每页输
		page.setSize(5);
		if (null != vo) {
			if (null != vo.getPage()) {
				page.setPage(vo.getPage());
				vo.setStartRow((vo.getPage() - 1)*vo.getSize());
			}
			if (null != vo.getCustName() && !"".equals(vo.getCustName().trim())) {
				vo.setCustName(vo.getCustName().trim());
			}
			if (null != vo.getCustSource() && !"".equals(vo.getCustSource().trim())) {
				vo.setCustSource(vo.getCustSource().trim());
			}
			if (null != vo.getCustIndustry() && !"".equals(vo.getCustIndustry().trim())) {
				vo.setCustIndustry(vo.getCustIndustry().trim());
			}
			if (null != vo.getCustLevel() && !"".equals(vo.getCustLevel().trim())) {
				vo.setCustLevel(vo.getCustLevel().trim());
			}
			//总条数
			page.setTotal(customerDao.customerCount(vo));
	//		System.out.println("==========================="+vo.getStartRow()+vo.getSize()+vo.getPage());
			page.setRows(customerDao.selectCustomerListByQueryVo(vo));
		}

		return page;
	}
	
}

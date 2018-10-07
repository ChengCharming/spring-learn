package com.java.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.crm.mapper.CustomerMapper;
import com.java.crm.pojo.Customer;
import com.java.crm.pojo.QueryVo;
import com.java.crm.utils.Page;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;

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
			page.setTotal(customerMapper.customerCount(vo));
			System.out.println("==========================="+vo.getStartRow()+vo.getSize()+vo.getPage());
			page.setRows(customerMapper.selectCustomerListByQueryVo(vo));
		}

		return page;
	}

	@Override
	public Customer selectCustomerById(Integer id) {
		Customer customer = customerMapper.selectCustomerById(id);
		return customer;
	}

	@Override
	public void updateCustomerById(Customer customer) {
		customerMapper.updateCustomerById(customer);
	}

	@Override
	public void deleteCustomerById(Integer id) {
		customerMapper.deleteCustomerById(id);
	}

}

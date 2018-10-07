package com.java.crm.controller;

import java.util.List;

import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.crm.pojo.BaseDict;
import com.java.crm.pojo.Customer;
import com.java.crm.pojo.QueryVo;
import com.java.crm.service.BaseDictService;
import com.java.crm.service.CustomerService;
import com.java.crm.utils.Page;
@Controller
public class CustomerController {
	
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/customer/list")
	public String requeryControllerList(QueryVo vo,Model model) {
		
		List<BaseDict> fromType = baseDictService.selectBaseDictListByCode("002");
		List<BaseDict> industryType = baseDictService.selectBaseDictListByCode("001");
		List<BaseDict> levelType = baseDictService.selectBaseDictListByCode("006");
		
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		//根据四个条件查询
		Page<Customer> page =customerService.selectPageByQueryVo(vo);
		model.addAttribute("page", page);
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		return "customer";
	}
	@RequestMapping(value="/customer/edit.action")
	public@ResponseBody 
	Customer edit(Integer id) {
		return customerService.selectCustomerById(id);
	}
	@RequestMapping(value="/customer/update.action")
	public@ResponseBody
	String updateCustomer(Customer customer) {
		customerService.updateCustomerById(customer);
		return "ok";
	}
	@RequestMapping(value="/customer/delete.action")
	public@ResponseBody
	String deleteCustomer(Integer id) {
		customerService.deleteCustomerById(id);
		return "ok";
	}
}

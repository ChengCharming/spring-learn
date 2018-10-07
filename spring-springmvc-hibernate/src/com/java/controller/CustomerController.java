package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.bean.BaseDict;
import com.java.bean.Customer;
import com.java.bean.QueryVo;
import com.java.service.BaseDictService;
import com.java.service.CustomerService;
import com.java.utils.Page;
@Controller
public class CustomerController {
	
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/customer/list")
	public String list(QueryVo vo ,Model model) {
		List<BaseDict> fromType = baseDictService.selectBaseDictByCode("002");
		List<BaseDict> industryType = baseDictService.selectBaseDictByCode("001");
		List<BaseDict> levelType = baseDictService.selectBaseDictByCode("006");
		
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		Page<Customer> page = customerService.selectPageByQueryVo(vo);
		model.addAttribute("page", page);
		
		return "customer";
	}
	
}

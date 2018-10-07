package com.java.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.java.domain.Customer;
import com.java.service.CustomerService;
import com.java.service.CustomerServiceImpl;

public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CustomerService customerService =  new CustomerServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer c =new Customer();
		try {
			BeanUtils.populate(c, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		customerService.save(c);
		//重定向到客户列表
		response.sendRedirect(request.getContextPath()+"/ListCustomerServlet");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
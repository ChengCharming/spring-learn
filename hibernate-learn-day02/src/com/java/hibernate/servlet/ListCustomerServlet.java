package com.java.hibernate.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.java.hibernate.bean.Customer;
import com.java.hibernate.service.CustomerService;
import com.java.hibernate.service.CustomerServiceImpl;



/**
 * Servlet implementation class ListCustomerServlet
 */
public class ListCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService customerService = new CustomerServiceImpl();
    public ListCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cust_name = request.getParameter("cust_name");
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		
		
		if(cust_name !=null &&!"".equals(cust_name)) {
			dc.add(Restrictions.like("cust_name", cust_name));
		}
		
		
		List<Customer> list = customerService.getCustomerAll(dc);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/jsp/customer/list.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}

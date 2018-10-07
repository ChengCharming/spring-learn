package com.java.hibernate.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.java.hibernate.bean.LinkMan;
import com.java.hibernate.service.LinkManService;
import com.java.hibernate.service.LinkManServiceImpl;

/**
 * Servlet implementation class AddLinkManServlet
 */
public class AddLinkManServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private LinkManService linkManService =new LinkManServiceImpl();
	
	public AddLinkManServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LinkMan lm = new LinkMan();
		try {
			BeanUtils.populate(lm, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		linkManService.save(lm);
		response.sendRedirect(request.getContextPath()+"/ListLinkManServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

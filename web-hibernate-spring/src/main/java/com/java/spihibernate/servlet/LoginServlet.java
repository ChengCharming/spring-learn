package com.java.spihibernate.servlet;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.java.spihibernate.bean.User;
import com.java.spihibernate.service.ExpenseService;
import com.java.spihibernate.util.StringUtil;





public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		WebApplicationContext wc =
				WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
			ExpenseService service= wc.getBean(ExpenseService.class);
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		if(StringUtil.isEmpty(username)||StringUtil.isEmpty(password)) {
			req.setAttribute("err", "用户名或密码为空");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			return;
		}	User currenUser=null;
			 currenUser = service.getUser(username, password);
			if(currenUser==null) {
				req.setAttribute("err", "用户名或密码错误");
				req.getRequestDispatcher("index.jsp").forward(req, resp);
				return;
			}else {
				req.getRequestDispatcher("main.jsp").forward(req, resp);
			}
			
		
	}

}

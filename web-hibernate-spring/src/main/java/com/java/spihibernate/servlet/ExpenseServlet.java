package com.java.spihibernate.servlet;



import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.java.spihibernate.bean.Category;
import com.java.spihibernate.bean.Expense;
import com.java.spihibernate.service.ExpenseService;


public class ExpenseServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		WebApplicationContext wc =
			WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		ExpenseService service= wc.getBean(ExpenseService.class);
		Expense dExpense =new Expense();
		dExpense.setAmount(Math.random()*100);
		dExpense.setDate(new Date(0));
		dExpense.setMemo("expense11");
		
		Category category =service.getCategoryByCode("N/A");
		dExpense.setCategory(category);
		service.saveExpense(dExpense);
		
		OutputStream os = resp.getOutputStream();
		os.write("Success".getBytes());
		os.flush();
		os.close();
		
	}
	
	
}

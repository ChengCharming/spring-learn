package com.java.spihibernate.servlet;



import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.java.spihibernate.bean.Expense;
import com.java.spihibernate.service.ExpenseService;

public class ListExpenseServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		WebApplicationContext wc = 
				WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		
		ExpenseService service = wc.getBean(ExpenseService.class);
		List<Expense> expenses =service.listAllExpense();
		StringBuilder sb = new StringBuilder();
		for(Expense exp:expenses) {
			sb.append(exp.toString()).append("\n");
		}
		OutputStream os = resp.getOutputStream();
		os.write(sb.toString().getBytes());
		os.flush();
		os.close();
	}

}

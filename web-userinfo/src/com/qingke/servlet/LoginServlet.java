package com.qingke.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.qingke.bean.User;
import com.qingke.dao.UserDao;
import com.qingke.util.ConnectionUtil;
import com.qingke.util.StringUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDao userdao =new UserDao();
    private ConnectionUtil cU= new ConnectionUtil();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		request.setAttribute("userName", userName);
		request.setAttribute("password", password);
		if(StringUtil.isEmpty(userName)||StringUtil.isEmpty(password)) {
			request.setAttribute("err", "用户名或密码为空");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		User user =new User(userName,password);
		Connection conn=null;
		try {
			conn=cU.getCon();
			User currenUser = userdao.login(conn, user);
			if(currenUser==null) {
				request.setAttribute("err", "用户名或密码错误");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("userName", userName);
				session.setAttribute("currenUser", currenUser);
				response.sendRedirect("main.jsp");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			cU.closeCon(conn);
		}
		 
	}

}

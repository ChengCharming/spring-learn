package com.qingke.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qingke.bean.User;
import com.qingke.dao.UserDao;
import com.qingke.util.ConnectionUtil;
import com.qingke.util.StringUtil;

/**
 * Servlet implementation class SignServlet
 */
@WebServlet("/SignServlet")
public class SignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDao userdao =new UserDao();
    private ConnectionUtil cU= new ConnectionUtil();   

    public SignServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		if(StringUtil.isEmpty(userName)||StringUtil.isEmpty(password)) {
			request.setAttribute("err", "用户名或密码为空");
			request.getRequestDispatcher("sign.jsp").forward(request, response);
			return;
		}
		User user =new User(userName,password);
		Connection conn=null;
		try {
			conn=cU.getCon();
			if(userdao.has(conn,userName)) {
				request.setAttribute("err", "用户名已存在");
				request.getRequestDispatcher("sign.jsp").forward(request, response);;
				return;
			}
			
			userdao.sign(conn, user);
			request.setAttribute("err", "注册成功！");
			request.getRequestDispatcher("sign.jsp").forward(request, response);;
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

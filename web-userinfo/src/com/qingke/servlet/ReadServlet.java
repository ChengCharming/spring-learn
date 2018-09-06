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

import com.qingke.bean.Major;
import com.qingke.bean.User;
import com.qingke.dao.UserDao;
import com.qingke.util.ConnectionUtil;

/**
 * Servlet implementation class ReadServlet
 */
@WebServlet("/ReadServlet")
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao dao = new UserDao();
	private ConnectionUtil cU= new ConnectionUtil();
    public ReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User currenUser =(User) session.getAttribute("currenUser");
		Connection conn=null;
		try {
			 conn =cU.getCon();
			Major major = dao.getMajor(conn, currenUser);
			if(major == null) {
				request.setAttribute("err", "尚未存在成绩信息，请添加");
				request.getRequestDispatcher("main.jsp").forward(request, response);
			}else {
				session.setAttribute("math", major.getMath());
				session.setAttribute("chinese", major.getChinese());
				session.setAttribute("english", major.getEnglish());
				request.getRequestDispatcher("read.jsp").forward(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}

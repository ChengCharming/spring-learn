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

import com.qingke.bean.Major;
import com.qingke.bean.User;
import com.qingke.dao.UserDao;
import com.qingke.util.ConnectionUtil;
import com.qingke.util.StringUtil;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao dao = new UserDao();
	private ConnectionUtil cU = new ConnectionUtil();

	public AddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Major major = null;
		Connection conn = null;
		HttpSession session = request.getSession();
		User currenUser = (User) session.getAttribute("currenUser");
		int math = Integer.valueOf(request.getParameter("math"));
		int chinese = Integer.valueOf(request.getParameter("chinese"));
		int english = Integer.valueOf(request.getParameter("english"));
		try {
			conn = cU.getCon();
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			if (dao.getMajor(conn, currenUser) != null) {
				request.setAttribute("err", "成绩已存在，请勿重复添加！");
				request.getRequestDispatcher("add.jsp").forward(request, response);;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (math < 0 || math > 100 || chinese < 0 || chinese > 100 || english < 0 || english > 100) {
			request.setAttribute("err", "请输入正确的成绩（0~100）！");
			request.getRequestDispatcher("add.jsp").forward(request, response);;
		}

		else {
			try {
				major= new Major();
				major.setChinese(chinese);
				major.setEnglish(english);
				major.setMath(math);
				dao.addMajor(conn, currenUser, major);
				request.setAttribute("err", "成绩添加成功");
				request.getRequestDispatcher("add.jsp").forward(request, response);;
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				cU.closeCon(conn);
			}

		}

	}

}

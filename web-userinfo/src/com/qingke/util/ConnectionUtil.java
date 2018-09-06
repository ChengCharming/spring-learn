package com.qingke.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private String url = "jdbc:mysql://localhost:3306/db_studentinfo?useSSL=false";
	private String user = "root";
	private String password = "root";
	private String jdbcName = "com.mysql.jdbc.Driver";

	public Connection getCon() throws ClassNotFoundException, SQLException {
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(url, user, password);
		return con;

	}

	public void closeCon(Connection con)  {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String args[]) {
		ConnectionUtil db = new ConnectionUtil();

		try {
			db.getCon();
			System.out.println("数据库连接成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
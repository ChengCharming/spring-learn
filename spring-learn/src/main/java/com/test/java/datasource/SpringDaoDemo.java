package com.test.java.datasource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDaoDemo {

	public static void main(String agrs[]) throws SQLException {
		ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
	
		DataSource ds =(DataSource) context.getBean("dataSource");
		System.out.println("Connection get from dataSource:"+ds.getConnection());
		
		DataSource ds2 =(DataSource) context.getBean("dataSource2");
		System.out.println("Connection get from dataSource:"+ds.getConnection());
		
		DataSource ds3 =(DataSource) context.getBean("dataSource3");
		System.out.println("Connection get from dataSource:"+ds.getConnection());
		
		String sql ="select * from emp";
		Connection conn =ds2.getConnection();
		PreparedStatement st= conn.prepareStatement(sql);
		ResultSet rs =st.executeQuery();
		while(rs.next()){
			System.out.println(rs.getInt("empno"));
		}
		rs.close();
		st.close();
		if(conn!=null) {
			conn.close();
		}
		
	}
	
}

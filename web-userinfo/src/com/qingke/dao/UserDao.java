package com.qingke.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qingke.bean.Major;
import com.qingke.bean.User;
import com.qingke.util.ConnectionUtil;

public class UserDao {
	
	public User login(Connection conn,User user) throws SQLException {
		User resultUser =null;
		String sql="select * from t_user where userName=? and password=?";
		PreparedStatement ps =conn.prepareStatement(sql);
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getPassword());
		ResultSet rs =ps.executeQuery();
		while(rs.next()) {
			resultUser =new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassword(rs.getString("password"));
		}
		ps.close();
		rs.close();
		return resultUser;
	}
	public void sign(Connection conn,User user) throws SQLException {
		String sql="insert into t_user (userName,password) values(?,?)";
		PreparedStatement ps =conn.prepareStatement(sql);
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getPassword());
		ps.executeUpdate();
		ps.close();
	}
	public  boolean has(Connection conn,String userName) throws SQLException {
		String sql ="select * from t_user where userName= ?";
		boolean flag =false;
		PreparedStatement ps =conn.prepareStatement(sql);
		ps.setString(1, userName);
		ResultSet rs= ps.executeQuery();
		if(rs.next()) {
			flag=true;
		}
		return flag;
	}
	public Major getMajor(Connection conn,User currenUser) throws SQLException {
		Major major = null;
		String sql ="select * from major where id =(select id from t_user where id =?)";
		PreparedStatement ps =conn.prepareStatement(sql);
		ps.setInt(1, currenUser.getId());
		ResultSet rs =ps.executeQuery();
		while(rs.next()) {
			major = new Major();
			major.setId(rs.getInt("id"));
			major.setMath(rs.getInt("math"));
			major.setChinese(rs.getInt("chinese"));
			major.setEnglish(rs.getInt("english"));
		}
		rs.close();
		ps.close();
		return major;
	}
	public void addMajor(Connection conn,User currenUser,Major major) throws SQLException {
		String sql="insert into major values(?,?,?,?)";
		PreparedStatement ps =conn.prepareStatement(sql);
		ps.setInt(1,currenUser.getId());
		ps.setInt(2,major.getMath());
		ps.setInt(3, major.getChinese());
		ps.setInt(4, major.getEnglish());
		ps.executeUpdate();
		ps.close();
	}
}

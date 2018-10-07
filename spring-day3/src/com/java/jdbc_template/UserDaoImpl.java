package com.java.jdbc_template;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.java.bean.User;

public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
/*	private JdbcTemplate jt ;*/
	@Override
	public void save(User user) {
		String sql ="insert into user values(null,?,?)";
		super.getJdbcTemplate().update(sql, user.getUsername(),user.getPassword());
	}

	@Override
	public void delete(Integer id) {
		String sql ="delete from user where id =?";
		super.getJdbcTemplate().update(sql, id);

	}

	@Override
	public void update(User user) {
		String sql ="update user set username = ? where id =? ";
		super.getJdbcTemplate().update(sql, user.getUsername(),user.getId());

	}

	@Override
	public User getById(Integer id) {
		String sql = "select * from user where id = ?";
		return 
				super.getJdbcTemplate().queryForObject(sql, new RowMapper<User>() {

					@Override
					public User mapRow(ResultSet rs, int arg1) throws SQLException {
						User user =new User();
						user.setId(rs.getInt("id"));
						user.setUsername(rs.getString("username"));
						user.setPassword(rs.getString("password"));
						return user;
					}}, id);

	}

	@Override
	public int getTotalCount() {
		String sql="select count(*) from user";
		Integer count = super.getJdbcTemplate().queryForObject(sql, Integer.class);
		return count;
	}

	@Override
	public List<User> getAll() {
		String sql="select * from user";
	return 	super.getJdbcTemplate().query(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int arg1)throws SQLException {
				User user =new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				return user;
			}});
		
	}
/*	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}*/

}

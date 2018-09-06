package Learn.JDBC.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Learn.JDBC.JdbcUtils;
import Learn.JDBC.Pojo.StudentSql;

public class DaoImp implements Dao {

	public void deleteStudent(StudentSql student) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "delete from my_student where id ="+student.getId();

		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.clean(conn, ps, rs);
		}

	}

	public void addStudent(StudentSql student) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "insert into my_student(name,score,class,id)values(?,?,?,?)";

		try {
			conn = JdbcUtils.getConnection();

			ps = conn.prepareStatement(sql);
			ps.setString(1, student.getName());
			ps.setInt(2, student.getScore());
			ps.setInt(3, student.getClazz());
			ps.setInt(4, student.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.clean(conn, ps, rs);
		}
	}
	public void readStudent(int id) {


		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select * from my_student where id="+id;

		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("name:"+rs.getObject("name")+"  "
						+"score:"+rs.getObject("score")+"  "
						+"class:"+rs.getObject("class")+"  "
						+"id:"+rs.getObject("id"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.clean(conn, ps, rs);
		}

	
		
	}
	public StudentSql getStudent(int id) {


		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		StudentSql student=null;

		String sql = "select * from my_student where id ="+id;

		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
			student =new StudentSql();
			
			student.setName(rs.getString("name"));
			student.setScore(rs.getInt("score"));
			student.setClazz(rs.getInt("class"));
			student.setId(rs.getInt("id"));
			
			}
			return student;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.clean(conn, ps, rs);
		}
		return null;
	}

}

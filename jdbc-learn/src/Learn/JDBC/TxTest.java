package Learn.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TxTest {

	public static void main(String args[]) {
		test();
	}

	public static void test() {
		Connection conn = null;
		Statement ps = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtils.getConnection();
			ps = conn.createStatement();
			conn.setAutoCommit(false);
			String sql = "update my_student set score =score-10 where id=1";
			ps.executeUpdate(sql);

			sql = "select score from my_student where id =6";
			rs = ps.executeQuery(sql);
			
			int score = 0;
			while (rs.next()) {
				score = rs.getInt("score");
			}
			if (score <110)
				throw new RuntimeException("已经超过最大值");
			
			sql = "update my_student set score =score+10 where id=6";
			ps.executeUpdate(sql);
			
			conn.commit();
		} catch (SQLException e) {
			if(conn!=null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			JdbcUtils.clean(conn, ps, rs);
		}

	}
}

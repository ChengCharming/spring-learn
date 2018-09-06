package Learn.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class JdbcBatch {

	public static void main(String[] args) {
		Connection conn;
		PreparedStatement stmt;
		
		
		try {
			conn = JdbcUtils.getConnection();
			stmt = conn.prepareStatement("INSERT INTO `iwantbesuper`.`student`\r\n" + 
					"(`name`,\r\n" + 
					"`age`,\r\n" + 
					"`score`)\r\n" + 
					"VALUES\r\n" + 
					"(?,\r\n" + 
					"?,\r\n" + 
					"?);\r\n" + 
					"");
			
			for (int index =1 ; index <20; index++) {
				stmt.setString(1, "CharMing"+index);
				stmt.setInt(2, 15+index);
				stmt.setInt(3, 70+index);
				stmt.addBatch();
			}
			int []result = stmt.executeBatch();
			System.out.println("result:"+Arrays.toString(result));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

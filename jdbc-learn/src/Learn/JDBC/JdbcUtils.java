package Learn.JDBC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import Learn.JDBC.DataSource.MyDataSource;

public class JdbcUtils {
	
	private static MyDataSource myDataSource =new MyDataSource();
	
	public static Connection getConnection() {
		synchronized(myDataSource.getConnectionsPool()){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myDataSource.getConnection();
		}

	}
	public static void clean(Connection conn, Statement ps, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			//conn.close();
			myDataSource.free(conn);
		}

	}


}

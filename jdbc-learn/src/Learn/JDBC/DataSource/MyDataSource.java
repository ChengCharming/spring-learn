package Learn.JDBC.DataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class MyDataSource {
	private String url="jdbc:mysql://localhost:3306/mydatabase?useSSL=false";
	private String user="root";
	private String password="root";
	private LinkedList<Connection> connectionsPool =new LinkedList<Connection>();
	

	public MyDataSource()  {
		for(int i=0;i<10;i++) {
			try {
				this.connectionsPool.addLast(this.createConnection());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void free(Connection conn) {
		this.connectionsPool.addLast(conn);
	}
	public Connection getConnection() {
		return this.connectionsPool.removeFirst();
	}
	private Connection createConnection() throws SQLException {
		Connection conn =DriverManager.getConnection(url, user, password);
		return conn;
	}
	
	
	
	
	public LinkedList<Connection> getConnectionsPool() {
		return connectionsPool;
	}
}

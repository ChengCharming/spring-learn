package My.Batis.One;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionManager {
	private static SessionManager Instance = new SessionManager();
	
	
	private SqlSessionFactory factory = null;

	private SessionManager() {
		String config = "mybatis.xml";
		InputStream ins = null;
		try {
			ins = Resources.getResourceAsStream(config);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		factory = new SqlSessionFactoryBuilder().build(ins);
	}

	public static SessionManager getInstance() {
		return Instance;
	}
	public  SqlSession getSession() {
		
		return this.factory.openSession();
	
	}
}

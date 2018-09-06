package My.Batis.One;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionManager {
	private static SessionManager Instance = new SessionManager();
	
	
	private SqlSessionFactory factory = null;

	private SessionManager() {
		String config = "mybatis.xml";
		InputStream ins = UserApp.class.getClassLoader().getResourceAsStream(config);

		factory = new SqlSessionFactoryBuilder().build(ins);
	}

	public static SessionManager getInstance() {
		return Instance;
	}
	public  SqlSession getSession() {
		
		return this.factory.openSession();
	
	}
}

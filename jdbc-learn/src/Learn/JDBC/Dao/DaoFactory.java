package Learn.JDBC.Dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {
	private static Dao dao =null;
	private static DaoFactory instance = new DaoFactory() ;
	
	private DaoFactory() {
		Properties pros= new Properties();
		InputStream inputStream;
		try {
			inputStream = new FileInputStream("lib/conn.properties");
			pros.load(inputStream);
			String DaoImpClass = pros.getProperty("DaoImp");
			dao = (DaoImp) Class.forName(DaoImpClass).newInstance();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static DaoFactory getInstance() {
		if(instance == null) {
			instance =new DaoFactory();
		}
		return instance;
	}
	public Dao getDao() {
		return dao;
	}
}

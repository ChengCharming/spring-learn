package Learn.JDBC;

import Learn.JDBC.Pojo.StudentSql;
import Learn.JDBC.Dao.Dao;
import Learn.JDBC.Dao.DaoFactory;
import Learn.JDBC.Dao.DaoImp;
public class JdbcApp {
	private static Dao dao =DaoFactory.getInstance().getDao();
	public static void main(String[] args) {
		
	//	StudentSql student = dao.getStudent(5);
	//	System.out.println(dao.toString());
	
	//	dao.addStudent(student);
	//	dao.deleteStudent(student);
		dao.readStudent(6);
	}

}

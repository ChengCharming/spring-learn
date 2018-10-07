package my.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.hibernate.Dao.StudentDao;
import my.hibernate.bean.Student;

public class HibernateLazyloadDemo {

	public static void main(String[] args) {
		SessionFactory sf =new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		StudentDao dao =new StudentDao(session);
		System.out.println("==========lazyload==========");
		Student student =dao.getStudentById(1025);
		

		dao.deleteStudent(student);
		
		session.close();
		sf.close();

	}

}

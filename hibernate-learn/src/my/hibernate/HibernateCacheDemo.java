package my.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.hibernate.Dao.StudentDao;
import my.hibernate.bean.Student;

public class HibernateCacheDemo {

	public static void main(String[] args) {		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		StudentDao dao = new StudentDao(session);
		Student student1 =dao.getStudentById(1024);
		System.out.println(student1);
		
		session.clear();
		
		Student student2 =dao.getStudentById(1024);
		System.out.println(student2);
		
	}

}

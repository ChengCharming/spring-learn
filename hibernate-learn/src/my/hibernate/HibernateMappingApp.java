package my.hibernate;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.hibernate.Dao.StudentDao;
import my.hibernate.bean.Student;

public class HibernateMappingApp {

	public static void main(String args[]) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		StudentDao dao =new StudentDao(session);
		
		List<Student> students =dao.getStudentsByName("char");
		for(Student student : students) {
		System.out.println("student:"+student);
		System.out.println("student login:"+student.getLogin());
		System.out.println("student status:"+student.getStatus());
		System.out.println("====================================");
			Set<Student> statuStudents =student.getStatus().getStudents();
			for(Student s:statuStudents) {
				System.out.println("student:"+s);
				System.out.println("student login:"+student.getLogin());
			}
		
		}
		
		
		session.close();
		sf.close();
	}
	
}

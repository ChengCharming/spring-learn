package my.hibernate;



import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.hibernate.Dao.StudentDao;
import my.hibernate.bean.Student;

public class HibernateApp {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
	//	Student student = (Student) session.get(Student.class,new Integer(1024));
	//	Student student = session.load(Student.class, 1024);
	//	System.out.println(student.toString());
	
	//	List<Student> students=new StudentDao(session).listStudents();
	
		
		
	//	List<Student> students=new StudentDao(session).getStudentByName("char");
	//	for(Student s:students) {
	//		System.out.println(s.toString());
	//	}
		Date date =new Date(2018,11,29);
		Student student =new Student();
		student.setDateOfBirth(date);
		student.setEmail("592352765");
		student.setFirstname("J");
		student.setGender("female");
		student.setId(1023);
		student.setLastname("N");
		student.setPhone("18525301120");
		student.setSid(304219);
		
	//  new StudentDao(session).insertStudent(student);

		
		session.close();
		sf.close();
	}

}

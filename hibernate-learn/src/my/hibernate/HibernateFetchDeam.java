package my.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;

import my.hibernate.bean.Student;

public class HibernateFetchDeam {

	public static void main(String[] args) {
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		
		System.out.println("-----------Criteria----------");
		Criteria c = session.createCriteria(Student.class);
		List<Student> students= c.list();
	
		
		
		for(Student s:students) {
			System.out.println(s);
		}
		
//		DetachedCriteria dc =DetachedCriteria.forClass(Student.class);
//		Criteria cc =dc.getExecutableCriteria(session);
//		System.out.println("----------DetachedCriteria---------");
//		List <Student> studentsc=cc.list();
//		for(Student s:studentsc) {
//			System.out.println(s);
//		}
		
		
		
		session.close();
		sf.close();

	}

}

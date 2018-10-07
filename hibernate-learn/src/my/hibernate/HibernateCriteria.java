package my.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import my.hibernate.bean.Student;

public class HibernateCriteria {

	public static void main(String[] args) {
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		
		System.out.println("-----------Criteria----------");
		Criteria c = session.createCriteria(Student.class);	
		c.add(Restrictions.eq("id",new Integer(1024)));
		
		List<Student> students= ((Criteria) c).list();
		for(Student s:students) {
			System.out.println(s);
		}
	session.close();
		sf.close();

	}

}

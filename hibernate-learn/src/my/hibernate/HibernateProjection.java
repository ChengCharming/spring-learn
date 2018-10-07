package my.hibernate;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import my.hibernate.bean.Student;

public class HibernateProjection {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		System.out.println("-----------Criteria----------");
		Criteria c = session.createCriteria(Student.class);
		
		ProjectionList proList = Projections.projectionList();
		proList.add(Projections.count("id"));
		proList.add(Projections.max("sid"));
		
		c.setProjection(proList);
		List<Student> students = c.list();
        for (Object obj : students) {
            System.out.println(Arrays.toString((Object[])obj));
        }
		session.close();
		sf.close();

	}

}

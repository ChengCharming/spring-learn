package my.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import my.hibernate.bean.Student;

public class HibernateRestriction {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		Criteria criteria = session.createCriteria(Student.class);
		session.getCriteriaBuilder().createQuery();
		// criteria.add(Restrictions.eq("gender", "Male"));
		// criteria.add(Restrictions.eq("lastname", "李"));

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("gender", "Male");
		params.put("lastname", "李");

		criteria.add(Restrictions.allEq(params));

		List students = criteria.list();

		for (Object obj : students) {
			System.out.println(obj);
		}

		session.close();
		sf.close();
	}

}

package my.hibernate.Dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import my.hibernate.bean.Student;

public class StudentDao {
	private Session session;

	public StudentDao(Session session) {
		this.session = session;
	}

	public List<Student> listStudents() {
		Query<Student> query = session.createQuery("from Student", Student.class);
		return query.getResultList();
	}

	public List<Student> getStudentsByName(String name) {
		Query<Student> query = session
				.createQuery("from Student where firstname like :name " + "or lastname like :name", Student.class);
		query.setParameter("name", "%" + name + "%");
		return query.getResultList();
	}
	public Student getStudentByName(String name) {
	//	return  session.get(Student.class, "name");
		
		
		Query<Student> query =
				session.createQuery("from Student where firstname like :name " + "or lastname like :name", Student.class);
		query.setParameter("name","%"+name+"%");
		return query.getSingleResult();
	}

	public Student getStudentById(Integer id) {
		return session.get(Student.class, id);
	}
	
	public void insertStudent(Student student) {

		Transaction tx =session.beginTransaction();
		try {
		session.save(student);
		session.flush();
		tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
		}
		
	}
	public void updateStudent(Student student) {
		Transaction tx =session.beginTransaction();
		try {
		session.update(student);
		session.flush();
		tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
		}
		
	}
	public void deleteStudent(Student student) {
		Transaction tx =session.beginTransaction();
		try {
		session.delete(student);
		session.flush();
		tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
		}
		
	}
	
}

package Learn.JDBC.Dao;

import Learn.JDBC.Pojo.StudentSql;

public interface Dao {
	public void addStudent(StudentSql student);
	public void deleteStudent(StudentSql student);
	public void readStudent(int id);
	public StudentSql getStudent(int id);
}

package my.hibernate.bean;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
@Table(name="student")
@Entity
public class Student {
		@Id
		@Column(name="id")
		private int id;
	
		@Column(name="sid")
		private int sid;
	
		@Column(name="firstname")
		private String firstname;
	
		@Column(name="lastname")
		private String lastname;
	
		@Column(name="gender")
		private String gender;
	
		@Column(name="phone")
		private String phone;
	
		@Column(name="email")
		private String email;
	
		@Column(name="date_of_birth")
		private Date dateOfBirth;
	
//		@Column(name="student_status_id")
//		private int studentStatusId;
	
		@ManyToOne(fetch =FetchType.LAZY)
		@JoinColumn(name="student_status_id")
		private StudentStatus status;
	
		@OneToOne(cascade=CascadeType.ALL)
		@PrimaryKeyJoinColumn
		private StudentLogin login;
		
		
		
		public StudentStatus getStatus() {
			return status;
		}

		public void setStatus(StudentStatus status) {
			this.status = status;
		}

		public String toString() {
			return "[ID:"+this.id+" "+"sid:"+this.sid+" "+"firstname:"+this.firstname+" "+
		"lastname:"+this.lastname+" "+"gender:"+this.gender+" "+"phone:"+this.phone+" "+
		"email:"+this.email+" "+"dateOfBirth:"+this.dateOfBirth+"]";
		}
		

		public StudentLogin getLogin() {
			return login;
		}
		public void setLogin(StudentLogin login) {
			this.login = login;
		}

		public Student() {
			
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getSid() {
			return sid;
		}
		public void setSid(int sid) {
			this.sid = sid;
		}
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public Date getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		
}

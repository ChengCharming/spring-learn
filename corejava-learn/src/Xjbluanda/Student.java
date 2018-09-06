package Xjbluanda;

public class Student {
    private String ID;
    private String name;
    private double score;
	public  double getID(String ID) {
		if(this.ID==ID)
			return this.score;
		else
			return -1;
	}
  public void setStudent(String ID,String name,double score) {
		this.ID=ID;
		this.name=name;
		this.score=score;
	}
public 	static void main  (String args[]) {
		Student s2= new Student();
	    Student s1=new Student();
		s1.setStudent("1500304219","CharMing",100.0);
		double score1 =s1.getID("1500304219");
		double score2 =s2.getID("15003042000");
		System.out.println(s2.name);
	}
	
    
}

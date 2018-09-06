package Learn.Lambda;

public class Person {
	public Person(String[] strings) {
		this.name=strings[0];
		this.department=strings[1];
		this.score=Integer.parseInt(strings[2]);
		}
	public String name;
	public String department;
	public int score;
}

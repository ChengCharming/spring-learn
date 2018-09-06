package Learn.Reflection;

public class Dog {
public	int age;
public 	String name;
	
	public Dog() {
		 
	}

	public Dog(int age, String name) {
		this.age = age;
		this.name = name;

	}

	public void bark() {
		System.out.println("wang wang");
	}
	public void celebrateBirthday() {
		System.out.println("happy birthday!");
		addAge();
	}
	public void addAge() {
		this.age+=1;
	}
}

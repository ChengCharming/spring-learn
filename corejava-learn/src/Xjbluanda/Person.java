package Xjbluanda;

public class Person implements Cloneable {

	public String name;
	public int age;
	Dog pet;

	public Person(String name, int age, Dog dog) {
		this.name = name;
		this.age = age;
		pet = dog;
	}

	public Object clone() {
		Dog pet = new Dog(this.pet.name, this.pet.age);
		Person p = new Person(this.name, this.age, pet);
		return p;
	}

	public String toString() {
		return "Person[name:" + name + "   age:" + age + "]" + pet.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person1 = new Person("a", 1, new Dog("dog a", 0));
		Person person2 = (Person) person1.clone();
		person1.name = "b";
		person1.pet.name = "dog b";
		System.out.println(person1.toString());
		System.out.println(person2.toString());
	}

}

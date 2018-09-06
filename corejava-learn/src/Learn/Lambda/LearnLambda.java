package Learn.Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LearnLambda {

	public static void printPerson(List<Person> persons) {
		for (Person p : persons) {
			System.out.println(p.score);
		}
	}

	public static void filter(List<Person> persons, Predicate<Person> predicate) {
		for (Person p : persons) {
			if (predicate.test(p))
				System.out.println(p.name);
		}
	}

	public static void main(String[] args) {
		// for (int i = 0; i < 100; i++) {
		// new Thread(()->System.out.println("i am Thread" +
		// Thread.currentThread().getId())).start();
		// }
		List<Person> persons = new ArrayList();
		persons.add(new Person(new String[] { "hha", "nihao", "100" }));
		persons.add(new Person(new String[] { "sa", "sass", "10" }));
		persons.add(new Person(new String[] { "sas", "sas", "10" }));
		// printPerson(persons);
		filter(persons, (Person p) -> p.department.startsWith("sa"));
		persons.forEach((Person p) -> System.out.println(p.score));
		System.out.println(700/25);
	}

}

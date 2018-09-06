package ClassLearnBasic;

public class TestAnimal {

	public static void main(String []args) {
		Dog d= new Dog("CharMing","JiNan",16);
        Cat c= new Cat("诚心诚意c","b",11);
	    runTest(d);
	    runTest(c);
	}
	
	public static void runTest(Animal animal) {
		System.out.println(animal.name);
		
		if(animal instanceof Dog) {
			System.out.println("这是一条狗");
			Dog d=(Dog)animal;
			d.bite();
			System.out.println();
		}else {
			System.out.println("这不是一条狗");
		}
	}
}

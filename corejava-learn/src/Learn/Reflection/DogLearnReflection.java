package Learn.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DogLearnReflection {

	public static void main(String[] args) {

		Dog dog = new Dog();
		// getClassFullname(dog);
		// getClassInstance();
		// getClassInfo();
		// getInstance();
		// getFields();
		// getMax(2,3,4,9);
		useMethods();
	}

	public static void useMethods() {
		String classPackage = "Learn.Reflection.Dog";

		try {
			Class d = Class.forName(classPackage);
			Dog dog = (Dog) d.newInstance();
			Method m = d.getMethod("bark", new Class[] {});
			m.invoke(dog,new Object[] {});

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void getMax(int... numbers) {
		int max = Integer.MIN_VALUE;
		for (int number : numbers) {
			max = number > max ? number : max;
		}
		System.out.println("max为" + max);
	}

	public static void getFields() {
		System.out.println("===============");
		Class<Dog> cDog = Dog.class;
		try {
			Dog o = (Dog) cDog.newInstance();
			Field f = cDog.getField("name");
			f.set(o, "haha");
			System.out.println(o.name);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void getClassFullname(Dog dog) {
		System.out.println("获得包名和类名");
		Class cDog = dog.getClass();
		System.out.println(cDog.getPackageName() + "&&" + cDog.getName());
	}

	public static void getClassInstance() {
		System.out.println("\n三种获得类实例的方法");
		// method one
		String className = "Learn.Reflection.Dog";
		try {
			Class c = Class.forName(className);
			System.out.println(c.getName());

			Class d = Dog.class;
			System.out.println(d.getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void getClassInfo() {
		System.out.println("\n获得类的信息");
		Class dogClazz = Dog.class;
		Method[] methods = dogClazz.getMethods();
		System.out.println("getMethods方法如下：");
		for (Method m : methods) {
			System.out.println(m.getName());
		}

		Method[] methods2 = dogClazz.getDeclaredMethods();
		System.out.println("\ngetDeclaredMethods方法如下：");
		for (Method m : methods2) {
			System.out.println(m.getName());
		}
	}

	public static void getInstance() {
		Class dogClazz = Dog.class;
		try {
			Object oD = dogClazz.newInstance();
			System.out.println(oD);
			Constructor constr = dogClazz.getConstructor(new Class[] { int.class, String.class });
			Dog o = (Dog) constr.newInstance(new Object[] { 2, "haha" });
			System.out.println(o.name);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

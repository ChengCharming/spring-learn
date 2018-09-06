package Xjbluanda;

import java.util.HashSet;
import java.util.Set;

public class Dog {
    public String name;
    public int age;
    
    public Dog(String name , int age) {
    	this.name=name;
    	this.age=age;
    }
    public String toString() {
    	return "Dog[name:"+name+" age:"+age+"]";
    }
    public boolean equals(Object d) {
    	if(d instanceof Dog) {
    		Dog dog=(Dog)d;
    		return this.name==dog.name&&this.age==dog.age;
    	}
    	else return false;
    }
    public int hashCode() {
    	String hashCodeStr=name+age;
    	return hashCodeStr.hashCode();
    }
	public static void main(String[] args) {
		Dog d1 =new Dog("a",1);
		Dog d2 =new Dog("a",1);
		Dog d3 =new Dog("b",1);
		Set set =new HashSet();
		set.add(d1);
      System.out.println(d1.equals(d2));
      System.out.println(d1.equals(d3));
      System.out.println("d1的hashCode是"+d1.hashCode());
      System.out.println("d2的hashCode是"+d2.hashCode());
      System.out.println("d3的hashCode是"+d3.hashCode());
      System.out.println(set.contains(d2));
	}

}

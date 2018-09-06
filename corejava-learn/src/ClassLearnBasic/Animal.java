package ClassLearnBasic;

public class Animal {
 public String name;
 public String owner;
 public int age;
public Animal(String name,String owner,int age) {
	this.name=name;
	this.owner=owner;
	this.age=age;
	
}
 
public void run () {
	 System.out.println("开始跑步。。。。");
	 System.out.println("结束跑步");
}
public void eat() {
	 System.out.println("开始吃饭。。。。");
	 System.out.println("吃饱了");
}
}
package ClassLearnBasic;

public class Cat extends Animal {

	public Cat(String name, String owner, int age) {
		super(name, owner, age);
	
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
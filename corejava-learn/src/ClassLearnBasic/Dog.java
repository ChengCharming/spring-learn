package ClassLearnBasic;

public class Dog extends Animal {

	public Dog(String name, String owner, int age) {
		super(name, owner, age);
		// TODO Auto-generated constructor stub
	}
	public void bite() {
		System.out.println("狗咬人");
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

package Xjbluanda;

public class Singleton {
  private int time=0 ;
  private static Singleton singleton = new Singleton();
  public static Singleton getInstance() {
	  return singleton;
  }
  private Singleton() {
	  
  }
  public void daka() {
	  time=time+1;
	  System.out.println("打卡"+time+"次");
  }
}

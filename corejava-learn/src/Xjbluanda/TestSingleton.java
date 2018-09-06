package Xjbluanda;

public class TestSingleton {

	public static void main(String[] args) {
		Singleton s = Singleton.getInstance();
		s.daka();
		Singleton s2 = Singleton.getInstance();
		s2.daka();
	}

}

package Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Singleton1 {
//饿汉模式 线程不安全
	private static Singleton1 instance;
	private Singleton1() {
		
	}
	public static Singleton1 getInstance() {
		if(instance == null) {
			instance = new Singleton1();
		}
		return instance;
	}

/*	饿汉模式 线程安全
		private static Singleton1 instance;
		private Singleton1() {
			
		}
		public static synchronized Singleton1 getInstance() {
			if(instance == null) {
				instance = new Singleton1();
			}
			return instance;
		}*/
	
	public void fun() {

		
	}
	
}

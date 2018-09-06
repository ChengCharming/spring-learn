package Xjbluanda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LearnCollection {

	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		c.add("aa");
		c.add("bb");
		c.add("cc");
		System.out.println(c.contains("cc"));
		System.out.println(c.contains("dd"));
		for (String s : c) {
			System.out.println(s);
		}
		System.out.println("================");
		Iterator<String> it = c.iterator();
		while (it.hasNext()) {
			String s =it.next();
			System.out.println(s);
		}
		System.out.println("-----------------");
		
		List <String> list = new LinkedList<String>();
		list.add("s");
		list.add(0,"a");
		
		for(String s:list) {
			System.out.println(s);
		}
		System.out.println("============");
		Iterator <String>t= list.iterator();
		while(t.hasNext()) {
			String s=t.next();
			System.out.println(s);
		}

	}

}

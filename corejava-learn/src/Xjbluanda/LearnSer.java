package Xjbluanda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LearnSer {

	public static void main(String args[]) {
		double a = 1/3;
		System.out.println(a);
		
		Collection<String> c = new ArrayList<String>();
		c.add("aa");
		c.add("bb");
		c.add("cc");
		Set<String> s = new TreeSet();
		s.addAll(c);

		Iterator it = s.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());

		}

		System.out.println("====================");
		for (String s1 : s) {
			System.out.println(s1);
		}
    List s1=new ArrayList();
	}
}

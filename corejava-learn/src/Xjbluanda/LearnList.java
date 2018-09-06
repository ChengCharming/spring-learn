package Xjbluanda;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class LearnList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List L = new ArrayList();
		List L1 = new LinkedList();
		Long startime = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			Random rd = new Random();
			int n = rd.nextInt(1000);
			L.add(n);

		}
		Long endtime = System.currentTimeMillis();
		System.out.println(endtime - startime);

		Long startime1 = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			Random rd = new Random();
			int n = rd.nextInt(1000);
			L1.add(n);
		}
		Long endtime1 = System.currentTimeMillis();
		System.out.println(endtime1 - startime1);

	}

}

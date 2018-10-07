package Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestT {

	public static void main(String[] args) {
		String start="cmd:";
		String cmd="0123456789";
		String remaining = cmd.substring(start.length());
		System.out.println(start.length());
		System.out.println(remaining);
		System.out.println("=====================");

		String str ="a";
		String str1= str.intern();
		switch(str) {
		case "b" : 
			System.out.println("b");
			break;
		case "a" : 
			System.out.println("a");
			break;
		case "c" : 
			System.out.println("c");
			break;
		default :
			System.out.println("default");
		}
	System.out.println("__________________________________");
	testDate();
		
	}
	public static void testDate() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String currenTime = format.format(date);
		
		System.out.println(currenTime);
	}

}

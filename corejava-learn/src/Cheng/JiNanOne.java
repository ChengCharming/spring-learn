package Cheng;

import java.util.Scanner;

public class JiNanOne {
     //  String 复习
	public static void main (String [] args) {
        // int a =1;
		// int b =2;
		//sum(a,b);
		//Binge();
		//method();
		Scanner sc= new Scanner(System.in);
		System.out.println("请输入编码");
		int x =sc.nextInt();
		search();
		System.out.println("-------------------");
		StringBufferAndStringBuilder();
	}
  static void sum(int a,int b){
	  System.out.println(a+b);
   }
  static void Binge() {
	  String str1="How Are You ?";
	  String name="Tom";
	  String msg= str1 +" " + name;
	  System.out.println(msg);
	  
	  String msg1=str1.concat(" ").concat(name);
	  System.out.println(msg1);
  }
  static void method() {
	
	  String str1="How Are You ?";
	  char a[]=new char[str1.length()];
	  System.out.println(str1.length());
	  System.out.println(str1.charAt(12));
	  System.out.println(str1.indexOf("How"));
	  System.out.println(str1.isEmpty());
	  System.out.println(str1.codePointAt(2));
	  System.out.println(str1.codePointAt(1));
	  str1.getChars(0,13,a,0);
	  for(char b:a) {
		 System.out.println(b);
	  }
	  }
  static void search() {
	
	  String str1="How Are You How ?";
	  String str2=str1.replaceFirst("How", "Who");
	  String str3=str2.replaceAll(str2, "11");
	  System.out.println(str2+"   "+str3);
 }
  static void StringBufferAndStringBuilder() {
	  long startTime = System.currentTimeMillis();
	  String result = "0";
	  for(int i=1 ;i<10000;i++)
   {
	   result = result + i;
   }
	  long endTime = System.currentTimeMillis();
	  System.out.println("直接加用时："+(endTime-startTime));
	  StringBuffer sb =new StringBuffer("0");	
	  long startTime1 = System.currentTimeMillis();
	  for(int i=1 ;i<10000;i++)
   {
		  sb.append(i);
   }
	  long endTime1 = System.currentTimeMillis();
	  System.out.println("使用StringBuffer："+(endTime1-startTime1));

  
  }
}

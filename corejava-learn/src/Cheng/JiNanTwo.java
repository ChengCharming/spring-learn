package Cheng;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class JiNanTwo {
      // 数组 复习
	public static void main(String[] args) {
     // # 数组的三种创建方法
		int[] nums = {1,2,3,4};
		int[] nums1 =new int[4];
		nums1[0]=1;
		nums1[1]=2;
		nums1[2]=3;
		nums1[3]=4;
		Date[] dates =new Date[] {new Date(), new Date()};
	//	System.out.println(dates[0]);
	// 数组的访问和遍历	for each
	 // learnArray();
	  //Array 排序
	  arraySort();
	}
 public  static void learnArray() {
	  int[] nums = {1,2,3,4};
	  System.out.println(nums.length);
	  Random rd= new Random();
	  for(int i=0;i<10;i++) {
	  int a=rd.nextInt(101);
	  System.out.println(a);
	  }
	  
	  for(int num:nums) {
		  System.out.println(num);
	  }
  }
 public static void arraySort() {
	 int[] nums = {4,7,9,3};
	 for(int num:nums) {
		 System.out.println(num);
	 }
	 Arrays.sort(nums);
	 System.out.println("----------");
	 for(int num:nums) {
		 System.out.println(num);
	 }
 }
 
}

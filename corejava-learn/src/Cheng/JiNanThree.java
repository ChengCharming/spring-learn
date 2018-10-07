package Cheng;

public class JiNanThree {
     //算法启蒙
	public static void main(String[] args) {
	
	System.out.println(jiecheng(5));
	System.out.println("------------------");
		randomF();
 }
	static int jiecheng(int num) {
		if(num==1) 
			return 1;
		if(num==2)
			return 1;
		else 
			return jiecheng(num-2)+jiecheng(num-1);
	
	}
	static void randomF() {
		for(int i=0;i<6;i++) {
			int x=(93+(int)(Math.random()*7));
			System.out.println(x);
		}
	}
}


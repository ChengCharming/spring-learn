package ClassLearnBasic;

public class Phone {
  String brand;
  String model;
  String owner; 
   int price;
 void  call (String phoneNo) {
	 if(phoneNo.length()==11)
	 
	 System.out.println("正在给"+phoneNo+"打电话");
	
	 else
		 System.out.println("手机号输入错误，必须为11位");
	 
		 
  }
  void text ( String phoneNo,String msg) { 
	  
  }
  public static void main(String []args) {
	  Phone ph1=new Phone();
	  ph1.call("15867117343");
	  ph1.call("1234567890");
  }
  
}

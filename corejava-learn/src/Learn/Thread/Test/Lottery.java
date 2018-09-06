package Learn.Thread.Test;

import java.util.Arrays;

public class Lottery {
  static int count=1;
  static int time1=0;
  static int time2 =0;
	public static void main(String[] args) throws InterruptedException {
		/*
		 * 某公司组织年会,会议入场时有两个入口,在入场时每位员工都能获取一张双色球彩票 
		 * 假设公司有100个员工,利用多线程模拟年会入场过程
		 * 并分别统计每个入口入场的人数,以及每个员工拿到的彩票的号码。
		 * 线程运行后打印格式如下：
		 * 编号为: 2 的员工 从后门 入场! 拿到的双色球彩票号码是:
		 * [17, 24, 29, 30, 31, 32, 07] 
		 * 编号为: 1 的员工 从后门 入场! 拿到的双色球彩票号码是: 
		 * [06, 11, 14, 22, 29, 32, 15] 
		 * .....
		 * 从后门入场的员工总共: 13 位员工 从前门入场的员工总共: 87 位员工
		 */

		Thread getLotteryOne = new Thread(()-> {

			try {
				
				while(count<100) {
					Thread.sleep(400);
					int[] lottery= {0,0,0,0,0,0,0};
					for (int i = 0; i < 7; i++) {
						lottery[i] = (int) (89 * Math.random() + 10);
					}
					System.out.println("编号为："+count+" 的员工 从后门 入场! 拿到的双色球彩票号码是:"+Arrays.toString(lottery));
					count+=1;
					time1+=1;
					}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			
		});
		
		Thread getLotteryTwo = new Thread(()-> {
			try {
				
				while(count<100) {
					Thread.sleep(200);
					int[] lottery= {0,0,0,0,0,0,0};
					for (int i = 0; i < 7; i++) {
						lottery[i] = (int) (89 * Math.random() + 10);
					}
					System.out.println("编号为："+count+" 的员工 从前门 入场! 拿到的双色球彩票号码是:"+Arrays.toString(lottery));
					count+=1;
					time2+=1;
					}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		{

			getLotteryOne.start();
			getLotteryTwo.start();
			getLotteryOne.join();
			getLotteryTwo.join();
		}
System.out.println(time1);
System.out.println(time2);
	}

}

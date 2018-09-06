package Learn.Thread.Test;

import java.util.Random;

public class LuckDraw {

	public static void main(String[] args) {
		// 有一个抽奖池,该抽奖池中存放了奖励的金额,该抽奖池用一个
		// 数组int[] arr = {10,5,20,50,100,200,500,800,2,80,300};
		// 创建两个抽奖箱(线程)设置线程名称分别为“抽奖箱1”，“抽奖箱2”，
		// 随机从arr数组中获取奖项元素并打印在控制台上,格式如下:
		// 抽奖箱1 又产生了一个 10 元大奖
		// 抽奖箱2 又产生了一个 100 元大奖
		int[] arr = { 10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300 };
		Thread luckOne = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					try {
						Thread.sleep(300);
						Random rdm = new Random();
						System.out.println(
								Thread.currentThread().getName() + "又产生了一个" + arr[rdm.nextInt(arr.length)] + "元大奖");
					
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			}
		});
		Thread luckTwo = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(300);
					Random rdm = new Random();
					System.out.println(
							Thread.currentThread().getName() + "又产生了一个" + arr[rdm.nextInt(arr.length)] + "元大奖");
				
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		});
		
		luckOne.setName("抽奖池1");
		luckTwo.setName("抽奖池2");
		luckOne.start();
		luckTwo.start();

	}

}

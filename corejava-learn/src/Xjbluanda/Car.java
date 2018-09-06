package Xjbluanda;

public class Car {
	public String brand;
	public String type;
	private Battery battery;

	public Car(String brand, String type, Battery battery) {
		this.brand = brand;
		this.type = type;
		this.battery = battery;
	}
    public Car() {
    	
    }
    public Battery getBattery() {
    	return new Battery();
    }
	public void start() {
    	if (this.battery.usePower()==-1)
    		this.battery.chargePower();
    }
	private class Battery {
		public int power = 1000;

		int usePower() {
			if (this.power >= 300) {

				System.out.println("电量充足");
				power -= 100;
				System.out.println("当前电量为："+this.power);
				return 1;
			} else if (this.power >= 100 && this.power < 300) {
				System.out.println("电量低，请充电");
				power -= 100;
				System.out.println("当前电量为："+this.power);
				return 0;
			} else
				System.out.println("当前电量为："+this.power+"电量不足，操作失败");
			return -1;

		}

		void chargePower() {
			System.out.println("正在充电...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.power = 1000;
			System.out.println("充电已完成...");
			System.out.println("当前电量为："+this.power);
		}
	}
}
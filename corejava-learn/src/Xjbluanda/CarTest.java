package Xjbluanda;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Car c =new Car();
    
     Car car= new Car("aca","ss",c.getBattery());
     for(int i = 0;i<20;i++) {
        car.start();
     }
	}

}

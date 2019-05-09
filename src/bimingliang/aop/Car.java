package bimingliang.aop;

public class Car {

	public String start() {
		System.out.println("Car starting.");
		return "Car start return.";
	}
	
	public void run(String length) {
		System.out.println("Car run " + length + ".");
	}
}

package dbAccess;

import java.util.Scanner;

public class Car {

	private String carRegistration = null;
	
	public static String registerCar(String carRegistration) {
		return carRegistration;
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter car registration: ");
		String reg = in.next();
		
		System.out.println("You registered: " + registerCar(reg));
	}

}

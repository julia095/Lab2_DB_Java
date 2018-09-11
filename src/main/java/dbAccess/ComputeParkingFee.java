package dbAccess;

import java.util.Scanner;

public class ComputeParkingFee {

	double totalAmount;
	double baseRate;
	double time;
	String pTime;
	
	static ComputeParkingFee obj = new ComputeParkingFee();
	
	
	
	public ComputeParkingFee() {

		totalAmount = 0;
		baseRate = 1.5;
		time = 0;
		pTime = null;
	}


	public double calculateFee() {
		ParkingTimes obj = new ParkingTimes();
		totalAmount = ((double)obj.timeToPark/60)*baseRate;
		return totalAmount;
	}
	
	public double computeParkingtime(String pTime) {
		time = Double.parseDouble(pTime);
		return time;
	}
	
	
	//we don't test getBaseRate and SetBaseRate

	public double getBaseRate() {
		return baseRate;
	}


	public void setBaseRate(double baseRate) {
		this.baseRate = baseRate;
	}


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		ComputeParkingFee obj = new ComputeParkingFee();
		ParkingTimes obj1 = new ParkingTimes();
		
		System.out.println("How long to you wish to park?  ");
		int length = in.nextInt();
		obj1.endTime(length);
		
		System.out.println("parking fee: " +obj.calculateFee());
		
		

	}

}

package dbAccess;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Scanner;

public class ParkingTimes {
	static int timeToPark = 0;
	
	public static String readSystemTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		return sdf.format(cal.getTime());
	}
	
	public static String startTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		return sdf.format(cal.getTime());
	}
	
	public static String endTime(int minutesToPark) {
		timeToPark = minutesToPark;
		ComputeParkingFee obj1 = new ComputeParkingFee();
		LocalTime lt = LocalTime.parse(startTime());
		LocalTime ltLater = lt.plusMinutes(minutesToPark);
		String endTime = ltLater.toString();
		return endTime;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("How long do you wish to park? ");
		int parkingTime = in.nextInt();
		
		System.out.println("Start Time: " + startTime());
		System.out.println("End Time: " + endTime(parkingTime));

	}

}

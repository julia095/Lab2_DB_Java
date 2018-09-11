package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dbAccess.ComputeParkingFee;
import dbAccess.ParkingTimes;

public class ComputeParkingFeeTest {
	
	private ComputeParkingFee obj;
	private String time;
	private double parkingTime;//will hold the converted value
	private double baseRate;

	@Before
	public void setUp() throws Exception {
		
		obj=new ComputeParkingFee();
		time ="30";
		parkingTime = Double.parseDouble(time);
		baseRate = 1.5;
	}

	@After
	public void tearDown() throws Exception {
		obj = null;
	}

	/*public double calculateFee() {
		ParkingTimes obj = new ParkingTimes();
		totalAmount = ((double)obj.timeToPark/60)*baseRate;
		return totalAmount;
	}*/
	
//	@Test
//	public void testCalculateFee() {
//		double expected = 0.75;
//		double actual = obj.calculateFee();
//		assertEquals(expected,actual,2);
//		
//	}

	@Test
	public void testComputeParkingtime() {
		double expected = 30.5;
		double actual = obj.computeParkingtime(time);
		assertEquals(expected,actual,0.1);
	}

}

package UnitTests;

import static org.junit.Assert.*;

import org.apache.poi.ss.formula.functions.FinanceLib;
import org.junit.Test;

import base.RateDAL;
import ch.makery.address.model.Rate;

public class RateBLL_Test {

	@Test
	public void PaymentTest() {
		//This test shows the payment per month for house		
		double rate = (RateDAL.getRate(730)/100)/12;
		int FV = 0;
		
		double PV = 300000;
				
		assertTrue("This is wrong", Rate.getPayment(360, 300000, 730) == FinanceLib.pmt(rate, 360, -PV, FV, true));
		
	}
	
	private double income; 
	private double expenses;

	@Test
	public void MortgageDisplayTest(){
		
		//Tests the mortgages to see if the user can afford monthly mortgage
		Double displayOutput = Rate.getPayment(360, 300000, 730);

		
		income = 60000;
		expenses = 10000;
		
		//These tests shows mortgage payment is under the max mortgage payment the user can have 
		assertTrue("This is wrong",(displayOutput <= (income * .36 )) == true);
		
		assertTrue("This is wrong",(displayOutput <= ((income + expenses) * .18)) == true);
		
		
		income = 5500;
		expenses = 1000;

		//These tests show mortgage Payment is above max mortgage payment which means cost of house is too high
		assertTrue("This is wrong",(displayOutput <= ((income + expenses) * .18)) != true);
		
		assertTrue("This is wrong",(displayOutput <= ((income + expenses) * .18)) != true);
		System.out.print(Rate.getPayment(360,300000, 730));
	}

	
}

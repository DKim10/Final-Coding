package base;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import domain.RateDomainModel;

public class Rate_Test {

	@Test
	public void TBLRatesTest() {
		//This gets the rows from database and adds to an arrayList
		ArrayList<RateDomainModel> rates = RateDAL.getTBLRates();
		
		//This test checks that the number of rows are > 0
			assertTrue(rates.size() > 0);
	}
	
	@Test
	public void getRateTest(){
		
		//This test checks to see if credit score is < 600 it will still have an interest rate of 5%
		assertTrue("This is wrong", RateDAL.getRate(400) == 5); 
		
		//This test checks if credit score is between 600 and < 650 it will have an interest rate 5%
		assertTrue("This is wrong", RateDAL.getRate(620) == 5);
		
		//This test checks if credit score is between 650 and < 700 it will have an interest rate 4.5%
		assertTrue("This is wrong", RateDAL.getRate(670) == 4.5);
		
		//This test checks if credit score is between 700 and < 750 it will have an interest rate 4%
		assertTrue("This is wrong", RateDAL.getRate(700) == 4);
		
		//This test checks if credit score is between 750 and < 800 it will have an interest rate 3.75%
		assertTrue("This is wrong", RateDAL.getRate(780) == 3.75);
		
		//This test checks if credit score is 800 it will have an interest rate 3.5%
		assertTrue("This is wrong", RateDAL.getRate(800) == 3.5); 
		
		//This test checks if credit score is < 800 it will still have an interest rate 3.5%
		assertTrue("This is wrong", RateDAL.getRate(850) == 3.5); 






	}

}

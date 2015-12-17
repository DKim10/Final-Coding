package ch.makery.address.model;

import org.apache.poi.ss.formula.functions.FinanceLib;

import base.RateDAL;
import domain.RateDomainModel;

public class Rate extends RateDomainModel {
	
	public static double getPayment(int NumberOfPayments, double HouseCost, int CreditScore)
	{	/** This function figures out the monthly mortgage using the FinanceLib function pmt
		 * Variables: rate - gets the rate based on credit score and divides it by 12 for monthly rate
		 * PV - HouseCost
		 * FV - ending value after paying loan
		 * PMT- mortgage monthly
		 * Parameters: Location - NumberOfPayments - number of payments user wants to make
		 * HouseCost - the Loan person wants to take out
		 * CreditScore - users credit score used to determine Interest rate
		 */
		
		double rate = (RateDAL.getRate(CreditScore)/100)/12;
		
		int FV = 0;
		
		double PV = HouseCost;
		
		double PMT = FinanceLib.pmt(rate, NumberOfPayments, -PV, FV, true);
		
		double MortgagePayment = PMT;
		
		return MortgagePayment;
	
	}
}

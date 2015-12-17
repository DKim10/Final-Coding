package domain;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class RateDomainModel implements Serializable {
	
	private int RateID;
	private int MinCreditScore;
	private double InterestRate;
	
	public RateDomainModel()
	{
		
	}
	
	//Getter for RateID
	//returns int
	public int getRateID() {
		return RateID;
	}
	
	//setter for RateID
	public void setRateID(int rateID) {
		RateID = rateID;
	}
	
	//Getter for MinCreditScore
	//returns int
	public int getMinCreditScore() {
		return MinCreditScore;
	}
	
	//Setter for MinCreditScore
	public void setMinCreditScore(int minCreditScore) {
		MinCreditScore = minCreditScore;
	}
	
	//Getter for InterestRate
	//returns double
	public double getInterestRate() {
		return InterestRate;
	}
	
	//Setter for InterestRate
	public void setInterestRate(double interestRate) {
		InterestRate = interestRate;
	}
	
	
}
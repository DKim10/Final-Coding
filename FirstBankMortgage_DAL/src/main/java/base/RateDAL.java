package base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.RateDomainModel;
import util.HibernateUtil;

import org.apache.poi.ss.formula.functions.FinanceLib;

public class RateDAL {

	public static ArrayList<RateDomainModel> getTBLRates() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		RateDomainModel ratGet = null;		
		ArrayList<RateDomainModel> rats = new ArrayList<RateDomainModel>();
		
		try {
			tx = session.beginTransaction();	
			
			List rates = session.createQuery("FROM RateDomainModel").list();
			for (Iterator iterator = rates.iterator(); iterator.hasNext();) {
				RateDomainModel rat = (RateDomainModel) iterator.next();
				rats.add(rat);

			}
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return rats;
	}		
	
	public static double getRate(int GivenCreditScore) {
		//FinalExam - please implement		
		// Figure out which row makes sense- return back the 
		// right interest rate from the table based on the given credit score
		
		//FinalExam - obviously change the return value
		
		double rate = 0;
		
		for(int i = 0; i < getTBLRates().size(); i++ ){
			if (GivenCreditScore < 600) {
				rate = 5;
			}
			
			else if ((GivenCreditScore >= getTBLRates().get(i).getMinCreditScore()) & (GivenCreditScore < getTBLRates().get(i).getMinCreditScore()+50)){
				rate = getTBLRates().get(i).getInterestRate();
			}
			
			else if (GivenCreditScore > 800) {
				rate = 3.5;
			}
			
		}
		
		return rate;
	}
	
}
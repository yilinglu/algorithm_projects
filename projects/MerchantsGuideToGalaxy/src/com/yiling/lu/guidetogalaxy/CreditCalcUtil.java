package com.yiling.lu.guidetogalaxy;

/**
 * <p>
 * e.g. If "gob Silver is 80 Credits" works out to be "3 Silver is 80 Credits",
 * then we will have base=3, creditPoint=80, metal="Silver".
 * <br/>
 * When asked "how many Credits is 100 Silver?", we will take the ceiling of the result decimal
 * reach an integer :<br/>
 * <b>(100/3)*80 = 2667 Credits.</b>
 * </p>
 * 
 * @author yiling.lu@outlook.com
 *
 */
public class CreditCalcUtil {
	
	public static int calcCreditPoints(CreditData creditData, Integer amount){
		
		double multiplier = amount/creditData.getBase();
		double creditWorth = multiplier*creditData.getCreditPoint();
		int roundUp = (int)(Math.ceil(creditWorth));
		return roundUp;
	}
}

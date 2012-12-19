package com.yiling.lu.guidetogalaxy;

/**
 * <p>
 * Every base number of metals is worth the value of variable "creditPoint"
 * </p>
 * <p>
 * e.g. If "gob Silver is 80 Credits" works out to be "3 Silver is 80 Credits",
 * then we will have base=3, creditPoint=80, metal="Silver".
 * <br/>
 * When asked "how many Credits is 100 Silver?", we will take the ceiling of the result decimal
 * reach an integer :<br/>
 * <b>(100/3)*80 = 2667 Credits.</b>
 * </p>
 * <p>
 * The design decision is to always round up credit to an integer.
 * <br/> Traveling the galaxy selling metal is hard enough life, why don't 
 * we make it simpler?
 * </p>
 * 
 * @author yiling.lu@outlook.com
 *
 */
public class CreditData {
	private String metal;
	private double creditPoint;
	private double base = 1.0;	
	
	public CreditData(){
		
	}
	
	public String getMetal() {
		return metal;
	}

	public void setMetal(String metal) {
		this.metal = metal;
	}

	public double getCreditPoint() {
		return creditPoint;
	}

	public void setCreditPoint(double creditPoint) {
		this.creditPoint = creditPoint;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}



	
	
}

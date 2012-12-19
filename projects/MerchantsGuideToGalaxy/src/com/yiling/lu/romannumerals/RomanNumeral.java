package com.yiling.lu.romannumerals;

/**
 * @author yiling.lu@outlook.com
 *
 */
public enum RomanNumeral {
	I (1,0),
	V (5,1),
	X (10,2),
	L (50,3),
	C (100,4),
	D (500,5),
	M (1000,6);
	
	public final int intValue;
	public final int order;
	
	RomanNumeral(int intValue, int order){
		this.intValue = intValue;
		this.order = order;
	}
	
	public char charValue(){
		char result = ' ';
		
		switch (intValue) {
			case 1:
				result = 'I';
				break;
			
			case 5:
				result = 'V';
				break;
				
			case 10:
				result = 'X';
				break;
									
			case 50:
				result = 'L';
				break;

			case 100:
				result = 'C';
				break;
				
			case 500:
				result = 'D';
				break;

			case 1000:
				result = 'M';
				break;				
				
			default:
				break;
		}
		
		return result;
	}
	
}

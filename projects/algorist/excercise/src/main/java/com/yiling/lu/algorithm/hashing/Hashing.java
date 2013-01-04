package com.yiling.lu.algorithm.hashing;

public class Hashing {

	/**
	 * Treat each character in the string as a 26 based number, this function 
	 * computes the base 10 integer value of the giver string
	 * 
	 * @param str
	 * @return hashing integer value
	 */
	public static int computHash(String str){
		if(str == null || str.length() == 0){
			return -1;
		}
		str = str.toLowerCase();
		
		double result = 0;
		for(int i=0; i<str.length(); i++){
			char cur = str.charAt(i);
			int value = cur - 'a';
			
			double power = (double)(str.length()-i-1);
			
			result = result + value * Math.pow(26, power);
		}
		
		return (int)result;
	}
	
	private static int base26Value(char ch){
		return ch - 'a';
	}
}

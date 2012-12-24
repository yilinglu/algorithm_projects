package com.yiling.lu.algorithm.util;

import junit.framework.Assert;

public class AssortedUtils {
	
	public static void verifyOder(int[] input, boolean ascending){
		if(input.length ==0) return;
		System.out.print(input[0]);
		
		for(int i=1; i<input.length; i++){
			System.out.print("," + input[i]);
			if(ascending){
				Assert.assertTrue(
						"expecting " + input[i] + " >= " + input[i-1], 
						input[i]>=input[i-1]);
			}else{
				Assert.assertTrue(input[i]<=input[i-1]);
			}
		}
		System.out.println();
	}
}

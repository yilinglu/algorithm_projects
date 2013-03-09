package com.yiling.lu.algorithm.problem.longestLargest.maxSubarray;

/**
 * The two well-known algorithms for solving maximum subarray problem:
 * 1. Divide and Conquer
 * 2. Linear scanning
 *
 * This class implements the linear scanning algorithm, the function only
 * calculate the max sum.
 *
 * 
 * @author yilingfamily
 *
 */
public class LinearMaxSubarray {
	
	public static int maxSubarray(int[] input) {
		if(input == null || input.length == 0) throw new RuntimeException("null or empty array not allowed.");
		
		int max = 0;
		int cur = 0;
		
		for(int i=0; i<input.length; i++){
			cur = cur + input[i];
			if(cur < 0) cur = 0;
			if(cur > max){
				max = cur;
			}
		}
		return max;
	}

}

package com.yiling.lu.algorithm.problem.longestLargest.maxSubarray;

/**
 * The two well know algorithms for solving maximum subarray problem:
 * 1. Divide and Conquer
 * 2. Linear scanning
 * 
 * Among all the literatures, people have failed to point out an important
 * subtlety between these two approaches. That is Linear scanning has the 
 * assumption/definition of max sum is Zero when all elements are negative. Without
 * this assumption, linear scanning algorithm does not work. Divide and Conquer
 * does not need this assumption, given an all negative array, Divide and Conquer
 * will pick out the largest negative number as the max sub array, which is a subarray
 * in its true spirit of subarray.
 * 
 * Plus, the linear scanning cannot find out the start and end index of the max subarray.
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

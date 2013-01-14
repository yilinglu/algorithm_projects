package com.yiling.lu.algorithm.problem.longestSomething.maxSubarray;

public class LinearMaxSubarray {
	
	public static int[] maxSubarray(int[] input) {
		if(input == null || input.length == 0) throw new RuntimeException("null or empty array not allowed.");
		
		int low = 0;
		int high = 0;
		int max = input[low];
		
		int runningTotal = max;
		
		for(int k=high+1; k<input.length; k++){
			runningTotal = runningTotal + input[k];
			
			if(runningTotal > max){
				max = runningTotal;
				high = k;
			}
			
			if(input[k] > max){
				low = k;
				high = k;
				max = input[k];
				runningTotal = max;
			}
		}
		
		return new int[]{low, high, max};

	}

}

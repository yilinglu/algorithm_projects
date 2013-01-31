package com.yiling.lu.algorithm.problem.longestLargest.maxSubarray;

/**
 * Solution in CLRS book, divide and conquer chapter. There is a question
 * regarding this in TADM book
 * 
 * The following is a literal implementation after reading the hint on 
 * CLRS page 75, 4.1-5. 
 * 
 * This implementation result in linear run time, it calculates both the sum
 * of the max subarray, it also return the start and end index of the max subarray.
 * 
 * 
 * @author ylu
 * 
 */
public class MaxSubarray {
	
	/**
	 * @param a argument array
	 * @return value at index 0 of the array is the starting index of the max subarray,
	 * value at index 1 is the end index, value at index 2 is the sum of the max subarray.
	 */
	public static int[] maxSubarray(int[] a){
		if(a == null){
			throw new NullPointerException("Null input array encountered.");
		}else if(a.length == 0){
			return new int[]{0,0,0};
		}else if(a.length ==1){
			return new int[]{0,0,a[0]};
			
		}else{
			int low = 0;
			int high = 0;
			int max = a[0];
			
			int runningTotal = a[0];
			
			int curLow=0;
			int curHigh = 0;
			int curMax = a[0];
			
			for(int i=1; i<a.length; i++){
				runningTotal = runningTotal + a[i];
				if(a[i]<0){
					curMax = 0;
				}else{
					curMax = curMax + a[i];
					if(a[i-1] < 0){
						curLow = i;
					}
					curHigh = i;
				}
				
				if(max<runningTotal){
					max = runningTotal;
					high = i;
				}
				
				if(curMax > max){
					low = curLow;
					high = curHigh;
					max = curMax;
					
					runningTotal = curMax;
				}
			}
			
			return new int[]{low, high, max};
		}
	}

}

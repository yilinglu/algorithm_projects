package com.yiling.lu.algorithm.problem.longestLargest.maxSubarray;

/**
 * Solution in CLRS book, divide and conquer chapter. There is a question
 * regarding this in TADM book
 * 
 * The following is a literal implementation after reading the hint on 
 * CLRS page 75, 4.1-5. Result is a much complicated than needed algorithm.
 * The same linear time algorithm is re-implemented in LinearMaxSubarray.java.
 * 
 * The result of this implementation is correct, but the impl is way too complicated.
 * 
 * 
 * @author ylu
 * 
 */
public class MaxSubarray {
	
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

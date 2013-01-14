package com.yiling.lu.algorithm.problem.longestLargest.maxSubarray;

/**
 * Solution in CLRS book, divide and conquer chapter. There is a question
 * regarding this in TADM book
 * 
 * The following is a literal implementation after reading the hit on 
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

	/**
	 * @param input
	 * @return integer array index 0 is the left boundary of max subarray index
	 *         1 is the right boundary of max subarray index 3 is the sum of all
	 *         elements in max subarray
	 */
	public static int[] maxSubarray(int[] input) {
		if(input == null) throw new RuntimeException("Null array is not allowed.");

		if(input.length == 0) return getResult(0,0,0);

		if(input.length == 1){
			return getResult(0,0,input[0]);
		}
		int runningTotal = input[0];
		int curMax = input[0];
		int left = 0;
		int right = 0;
		
		for(int i=1; i<input.length; i++){
			runningTotal = runningTotal + input[i];
			
			if(i-1 == right){
				if(input[i]>0){
					right = i;
					curMax = curMax + input[i];
				}
			}else if(i-1 > right){
				if(runningTotal > curMax){
					if(input[i] >= runningTotal){
						left = i;
						right = i;
						curMax = input[i];
						runningTotal = curMax;
					}else{
						right = i;
						curMax = runningTotal;
					}
				}
			}
		}
		
		return getResult(left, right, curMax);
	}
	
	private static int[] getResult(int left, int right, int total){
		int[] r = new int[3];
		r[0] = left; // m
		r[1] = right; // n
		r[2] = total; // sum		
		
		return r;
	}

}

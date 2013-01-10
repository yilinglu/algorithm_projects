package com.yiling.lu.algorithm.problem.sorting.lineartime;

public class RadixSort {

	/**
	 * Sort from LSB to MSB to get the proper lexicographical order of strings.
	 * 
	 * @param input
	 * @return
	 */
	public static String[] sort(String[] input){
		String[] result = input;
		int maxLen = 0;
		
		for(String str: input){
			int len = str.length();
			if(len>maxLen){
				maxLen = len;
			}
		}
		
		for(int i = maxLen-1; i>=0; i--){
			result  = CountingSort.sortStringArray(result, i);
		}		
		return result;
	}
}

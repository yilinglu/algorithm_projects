package com.yiling.lu.algorithm.problem.longestSomething;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * The longest increasing subsequence ending at nth element will be formed by
 * appending it to the longest increasing subsequence to the left of n that end
 * with an element that is small than Sn (The nth number)
 * 
 * TADM Chapter 8 dynamic programming, section 8.3.
 * Using Heap as data structure to keep track of longest subsequence to the left
 * of n will give better performance on average case. But this is a worst case
 * scenario, i.e., {30, 40, 2,2,2,2,}, starting from the first element of value 2, 
 * every element after that will take a linear time from current index to the beginning 
 * of the array to find the longest subsequence ending with a number less than 2.
 * 
 * 
 * @author ylu
 * 
 */
public class LongestIncreasingSequence {

	public static <T extends Comparable<T>> List<T> findLIS(T[] array) {
		ArrayList<T> list = new ArrayList<T>();
		
		if(array == null || array.length ==0) 
			return list;

		else
			return list;
	}
}

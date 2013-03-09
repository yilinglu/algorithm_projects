package com.yiling.lu.algorithm.problem.longestLargest;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * The longest increasing subsequence ending at nth element will be formed by
 * appending it to the longest increasing subsequence to the left of n that end
 * with an element that is smaller than the value of this nth element (The nth number)
 * 
 * TADM Chapter 8 dynamic programming, section 8.3.
 * Using Heap as data structure to keep track of longest subsequence to the left
 * of n will give better performance on average case. But this is a worst case
 * scenario, i.e., {30, 40, 2,2,2,2,}, starting from the first element of value 2, 
 * every element after that will take a linear time from current index to the beginning 
 * of the array to find the longest subsequence ending with a number less than 2.
 * 
 * Note on March 8th 2013 in San Francisco: A heap will actually guarantee a nlogn
 * performance if we are only interested in THE longest increasing subsequence in a
 * given array. (This implemented solution in this java file will actually calculate the
 * longest increasing subsequence for all of the the n subarrays ending at each index, 
 * which means we calculated more than asked for.) With a heap, at each index,
 * we only update the length and parent index only if the current element is greater
 * than the element at the top of the heap, in which case we will add it to the top of the
 * heap and carry on to the next index.
 * 
 * <ol>
 * <li>
 * scan the input array to establish length array, and predecessor array, using a max heap.
 * <p/>
 * Heap node, key is the length of the longest subsequence end with an element, 
 * value is the value of the element.
 * </li>
 * 
 * <li>
 * scan to length array to find the largest length and its index.
 * </li>
 * 
 * <li>
 * use the above index, find the sequence in the predecessor array.
 * 
 * </li>
 * </ol>
 * 
 * http://en.wikipedia.org/wiki/Longest_increasing_subsequence
 * 
 * 
 * @author ylu
 * 
 */
public class LongestIncreasingSequence {

	public static List<Comparable> findLIS(Comparable[] array) {
		ArrayList<Comparable> list = new ArrayList<Comparable>();
		int size = array.length;
		
		//array of length of the longest increasing subsequence
		//ENDING at each index.
		Integer[] lis = new Integer[size];
		Integer[] parentIndex = new Integer[size];
		
		
		for (int i = 0; i < array.length; i++) {

			int max = Integer.MIN_VALUE;
			int indexOfMax = i;

			Comparable curValue = array[i];

			int k = i;
			while (k >= 0) {
				// check page 291 of TADM for explanation if
				// lost in the code here:
				
				// Basically we scan back to check among all 
				// elements with a value less than the value at current index i, 
				// we will record the index (indexOfMax) of the element that has the Longest Increasion Subsequence 
				// length, and the length (max)
				// 
				Comparable valueAtK = array[k];
				// if value at current index i is greater than 
				// value scanning back, and 
				if (valueAtK.compareTo(curValue) < 0 && lis[k] > max) {
					
					// record the max length behind i and the index
					max = lis[k];
					indexOfMax = k;
				}
				k--;
			}

			if (max != Integer.MIN_VALUE) {
				lis[i] = max + 1;// increment the length by 1
				parentIndex[i] = indexOfMax; // mark the parent of 
			} else {
				lis[i] = 1;
				parentIndex[i] = null;
			}

		}
		
		if(lis.length>0){
			int indexOfLis = findIndexOfMax(lis);
			
			Integer m = indexOfLis;
			// backtrack to find the entire path
			while(m != null){
				list.add(0, array[m]);
				m = parentIndex[m];
			}
		}
		
		return list;
	}

	/**
	 * Given an input array, find and return the index of its max element.
	 * 
	 * @param input
	 * @return index of max element.
	 */
	private static int findIndexOfMax(Comparable[] input){
		int indexOfMax = 0;
		for(int i=0; i<input.length; i++){
			if(input[i].compareTo(input[indexOfMax])>=0){
				indexOfMax = i;
			}
		}
		return indexOfMax;
	}

}

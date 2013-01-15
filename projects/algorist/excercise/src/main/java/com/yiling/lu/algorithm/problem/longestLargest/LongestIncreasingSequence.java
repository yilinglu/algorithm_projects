package com.yiling.lu.algorithm.problem.longestLargest;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

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
		
		
		Integer[] maxLIS = new Integer[size];
		Integer[] pre = new Integer[size];
		
		
		for (int i = 0; i < array.length; i++) {

			int max = Integer.MIN_VALUE;
			int indexOfMax = i;

			Comparable curValue = array[i];

			int k = i;
			while (k >= 0) {
				Comparable c = array[k];
				if (c.compareTo(curValue) < 0 && maxLIS[k] > max) {
					max = maxLIS[k];
					indexOfMax = k;
				}
				k--;
			}

			if (max != Integer.MIN_VALUE) {
				maxLIS[i] = max + 1;
				pre[i] = indexOfMax;
			} else {
				maxLIS[i] = 1;
				pre[i] = null;
			}

		}
		
		if(maxLIS.length>0){
			int indexOfLis = findIndexOfMax(maxLIS);
			
			Integer m = indexOfLis;
			
			while(m != null){
				list.add(0, array[m]);
				m = pre[m];
			}
		}
		
		return list;
	}

	private static int findIndexOfMax(Comparable[] a){
		int indexOfMax = 0;
		for(int i=0; i<a.length; i++){
			if(a[i].compareTo(a[indexOfMax])>=0){
				indexOfMax = i;
			}
		}
		return indexOfMax;
	}

}

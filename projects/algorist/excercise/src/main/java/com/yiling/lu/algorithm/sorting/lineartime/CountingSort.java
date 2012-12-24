package com.yiling.lu.algorithm.sorting.lineartime;

/**
 * Counting sort assume each of the n input elements is an integer
 * between 0 to k, for some integer k. When k=O(n), the sort runs in Big Theta n time.
 * 
 * The running time is O(k+n), if k is n square or NlogN, then this algorithm does not 
 * give linear time performance. It is therefore suited for cases where k is smaller than n
 * 
 * Chapter 8 of LCRS book.
 * 
 * @author yilingl@gmail.com
 *
 */
public class CountingSort {

	public static int[] sort(int[] array){
		if(array.length==0)
			return array;
		
		int max = findMax(array);
		
		// initialize array for 0 to max
		int[] cnt = new int[max+1];
		int[] result = new int[array.length];
		
		// do the counting
		for(int i=0; i<array.length; i++){
			cnt[array[i]] = cnt[array[i]]+1;
		}
		// do the accumulative counting
		for(int i=1; i<cnt.length; i++){
			cnt[i] = cnt[i] + cnt[i-1];
		}
		
		for(int i=array.length-1; i>=0; i--){
			result[cnt[array[i]]-1] = array[i];
			cnt[array[i]] = cnt[array[i]]-1;
		}
		return result;
	}
	
	private static int findMax(int[] input){
		int max = input[0];
		
		for(int i=1; i<input.length; i++){
			if(input[i]>max){
				max = input[i];
			}
		}
		return max;
	}
}

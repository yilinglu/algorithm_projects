package com.yiling.lu.algorithm.sorting;

/**
 * Counting sort assume each of the n input elements is an integer
 * between 0 to k, for some integer k. When k=O(n), the sort runs in Big Theta n time.
 * 
 * The running time is O(k+n), if k is n square or nlogn, then this algorithm does not 
 * give linear time performance. It is therefore suited for cases where k is smaller than n
 * 
 * Chapter 8 of LCRS book.
 * 
 * @author yilingfamily
 *
 */
public class CoutingSort {

	public static void sort(int[] array, int k){
		int[] cnt = new int[k];
		int[] result = new int[array.length];
		
		for(int i=0; i<array.length; i++){
			cnt[array[i]] = cnt[array[i]]+1;
		}
		
		for(int i=1; i<cnt.length; i++){
			cnt[i] = cnt[i] + cnt[i-1];
		}
		
		for(int i=array.length; i>0; i--){
			result[cnt[array[i]]] = result[cnt[array[i]]]-1;
			cnt[array[i]] = cnt[array[i]]-1;
		}
		
	}
}

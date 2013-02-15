package com.yiling.lu.algorithm.problem.sorting.comparasionbased;

import java.util.Random;

public class QuickSort {

	public static <E> void qsort(Comparable<E>[] array){
		shuffle(array);
		qsortInternal(array, 0, array.length-1);
	}
	
	/**
	 * @param input
	 * @param start starting index of the sub-array
	 * @param end index of the sub-array
	 */
	private static <E> void qsortInternal(Comparable<E>[] input, int start, int end){
		if(start<end){
			int i = partition(input, start, end);
			// after this partition, element at ith position is at its sorted position
			// in the final sorted array
			qsortInternal(input, start, i-1);
			qsortInternal(input, i+1, end);
		}
	}
	
	/**
	 * 
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	private static <E> int partition(Comparable<E>[] array, int start, int end){
		Comparable<E> pivot = array[start];
		int low = start;
		
		// Loop Invariant: pivot is at index "start", 
		// low is always pointing at the right most element of the left part (lower part) of the array 
		// , which is the part that is less than or equal to the pivot value.
		for(int high=low+1; high<=end; high++){
			
			if(array[high].compareTo((E)pivot)<0){ 
				low = low + 1;
				swap(array, low,high);
			}
		}
		swap(array, start, low);
		
		return low;
	}
	
	private static <E> void shuffle(Comparable<E>[] array){
		Random rand = new Random();
		int r = rand.nextInt(7);
		
		for(int i=0; i<array.length; i++){
			int w = (i+r)%array.length;
			swap(array, i,w);
		}
	}
	
	private static <E> void swap(Comparable<E>[] input, int a, int b){
		if(a != b){
			Comparable<E> tmp = input[a];
			input[a] = input[b];
			input[b] = tmp;
		}
	}
	
}

package com.yiling.lu.algorithm.sorting.comparasionbased;

public class QuickSort {

	public static <E> void qsort(Comparable<E>[] array){
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
	
	private static <E> int partition(Comparable<E>[] array, int start, int end){
		Comparable<E> pivot = array[start];
		int low = start;
		
		for(int high=low+1; high<=end; high++){
			
			if(array[high].compareTo((E)pivot)<0){ 
				low = low + 1;
				swap(array, low,high);
			}
		}
		swap(array, start, low);
		
		return low;
	}
	
	private static <E> void swap(Comparable<E>[] input, int a, int b){
		Comparable<E> tmp = input[a];
		input[a] = input[b];
		input[b] = tmp;
	}
}

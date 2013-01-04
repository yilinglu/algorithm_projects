package com.yiling.lu.algorithm.problem.searching;

public class BinarySearch {
	public static <E> Comparable<E> binarySearch(Comparable<E>[] array, Comparable<E> key){
		
		int i = binarySearchIndex(array, key);
		if(i >= 0){
			return array[i];
		}else{
			return null;
		}
	}
	
	public static <E> int binarySearchIndex(Comparable<E>[] array, Comparable<E> key){
		
		int left = 0;
		int right = array.length-1;
		
		while(left <= right){
			int mid = (left + right)/2;
			
			if(key.compareTo((E) array[mid])>0){
				left = mid+1;
			}else if(key.compareTo((E) array[mid])<0){
				right = mid-1;
			}else{
				return mid; 
			}
		}
		
		return -1;
	}	
	
	public static <E> int findLeftMostIndex(Comparable<E>[] array, Comparable<E> key){
		
		int left = 0;
		int right = array.length-1;
		
		while(left <= right){
			int mid = (left + right)/2;
			
			if(key.compareTo((E) array[mid])>0){
				left = mid+1;
			}else if(key.compareTo((E) array[mid])<0){
				right = mid-1;
			}else{
				return mid; 
			}
		}
		
		return -1;
	}	
}

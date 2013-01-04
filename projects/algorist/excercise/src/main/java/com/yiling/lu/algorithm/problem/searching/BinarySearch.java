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
	
	public static <E> int searchRightMostOccurrenceIndex(Comparable<E>[] array,
			Comparable<E> key) {
		return searchRightMostOccurrenceIndexInternal(array, key, 0, array.length-1);
	}
	
	/**
	 * 
	 * @param array
	 * @param key
	 * @param left
	 * @param right
	 * @return The index of the right most occurrence of key in sorted argument array.
	 * <b/> The pre-condition is that the key must exist in the array. </p>This is unlike the 
	 * findLeftMostOccurrenceIndex or findRightMostOccurrenceIndex function where the function
	 * will return -1 if element not found.
	 */
	private static <E> int searchRightMostOccurrenceIndexInternal(Comparable<E>[] array,
			Comparable<E> key, int left, int right) {
		if(left > right) return right;
		
		int mid = (left + right) / 2;
			if (key.compareTo((E) array[mid]) < 0) {
				return searchRightMostOccurrenceIndexInternal(array, key, left, mid - 1);
			} else {
				return searchRightMostOccurrenceIndexInternal(array, key, mid+1, right);
			}
	}
	
	/**
	 * @param array
	 * @param key
	 * @return
	 */
	public static <E> int searchLeftMostOccurrenceIndex(Comparable<E>[] array,
			Comparable<E> key) {
		return searchLeftMostOccurrenceIndexInternal(array, key, 0, array.length-1);
	}	
	
	
	public static <E> int countOccurrence(Comparable<E>[] array, Comparable<E> key){
		int left = searchLeftMostOccurrenceIndex(array, key);
		int right = searchRightMostOccurrenceIndex(array, key);
		
		return right - left + 1;
	}
	
	public static <E> int countOccurrence2(Comparable<E>[] array, Comparable<E> key){
		int left = findLeftMostOccurrenceIndex(array, key);
		int right = findRightMostOccurrenceIndex(array, key);
		
		return right - left + 1;
	}	
	
	/**
	 * <p>pre-condition, the argument key must existing in the array.
	 * </p>
	 * @param array
	 * @param key
	 * @param left
	 * @param right
	 * @return the first occurrence (left most occurrence ) of the key in the argument array
	 * 
	 */
	private static <E> int searchLeftMostOccurrenceIndexInternal(Comparable<E>[] array,
			Comparable<E> key, int left, int right) {
		if(left > right) return left;
		
		int mid = (left + right) / 2;
			if (key.compareTo((E) array[mid]) > 0) {
				return searchLeftMostOccurrenceIndexInternal(array, key, mid+1, right);
			} else {
				return searchLeftMostOccurrenceIndexInternal(array, key, left, mid-1);
			}
	}	
	
	public static <E> int findLeftMostOccurrenceIndex(Comparable<E>[] array, Comparable<E> key){
		if(array.length==0) return -1;
		
		int left = 0;
		int right = array.length-1;
		
		while(left < right){
			int mid = (left + right)/2;
			
			if(key.compareTo((E) array[mid])>0){
				left = mid+1;
			}else if(key.compareTo((E) array[mid])<0){
				right = mid-1;
			}else{
				right = mid;
			}
		}
		if(array[right].compareTo((E) key)==0){
			return right;
		}else{
			return -1;
		}
	}	
	
	public static <E> int findRightMostOccurrenceIndex(Comparable<E>[] array, Comparable<E> key){
		if(array.length==0) return -1;
		
		int left = 0;
		int right = array.length-1;
		
		while(left < right){
			double middle = Math.ceil((left+right)/2.0);
			int mid = new Double(middle).intValue();
			
			if(key.compareTo((E) array[mid])>0){
				left = mid+1;
			}else if(key.compareTo((E) array[mid])<0){
				right = mid-1;
			}else{
				left = mid;
			}
		}
		if(array[left].compareTo((E) key)==0){
			return left;
		}else{
			return -1;
		}		
	}
}

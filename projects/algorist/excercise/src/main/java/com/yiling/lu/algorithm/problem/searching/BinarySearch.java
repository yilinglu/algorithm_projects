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
	

	


	
	public static <E> int countOccurrence(Comparable<E>[] array, Comparable<E> key){
		int left = findLeftMostOccurrenceIndex(array, key);
		int right = findRightMostOccurrenceIndex(array, key);
		
		return right - left + 1;
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

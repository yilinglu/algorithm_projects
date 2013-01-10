package com.yiling.lu.algorithm.problem.searching;

public class BoundaryBinarySearch {
	
	
	public static <E> int findRightBoundaryIndex(Comparable<E>[] array,
			Comparable<E> key) {
		return findRightBounaryIndexInternal(array, key, 0, array.length-1);
	}
	
	/**
	 * @param array
	 * @param key
	 * @return
	 */
	public static <E> int findLeftBoundaryIndex(Comparable<E>[] array,
			Comparable<E> key) {
		return findLeftBounaryIndexInternal(array, key, 0, array.length-1);
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
	private static <E> int findRightBounaryIndexInternal(Comparable<E>[] array,
			Comparable<E> key, int left, int right) {
		if(left > right) return right;
		
		int mid = (left + right) / 2;
			if (key.compareTo((E) array[mid]) < 0) {
				return findRightBounaryIndexInternal(array, key, left, mid - 1);
			} else {
				// increment the mid index and keep searching on the right half when the
				// key is found, if there are more occurrences on the right half/side, this
				// recursive search will keep going to the right till it converges on the 
				// right most one, then the "search to the left half" recursion will send
				// the right boundary over the the left of the left boundary, which is the
				// termination condition of this recursion, the right boundary index is the
				// right most occurrence of the argument key on termination.
				return findRightBounaryIndexInternal(array, key, mid+1, right);
			}
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
	private static <E> int findLeftBounaryIndexInternal(Comparable<E>[] array,
			Comparable<E> key, int left, int right) {
		if(left > right) return left;
		
		int mid = (left + right) / 2;
			if (key.compareTo((E) array[mid]) > 0) {
				return findLeftBounaryIndexInternal(array, key, mid+1, right);
			} else {
				return findLeftBounaryIndexInternal(array, key, left, mid-1);
			}
	}
	
	public static <E> int countOccurrence(Comparable<E>[] array, Comparable<E> key){
		int left = findLeftBoundaryIndex(array, key);
		int right = findRightBoundaryIndex(array, key);
		
		return right - left + 1;
	}
	
	
}

package com.yiling.lu.algorithm.datastructure;

/**
 * "The heap is a slick data structure that enables us to represent binary trees
 * without using any pointers. We will store data as an array of keys, and use
 * the position of the keys to implicitly satisfy the role of the pointers." - TADM
 * 
 * Section 4.3 in TADM, Heapsort: Fast sorting via data structure.
 * 
 * @author ylu
 * 
 * @param <T>
 */
public class BinaryHeap<T extends Comparable<T>> {
	private T[] array;
	private int heapSize = 0;
	
	public BinaryHeap(T[] a) {
		array = a;
		heapSize = a.length;
	}

	public BinaryHeap() {

	}	
	
	/**
	 * Build a heap using recursive bubbledown method in O(n) time.
	 * @param a array Given an arbitrary array.
	 */
	public void buildHeap() {
		if(array == null) return;
		for(int i=heapSize-1; i>=0; i--){
			bubbleDown(array, i);
		}

	}
	
	private void bubbleUp(int index){
		while(index > 0){
			int parent = parent(index);
			if(array[parent].compareTo(array[index]) < 0){
				swap(array, parent, index);
			}
			index = parent;
		}
	}
	
	private void bubbleDown(T[] a, int rootIndex){
		if(a[rootIndex] == null){
			throw new RuntimeException("Null element not allowed in input array!");
		}
		int left = left(rootIndex);
		
//		int minIndex = rootIndex;
//		for(int i = left; i< heapLen; i++){
//			if(a[i])
//		}
		
		int right = right(rootIndex);
		
		if(left < heapSize && a[left].compareTo(a[rootIndex]) > 0){
			swap(a, left, rootIndex);
			bubbleDown(a,left);
		}
		if(right < heapSize && a[right].compareTo(a[rootIndex]) > 0){
			swap(a, right, rootIndex);
			bubbleDown(a, right);
		}
		
	}
	
	private void swap(T[] a, int i, int j){
		if(i!=j && i < heapSize && j < heapSize){
			T temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	}

	private int parent(Integer i) {
		//return new Double(Math.floor((i - 1.0) / 2.0)).intValue();
		return i/2;
	}

	private int left(Integer i) {
		return i * 2 + 1;
	}

	private int right(Integer i) {
		return i * 2 + 2;
	}

	public void insert(T p) {
		array[heapSize] = p;
		bubbleUp(heapSize);
		heapSize++;
	}

	public T findMax() {
		if(array != null && heapSize > 0)
			return array[0];
		else
			return null;
	}

	/**
	 * 
	 * @return Max value of heap. Remove it as well.
	 */
	public T extractMax() {
		T result = null;
		
		if(findMax() != null){
			swap(array, 0, heapSize-1);
			heapSize--;
			result = array[heapSize];
			bubbleDown(array, 0);
		}
		return result;
	}
	
	public int getHeapLength(){
		return heapSize;
	}
	protected T[] getArray(){
		return array;
	}
}

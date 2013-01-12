package com.yiling.lu.algorithm.datastructure;

/**
 * "The heap is a slick data structure that enables us to represent binary trees
 * without using any pointers. We will store data as an array of keys, and use
 * the position of the keys to implicitly satisfy the role of the pointers." - TADM
 * 
 * @author ylu
 * 
 * @param <T>
 */
public class BinaryHeap<T extends Comparable<T>> {

	public BinaryHeap() {

	}

	public void createHeap(T[] a) {

	}

	private int parent(Integer i) {
		return new Double(Math.floor((i - 1.0) / 2.0)).intValue();
	}

	private int left(Integer i) {
		return i * 2 + 1;
	}

	private int right(Integer i) {
		return i * 2 + 2;
	}

	public void insert(T p) {

	}

	public T findMax() {
		return null;
	}

	/**
	 * Or extrax Max if we like.
	 * @return
	 */
	public T deleteMax() {
		return null;
	}
}

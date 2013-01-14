package com.yiling.lu.algorithm.problem.longestLargest;

public class HeapNode implements Comparable{
	protected final Comparable length;
	protected final Comparable value;
	
	public HeapNode(Comparable theIndex, Comparable theValue){
		length = theIndex;
		value = theValue;
	}

	@Override
	public int compareTo(Object o) {
		HeapNode node = (HeapNode)o;
		return length.compareTo(node.length);
	}
}

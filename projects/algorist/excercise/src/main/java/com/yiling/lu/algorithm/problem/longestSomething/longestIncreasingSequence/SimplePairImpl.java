package com.yiling.lu.algorithm.problem.longestSomething.longestIncreasingSequence;

public class SimplePairImpl<E extends Comparable<E>> implements SimplePair<E> {
	private final E key;
	private final E value;
	
	public SimplePairImpl(E theKey, E theValue){
		key = theKey;
		value = theValue;
	}
	
	@Override
	public E getKey() {
		return key;
	}

	@Override
	public E getValue() {
		// TODO Auto-generated method stub
		return value;
	}

}

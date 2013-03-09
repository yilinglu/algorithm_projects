package com.yiling.lu.algorithm.problem.cache;

public interface Cache<T> {

	public void insert(CacheNode cacheNode);
	public void find(T key);
}

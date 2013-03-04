package com.yiling.lu.algorithm.datastructure.tree;

public class Counter {
	private int cnt;
	
	public int getCnt(){
		return cnt;
	}
	public void increment(){
		cnt++;
	}
	public String toString(){
		return Integer.toString(cnt);
	}
}

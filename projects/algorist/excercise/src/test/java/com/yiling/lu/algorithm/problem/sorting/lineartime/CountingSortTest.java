package com.yiling.lu.algorithm.problem.sorting.lineartime;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import CtCILibrary.AssortedMethods;

import com.yiling.lu.algorithm.problem.sorting.lineartime.CountingSort;
import com.yiling.lu.algorithm.util.AssortedUtils;

public class CountingSortTest {

	@Test
	public void test() {
		int[] input = {100,5,49,585,884,4,3,32,333,34,33,33,100,1,1,0,0,0,5};
		int[] output = CountingSort.sort(input);
		AssortedUtils.verifyOder(output, true);
	}

	@Test
	public void testSimple() {
		int[] input = {33,100,1,1,0,0,0,5};
		int[] output = CountingSort.sort(input);
		AssortedUtils.verifyOder(output, true);
	}
	
	@Test
	public void testSimple2() {
		int[] input = {10, 0};
		int[] output = CountingSort.sort(input);
		AssortedUtils.verifyOder(output, true);
	}	
	
	@Test
	public void testSorted() {
		int[] input = {0,1,2,3,4,5,6};
		int[] output = CountingSort.sort(input);
		AssortedUtils.verifyOder(output, true);
	}
	
	@Test
	public void testReverseSoted() {
		int[] input = {10,9,8,7,6,5,4,3,2,1,0};
		int[] output = CountingSort.sort(input);
		AssortedUtils.verifyOder(output, true);
	}	
	
	@Test
	public void testMonotone() {
		int[] input = {2,2,2,2,2,2};
		int[] output = CountingSort.sort(input);
		AssortedUtils.verifyOder(output, true);
	}
	
	@Test
	public void testMonotone2() {
		int[] input = {5,5,5,5,5};
		int[] output = CountingSort.sort(input);
		AssortedUtils.verifyOder(output, true);
	}	
	
	
	@Test
	public void testMonotone3() {
		int[] input = {0,0,0,0,0};
		int[] output = CountingSort.sort(input);
		AssortedUtils.verifyOder(output, true);
	}	
	
	@Test
	public void testEmpty() {
		int[] input = {};
		int[] output = CountingSort.sort(input);
		AssortedUtils.verifyOder(output, true);
	}	

	@Test
	public void testOneElement() {
		int[] input = {10};
		int[] output = CountingSort.sort(input);
		AssortedUtils.verifyOder(output, true);
	}	
	
	@Test
	public void testSortChar(){
		String[] input = {"z", "b", "c", "a", "d", "f", "y", "x", "n", "m", "q", "p", "l"};
		
		String[] output = CountingSort.sortStringArray(input, 0);
		
		System.out.println("sorting result " + 
		AssortedMethods.stringArrayToString(output));
		AssortedUtils.verifyOrder(output);
	}
	
	@Test
	public void testGetKey(){
		String str = "ab";
		int r = CountingSort.getKey(str, 2);
		Assert.assertEquals(r, (int)' ');

		r = CountingSort.getKey(str, 3);
		Assert.assertEquals(r, (int)' ');
	
		r = CountingSort.getKey(str, 0);
		Assert.assertEquals(r, (int)'a');

		r = CountingSort.getKey(str, 1);
		Assert.assertEquals(r, (int)'b');
		
	}
	
}

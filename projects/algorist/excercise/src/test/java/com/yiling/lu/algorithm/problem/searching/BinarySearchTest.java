package com.yiling.lu.algorithm.problem.searching;

import junit.framework.Assert;

import org.junit.Test;

import CtCILibrary.AssortedMethods;

import com.yiling.lu.algorithm.sorting.comparasionbased.QuickSort;
import com.yiling.lu.algorithm.util.AssortedUtils;

public class BinarySearchTest{

	@Test
	public void sortAndTest(){
		String[] array = {"6", "a", "b", "c", "a", "d", "d", "d", "x", "n", "m", "q", "d", "6"};
		
		QuickSort.qsort(array);
		
		System.out.println("sorting result " + 
		AssortedMethods.stringArrayToString(array));
		AssortedUtils.verifyOrder(array);	
		
	}
	
	@Test
	public void simpleTest(){
		String[] array = {"a","b", "c", "d", "e", "f", "g"};
		
		String result = (String) BinarySearch.binarySearch(array, "g");
		System.out.println("binary search result found " + result);
		Assert.assertEquals("g", result);
	}
	
	@Test
	public void simpleTest2(){
		String[] array = {"a","b", "c", "d", "e", "f", "g"};
		
		String result = (String) BinarySearch.binarySearch(array, "a");
		System.out.println("binary search result found " + result);
		Assert.assertEquals("a", result);
	}	
	
	@Test
	public void simpleTest3(){
		String[] array = {"a"};
		
		String result = (String) BinarySearch.binarySearch(array, "a");
		System.out.println("binary search result found " + result);
		Assert.assertEquals("a", result);
	}
	
	@Test
	public void simpleTest4(){
		String[] array = {""};
		
		String result = (String) BinarySearch.binarySearch(array, "a");
		System.out.println("binary search result found " + result);
		Assert.assertNull(result);
	}	
	
	@Test
	public void simpleTest5(){
		String[] array = {"a","b", "c", "d", "e", "f", "g"};
		
		String result = (String) BinarySearch.binarySearch(array, "p");
		System.out.println("binary search result found " + result);
		Assert.assertNull(result);
	}	
}

package com.yiling.lu.algorithm.problem.searching;

import junit.framework.Assert;

import org.junit.Test;

import CtCILibrary.AssortedMethods;

import com.yiling.lu.algorithm.problem.sorting.comparasionbased.QuickSort;
import com.yiling.lu.algorithm.util.AssortedUtils;

public class BinarySearchTest{

	@Test
	public void testFindLeftIndex(){
		String[] array = {"a","b", "c", "d", "e", "f", "g"};
		
		int leftIndex = BinarySearch.findLeftMostOccurrenceIndex(array, "g");
		System.out.println("index of the left most occurrence: " + leftIndex);
		Assert.assertEquals(6, leftIndex);		
	}
	
	@Test
	public void testFindLeftIndex2(){
		String[] array = {"a","b", "c", "d", "e", "f", "g"};
		
		int leftIndex = BinarySearch.findLeftMostOccurrenceIndex(array, "p");
		System.out.println("index of the left most occurrence: " + leftIndex);
		Assert.assertEquals(-1, leftIndex);		
	}	
	
	@Test
	public void testFindLeftIndexAllDups(){
		String[] array = {"a","a", "a", "a"};
		
		int leftIndex = BinarySearch.findLeftMostOccurrenceIndex(array, "a");
		System.out.println("index of the left most occurrence: " + leftIndex);
		Assert.assertEquals(0, leftIndex);		
	}	
	
	@Test
	public void testFindLeftIndexAllDups2(){
		String[] array = {"1","a", "a", "a"};
		
		int leftIndex = BinarySearch.findLeftMostOccurrenceIndex(array, "a");
		System.out.println("index of the left most occurrence: " + leftIndex);
		Assert.assertEquals(1, leftIndex);		
	}
	
	@Test
	public void testFindLeftIndex3(){
		String[] array = {};
		
		int leftIndex = BinarySearch.findLeftMostOccurrenceIndex(array, "p");
		System.out.println("index of the left most occurrence: " + leftIndex);
		Assert.assertEquals(-1, leftIndex);		
	}
	
	@Test
	public void testFindLeftIndex4(){
		String[] array = {"a","a", "a", "d", "e", "g", "g"};
		
		int leftIndex = BinarySearch.findLeftMostOccurrenceIndex(array, "g");
		System.out.println("index of the left most occurrence: " + leftIndex);
		Assert.assertEquals(5, leftIndex);	
		
		leftIndex = BinarySearch.findLeftMostOccurrenceIndex(array, "a");
		System.out.println("index of the left most occurrence: " + leftIndex);
		Assert.assertEquals(0, leftIndex);			
	}	
	
	@Test
	public void testFindLeftIndex5(){
		String[] array = {"2", "3", "a","a", "a", "d", "e", "g", "g"};
		
		int leftIndex = BinarySearch.findLeftMostOccurrenceIndex(array, "a");
		System.out.println("index of the left most occurrence: " + leftIndex);
		Assert.assertEquals(2, leftIndex);	
	}	
	
	@Test
	public void testFindRightMostIndex(){
		String[] array = {"a","a", "a", "d", "e", "g", "g"};
		
		int rightIndex = BinarySearch.findRightMostOccurrenceIndex(array, "g");
		System.out.println("index of the left most occurrence: " + rightIndex);
		Assert.assertEquals(6, rightIndex);	
		
		rightIndex = BinarySearch.findRightMostOccurrenceIndex(array, "a");
		System.out.println("index of the left most occurrence: " + rightIndex);
		Assert.assertEquals(2, rightIndex);			
	}	
	
	@Test
	public void testFindRightMostIndex1(){
		String[] array = {};
		
		int rigthIndex = BinarySearch.findRightMostOccurrenceIndex(array, "p");
		System.out.println("index of the right most occurrence: " + rigthIndex);
		Assert.assertEquals(-1, rigthIndex);		
	}	
	
	@Test
	public void testFindRightMostIndex2(){
		String[] array = {"a"};
		
		int rigthIndex = BinarySearch.findRightMostOccurrenceIndex(array, "a");
		System.out.println("index of the right most occurrence: " + 0);
		Assert.assertEquals(0, rigthIndex);		
	}	
	
	@Test
	public void testFindRightMostIndex3(){
		String[] array = {"a", "a"};
		
		int rigthIndex = BinarySearch.findRightMostOccurrenceIndex(array, "a");
		System.out.println("index of the right most occurrence: " + 1);
		Assert.assertEquals(1, rigthIndex);		
	}	
	
	@Test
	public void testBST(){
		String[] array = {"a","b", "c", "d", "e", "f", "g"};
		
		String result = (String) BinarySearch.binarySearch(array, "g");
		System.out.println("binary search result found " + result);
		Assert.assertEquals("g", result);
	}
	
	@Test
	public void testBST2(){
		String[] array = {"a","b", "c", "d", "e", "f", "g"};
		
		String result = (String) BinarySearch.binarySearch(array, "a");
		System.out.println("binary search result found " + result);
		Assert.assertEquals("a", result);
	}	
	
	@Test
	public void testBST3(){
		String[] array = {"a"};
		
		String result = (String) BinarySearch.binarySearch(array, "a");
		System.out.println("binary search result found " + result);
		Assert.assertEquals("a", result);
	}
	
	@Test
	public void testBST4(){
		String[] array = {};
		
		String result = (String) BinarySearch.binarySearch(array, "a");
		System.out.println("binary search result found " + result);
		Assert.assertNull(result);
	}	
	
	@Test
	public void testBST5(){
		String[] array = {"a","b", "c", "d", "e", "f", "g"};
		
		String result = (String) BinarySearch.binarySearch(array, "p");
		System.out.println("binary search result found " + result);
		Assert.assertNull(result);
	}	
}

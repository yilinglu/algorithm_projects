package com.yiling.lu.algorithm.problem.longestLargest.maxSubarray;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import CtCILibrary.AssortedMethods;

public class MaxSubarrayTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindMaxSubArrayOneElement() {
		int[] array = {10};
		int[] result = MaxSubarray.maxSubarray(array);
		
		assertEquals(0, result[0]);
		assertEquals(0, result[1]);
		assertEquals(10, result[2]);
	}
	
	@Test
	public void testFindMaxSubArrayEmptyArray() {
		int[] array = {};
		int[] result = MaxSubarray.maxSubarray(array);
		
		assertEquals(0, result[0]);
		assertEquals(0, result[1]);
		assertEquals(0, result[2]);
	}
	
	@Test(expected=NullPointerException.class)
	public void testFindMaxSubArrayNull() {
		int[] array = null;
		int[] result = MaxSubarray.maxSubarray(array);
		
		assertEquals(0, result[0]);
		assertEquals(0, result[1]);
		assertEquals(0, result[2]);
	}	
	
	@Test
	public void testFindMaxSubArraySimple() {
		int[] array = {10,-1,5};
		int[] result = MaxSubarray.maxSubarray(array);
		
		assertEquals(0, result[0]);
		assertEquals(2, result[1]);
		assertEquals(14, result[2]);
		
		int[] result2 = MaxSubArrayRecursive.maxSubarray(array);
		
		for(int i=0; i<result.length; i++){
			assertEquals(" expecting result " + result[i] + ", and result 2 " + result2[i] + " to be equal.", result[i], result2[i]);
		}
	}	
	
	@Test
	public void testFindMaxSubArraySimple2() {
		int[] array = {10,9,1,-1,5};
		int[] result = MaxSubarray.maxSubarray(array);
		
		assertEquals(0, result[0]);
		assertEquals(4, result[1]);
		assertEquals(24, result[2]);
		
		int[] result2 = MaxSubArrayRecursive.maxSubarray(array);
		
		for(int i=0; i<result.length; i++){
			assertEquals(" expecting result " + result[i] + ", and result 2 " + result2[i] + " to be equal.", result[i], result2[i]);
		}		
	}	
	@Test
	public void testFindMaxSubArraySimple3() {
		int[] array = {10,9,1,-20,50};
		int[] result = MaxSubarray.maxSubarray(array);
		AssortedMethods.printIntArray(result);
		
		assertEquals(0, result[0]);
		assertEquals(4, result[1]);
		assertEquals(50, result[2]);
	}
	
	@Test
	public void testFindMaxSubArray() {
		int[] array = {10,9,1,-20,50};
		int[] result = MaxSubarray.maxSubarray(array);
		AssortedMethods.printIntArray(result);
		
		assertEquals(0, result[0]);
		assertEquals(4, result[1]);
		assertEquals(50, result[2]);
		
		int[] result2 = MaxSubArrayRecursive.maxSubarray(array);
		AssortedMethods.printIntArray(result2);

		int total1 = calcTotal(array, result[0], result[1]);
		int total2 = calcTotal(array, result2[0], result2[1]);
		
		assertEquals("the max subarray sum should be the same from different algorithm, start and end index might not match as there could be multiple max subarray", 
				total1, total2);		
	}	
	
	@Test
	public void testFindMaxSubArray2() {
		int[] array = {10,9,1,-2,50};
		int[] result = MaxSubarray.maxSubarray(array);
		
		assertEquals(0, result[0]);
		assertEquals(4, result[1]);
		assertEquals(68, result[2]);
	}	
	
	@Test
	public void testFindMaxSubArray3() {
		int[] array = {10,9,1,-2,50, -1, 9, -2,-5, 8};
		int[] result = MaxSubarray.maxSubarray(array);
		
		assertEquals(0, result[0]);
		assertEquals(77, result[2]);
		assertEquals(9, result[1]);
		
		AssortedMethods.printIntArray(result);
	}
	
	@Test
	public void testFindMaxSubArray4() {
		int[] array = {10,9,1,-2,50, -1, 9, -2,-5, 8, -500,600};
		int[] result = MaxSubarray.maxSubarray(array);
		
		assertEquals(11, result[0]);
		assertEquals(600, result[2]);
		assertEquals(11, result[1]);
	}	
	
	@Test
	public void testFindMaxSubArray5() {
		int[] array = {77,-500,600, -600, 50, 550};
		int[] result = MaxSubarray.maxSubarray(array);
		AssortedMethods.printIntArray(result);
		
		assertEquals(2, result[0]);
		assertEquals(2, result[1]);
		assertEquals(600, result[2]);
		
		int[] result2 = MaxSubArrayRecursive.maxSubarray(array);
		AssortedMethods.printIntArray(result2);
		
		int total1 = calcTotal(array, result[0], result[1]);
		int total2 = calcTotal(array, result2[0], result2[1]);
		
		assertEquals("the max subarray sum should be the same from different algorithm, start and end index might not match as there could be multiple max subarray", 
				total1, total2);
		
	}	
	
	@Test
	public void testFindMaxSubArray6() {
		int[] array = {77,-500,600, -600, 50, 551};
		int result = LinearMaxSubarray.maxSubarray(array);
		assertEquals(601, result);
		
		int[] result2 = MaxSubArrayRecursive.maxSubarray(array);
		AssortedMethods.printIntArray(result2);
		
		int total2 = calcTotal(array, result2[0], result2[1]);
		
		assertEquals("the max subarray sum should be the same from different algorithm, start and end index might not match as there could be multiple max subarray", 
				result, total2);
	}	
	
	private int calcTotal(int[] array, int s, int e){
		int runningTotal = array[s];
		for(int k = s+1; k<=e; k++){
			runningTotal = runningTotal + array[k];
		}
		return runningTotal;
	}
	
	@Test
	public void testFindMaxSubArrayLinear1() {
		int[] array = {1,2,-50,1,2,1};
		int[] result = MaxSubarray.maxSubarray(array);
		
		assertEquals(3, result[0]);
		assertEquals(5, result[1]);
		assertEquals(4, result[2]);
	}	
	
	@Test
	public void testFindMaxSubArrayRecursive1() {
		int[] array = {1,2,-50,1,2,1};
		int[] result = MaxSubArrayRecursive.maxSubarray(array);
		AssortedMethods.printIntArray(result);
		
		assertEquals(3, result[0]);
		assertEquals(5, result[1]);
		assertEquals(4, result[2]);
	}
	
	@Test
	public void testFindMaxSubArrayRecursive2() {
		int[] array = {-1,-2,-50,-4,-2,-3};
		int[] result = MaxSubArrayRecursive.maxSubarray(array);
		AssortedMethods.printIntArray(result);
		
		assertEquals(0, result[0]);
		assertEquals(0, result[1]);
		assertEquals(-1, result[2]);
	}	
	
	
	/**
	 * input array taken from this paper:
	 * http://www.cs.waikato.ac.nz/Teaching/COMP317B/Week_1/AlgorithmDesignTechniques.pdf
	 * 
	 */
	@Test
	public void testFindMaxSubArrayRecursive3() {
		int[] array = {-31,-41,59,26,-53,58,97,-93,-23,84};
		int[] result = MaxSubArrayRecursive.maxSubarray(array);
		AssortedMethods.printIntArray(result);
		
		assertEquals(2, result[0]);
		assertEquals(6, result[1]);
		assertEquals(187, result[2]);
	}	
	
	@Test
	public void testFindMaxSubArrayLinear2() {
		int[] array = {-31,-41,59,26,-53,58,97,-93,-23,84};
		int result = LinearMaxSubarray.maxSubarray(array);
		
		assertEquals(187, result);
	}	
	
	
}

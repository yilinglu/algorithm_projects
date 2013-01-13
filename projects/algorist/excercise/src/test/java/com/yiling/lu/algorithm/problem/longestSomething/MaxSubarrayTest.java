package com.yiling.lu.algorithm.problem.longestSomething;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
	
	@Test(expected=RuntimeException.class)
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
	}	
	
	@Test
	public void testFindMaxSubArraySimple2() {
		int[] array = {10,9,1,-1,5};
		int[] result = MaxSubarray.maxSubarray(array);
		
		assertEquals(0, result[0]);
		assertEquals(24, result[2]);
		assertEquals(4, result[1]);
	}	
	
	@Test
	public void testFindMaxSubArray() {
		int[] array = {10,9,1,-20,50};
		int[] result = MaxSubarray.maxSubarray(array);
		
		assertEquals(4, result[0]);
		assertEquals(50, result[2]);
		assertEquals(4, result[1]);
	}	
	
	@Test
	public void testFindMaxSubArray2() {
		int[] array = {10,9,1,-2,50};
		int[] result = MaxSubarray.maxSubarray(array);
		
		assertEquals(0, result[0]);
		assertEquals(68, result[2]);
		assertEquals(4, result[1]);
	}	
	
	@Test
	public void testFindMaxSubArray3() {
		int[] array = {10,9,1,-2,50, -1, 9, -2,-5, 8};
		int[] result = MaxSubarray.maxSubarray(array);
		
		assertEquals(0, result[0]);
		assertEquals(77, result[2]);
		assertEquals(9, result[1]);
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
		
		assertEquals(2, result[0]);
		assertEquals(600, result[2]);
		assertEquals(2, result[1]);
	}	
	
	@Test
	public void testFindMaxSubArray6() {
		int[] array = {77,-500,600, -600, 50, 551};
		int[] result = MaxSubarray.maxSubarray(array);
		
		assertEquals(2, result[0]);
		assertEquals(601, result[2]);
		assertEquals(5, result[1]);
	}		
}

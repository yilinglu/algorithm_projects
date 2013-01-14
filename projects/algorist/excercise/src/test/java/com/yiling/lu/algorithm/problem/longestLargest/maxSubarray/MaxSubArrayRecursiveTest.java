/**
 * 
 */
package com.yiling.lu.algorithm.problem.longestLargest.maxSubarray;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.yiling.lu.algorithm.problem.longestLargest.maxSubarray.MaxSubArrayRecursive;

import CtCILibrary.AssortedMethods;

/**
 * @author yilingfamily
 *
 */
public class MaxSubArrayRecursiveTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMaxSubarrayRecursive1() {
		int[] array = {10};
		int[] result = MaxSubArrayRecursive.maxSubarray(array);
		
		assertEquals(0, result[0]);
		assertEquals(0, result[1]);
		assertEquals(10, result[2]);		
	}
	
	@Test
	public void testMaxSubarrayRecursive2() {
		int[] array = {10,-1,5};
		int[] result = MaxSubArrayRecursive.maxSubarray(array);
		
		assertEquals(0, result[0]);
		assertEquals(2, result[1]);
		assertEquals(14, result[2]);	
	}	
	
	@Test
	public void testMaxSubarrayRecursive3() {
		int[] array = {77,-500,600, -600, 50, 551};
		int[] result = MaxSubArrayRecursive.maxSubarray(array);
		AssortedMethods.printIntArray(result);
		assertEquals(4, result[0]);
		assertEquals(5, result[1]);
		assertEquals(601, result[2]);	
	}	
	
	@Test
	public void testFindMaxSubArray5() {
		int[] array = {77,-500,600, -600, 50, 550};
		int[] result = MaxSubArrayRecursive.maxSubarray(array);
		
		AssortedMethods.printIntArray(result);

		assertEquals(4, result[0]);
		assertEquals(5, result[1]);
		assertEquals(600, result[2]);
		
	}	
	
	@Test
	public void testFindMaxSubArray6() {
		int[] array = {10,9,1,-20,50};
		int[] result = MaxSubArrayRecursive.maxSubarray(array);
		
		AssortedMethods.printIntArray(result);

		assertEquals(4, result[0]);
		assertEquals(4, result[1]);
		assertEquals(50, result[2]);
		
	}	
	

}

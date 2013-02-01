package com.yiling.lu.algorithm.problem.theAlgorithmDesignManual.dataStructures;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import CtCILibrary.AssortedMethods;

public class TestFindProductsArray {

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
	public void testFindProductsArray() {
		int[] x = {2,2,2,2,2,2,2,2,2};
		int[] result = FindProductsArray.findProductsArray(x);
		
		AssortedMethods.printIntArray(result);
		
		int p = 4;
		int product = 1;
		
		for(int i=0; i<p; i++){
			product = product*x[i];
			// product value is product of all integers 
			// in x up till index 4, but not including 4.
			// by the requirements of the problem, result[4] 
			// value should be equal to this product value.
		}
		assertEquals(product, result[p]);		
	}
	

	@Test
	public void testFindProductsArray2() {
		int[] x = {1,2,3,4,5,6,7};
		int[] result = FindProductsArray.findProductsArray(x);
		
		AssortedMethods.printIntArray(result);
		
		int p = 4;
		int product = 1;
		
		for(int i=0; i<p; i++){
			product = product*x[i];
			// product value is product of all integers 
			// in x up till index 4, but not including 4.
			// by the requirements of the problem, result[4] 
			// value should be equal to this product value.
		}
		assertEquals(product, result[p]);
		
		assertEquals(0, result[0]);		
		assertEquals(1, result[1]);	
		assertEquals(2, result[2]);		
		assertEquals(6, result[3]);		
		
		
	}	
	
	@Test
	public void testFindProductsArray3() {
		int[] x = {10};
		int[] result = FindProductsArray.findProductsArray(x);
		
		AssortedMethods.printIntArray(result);

		assertEquals(0, result[0]);		
	}
	
	
	@Test
	public void testFindProductsArray4() {
		int[] x = {10, 2};
		int[] result = FindProductsArray.findProductsArray(x);
		
		AssortedMethods.printIntArray(result);

		assertEquals(0, result[0]);		
		assertEquals(10, result[1]);
		assertEquals(2, result.length);
	}	
	
	@Test
	public void testFindProdArray1() {
		int[] x = {10, 2};
		int[] result = FindProductsArray.findProdArray(x);
		
		AssortedMethods.printIntArray(result);

		assertEquals(2, result[0]);		
		assertEquals(10, result[1]);
		assertEquals(2, result.length);
	}	
	
	@Test
	public void testFindProdArrayEdgeCase1() {
		int[] x = {10};
		int[] result = FindProductsArray.findProdArray(x);
		
		AssortedMethods.printIntArray(result);

		assertEquals(0, result[0]);		
		assertEquals(1, result.length);
	}
	
	@Test
	public void testFindProdArrayEdgeCase2() {
		int[] x = {};
		int[] result = FindProductsArray.findProdArray(x);
		
		AssortedMethods.printIntArray(result);

		assertEquals(0, result.length);
	}
	
	@Test
	public void testFindProdArrayEdgeCase3() {
		int[] x = null;
		int[] result = FindProductsArray.findProdArray(x);

		assertNull(result);
	}
	
	
	@Test
	public void testFindProdArray2() {
		int[] x = {10, 2, 3};
		int[] result = FindProductsArray.findProdArray(x);
		
		AssortedMethods.printIntArray(result);

		assertEquals(6, result[0]);		
		assertEquals(30, result[1]);
		assertEquals(20, result[2]);
		assertEquals(3, result.length);
	}	
	
	@Test
	public void testFindProdArray3() {
		int[] x = {10, 2, 3, 8, 1};
		int[] result = FindProductsArray.findProdArray(x);
		
		AssortedMethods.printIntArray(result);

		assertEquals(48, result[0]);		
		assertEquals(240, result[1]);
		assertEquals(160, result[2]);
		assertEquals(60, result[3]);
		assertEquals(480, result[4]);
		assertEquals(5, result.length);
	}	

}

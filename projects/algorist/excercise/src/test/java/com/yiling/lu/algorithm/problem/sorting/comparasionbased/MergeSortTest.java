package com.yiling.lu.algorithm.problem.sorting.comparasionbased;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MergeSortTest {

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
	public void testMergeSort() {
		int[] array = {30,5,15};

		MergeSort mergesort = new MergeSort();
		
		int[] result = mergesort.mergeSort(array);
		
		assertEquals(5, result[0]);
		assertEquals(15, result[1]);
		assertEquals(30, result[2]);
		
		assertEquals(2, mergesort.inversionCount);

	}

	@Test
	public void testMergeSortAlreadySorted() {
		int[] array = {1,2,3,4,5};

		MergeSort mergesort = new MergeSort();
		
		int[] result = mergesort.mergeSort(array);
		
		assertEquals(1, result[0]);
		assertEquals(2, result[1]);
		assertEquals(3, result[2]);
		assertEquals(4, result[3]);
		assertEquals(5, result[4]);
		assertEquals(0, mergesort.inversionCount);
		
	}
	
	@Test
	public void testMergeSortAlreadySorted2() {
		int[] array = {1,2,3,4,5,6};

		MergeSort mergesort = new MergeSort();
		
		int[] result = mergesort.mergeSort(array);
		
		assertEquals(1, result[0]);
		assertEquals(2, result[1]);
		assertEquals(3, result[2]);
		assertEquals(4, result[3]);
		assertEquals(5, result[4]);
		assertEquals(6, result[5]);

		assertEquals(0, mergesort.inversionCount);
		
	}	
	
	@Test
	public void testMergeSortEvenSimple() {
		int[] array = {1,2};

		MergeSort mergesort = new MergeSort();
		
		int[] result = mergesort.mergeSort(array);
		
		assertEquals(1, result[0]);
		assertEquals(2, result[1]);
		
	}
	
	@Test
	public void testMergeSortEvenSimple2() {
		int[] array = {4,3,1,2};

		MergeSort mergesort = new MergeSort();
		
		int[] result = mergesort.mergeSort(array);
		
		assertEquals(1, result[0]);
		assertEquals(2, result[1]);
		assertEquals(3, result[2]);
		assertEquals(4, result[3]);
		
	}
		
	
	@Test
	public void testMergeSort2() {
		int[] array = {4,3,2,1};

		MergeSort mergesort = new MergeSort();
		
		int[] result = mergesort.mergeSort(array);
		
		assertEquals(1, result[0]);
		assertEquals(2, result[1]);
		assertEquals(3, result[2]);
		
		assertEquals(6, mergesort.inversionCount);

	}	
	
	@Test
	public void testMergeSort3() {
		int[] array = {10,9,8,7,6,5,4,3,1,2};

		MergeSort mergesort = new MergeSort();
		
		int[] result = mergesort.mergeSort(array);
		
		assertEquals(1, result[0]);
		assertEquals(2, result[1]);
		assertEquals(10, result[9]);
		
		assertEquals(44, mergesort.inversionCount);

	}	
	
	@Test
	public void testMergeSort4() {
		int[] array = {10,9,8,7,5,6,4,3,1,2};

		MergeSort mergesort = new MergeSort();
		
		int[] result = mergesort.mergeSort(array);
		
		assertEquals(1, result[0]);
		assertEquals(2, result[1]);
		assertEquals(10, result[9]);
		
		assertEquals(43, mergesort.inversionCount);

	}	

}

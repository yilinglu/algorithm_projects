package com.yiling.lu.algorithm.problem.sorting.comparasionbased;

import static org.junit.Assert.assertEquals;

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
		Integer[] array = {30,5,15};

		MergeSort mergesort = new MergeSort();
		
		Integer[] result = mergesort.mergeSort(array);
		
		assertEquals(5, result[0].intValue());
		assertEquals(15, result[1].intValue());
		assertEquals(30, result[2].intValue());
		
		assertEquals(2, mergesort.getInversionCount());

	}

	@Test
	public void testMergeSortAlreadySorted() {
		Integer[] array = {1,2,3,4,5};

		MergeSort mergesort = new MergeSort();
		
		Integer[] result = mergesort.mergeSort(array);
		
		assertEquals(1, result[0].intValue());
		assertEquals(2, result[1].intValue());
		assertEquals(3, result[2].intValue());
		assertEquals(4, result[3].intValue());
		assertEquals(5, result[4].intValue());
		assertEquals(0, mergesort.getInversionCount());
		
	}
	
	@Test
	public void testMergeSortAlreadySorted2() {
		Integer[] array = {1,2,3,4,5,6};

		MergeSort mergesort = new MergeSort();
		
		Integer[] result = mergesort.mergeSort(array);
		
		assertEquals(1, result[0].intValue());
		assertEquals(2, result[1].intValue());
		assertEquals(3, result[2].intValue());
		assertEquals(4, result[3].intValue());
		assertEquals(5, result[4].intValue());
		assertEquals(6, result[5].intValue());

		assertEquals(0, mergesort.getInversionCount());
		
	}	
	
	@Test
	public void testMergeSortEvenSimple() {
		Integer[] array = {1,2};

		MergeSort mergesort = new MergeSort();
		
		Integer[] result = mergesort.mergeSort(array);
		
		assertEquals(1, result[0].intValue());
		assertEquals(2, result[1].intValue());
		
	}
	
	@Test
	public void testMergeSortEvenSimple2() {
		Integer[] array = {4,3,1,2};

		MergeSort mergesort = new MergeSort();
		
		Integer[] result = mergesort.mergeSort(array);
		
		assertEquals(1, result[0].intValue());
		assertEquals(2, result[1].intValue());
		assertEquals(3, result[2].intValue());
		assertEquals(4, result[3].intValue());
		
	}
		
	
	@Test
	public void testMergeSort2() {
		Integer[] array = {4,3,2,1};

		MergeSort mergesort = new MergeSort();
		
		Integer[] result = mergesort.mergeSort(array);
		
		assertEquals(1, result[0].intValue());
		assertEquals(2, result[1].intValue());
		assertEquals(3, result[2].intValue());
		
		assertEquals(6, mergesort.getInversionCount());

	}	
	
	@Test
	public void testMergeSort3() {
		Integer[] array = {10,9,8,7,6,5,4,3,1,2};

		MergeSort mergesort = new MergeSort();
		
		Integer[] result = mergesort.mergeSort(array);
		
		assertEquals(1, result[0].intValue());
		assertEquals(2, result[1].intValue());
		assertEquals(10, result[9].intValue());
		
		assertEquals(44, mergesort.getInversionCount());

	}	
	
	@Test
	public void testMergeSort4() {
		Integer[] array = {10,9,8,7,5,6,4,3,1,2};

		MergeSort mergesort = new MergeSort();
		
		Integer[] result = mergesort.mergeSort(array);
		
		assertEquals(1, result[0].intValue());
		assertEquals(2, result[1].intValue());
		assertEquals(10, result[9].intValue());
		
		assertEquals(43, mergesort.getInversionCount());

	}	

}

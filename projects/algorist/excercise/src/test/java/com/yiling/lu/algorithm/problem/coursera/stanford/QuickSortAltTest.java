package com.yiling.lu.algorithm.problem.coursera.stanford;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuickSortAltTest {

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
	public void testPickMedian() {
		Integer[] array = {8, 2, 4, 5, 7, 1};
		QuickSortAlt<Integer> qsort = new QuickSortAlt<Integer>();
		int median = qsort.pickIndexOfMedian(array, 0, array.length-1);
		assertEquals(2, median);
		assertEquals(4, array[median].intValue());
	}
	
	@Test
	public void testPickMedian2() {
		Integer[] array = {8, 2, 2, 5, 7, 4};
		QuickSortAlt<Integer> qsort = new QuickSortAlt<Integer>();
		int median = qsort.pickIndexOfMedian(array, 0, array.length-1);
		assertEquals(5, median);
		assertEquals(4, array[median].intValue());
	}	

	
	@Test
	public void testPickMedian3() {
		Integer[] array = {8, 2, 9, 10, 5, 7, 4};
		QuickSortAlt<Integer> qsort = new QuickSortAlt<Integer>();
		int median = qsort.pickIndexOfMedian(array, 0, array.length-1);
		assertEquals(0, median);
		assertEquals(8, array[median].intValue());
	}	
	
	@Test
	public void testPickMedian4() {
		Integer[] array = {10, 2, 9, 4, 5, 7, 8};
		QuickSortAlt<Integer> qsort = new QuickSortAlt<Integer>();
		int median = qsort.pickIndexOfMedian(array, 0, array.length-1);
		assertEquals(6, median);
		assertEquals(8, array[median].intValue());
	}
	
	@Test
	public void testPickMedian5() {
		Integer[] array = {8, 2, 9, 4, 5, 7, 10};
		QuickSortAlt<Integer> qsort = new QuickSortAlt<Integer>();
		int median = qsort.pickIndexOfMedian(array, 0, array.length-1);
		assertEquals(0, median);
		assertEquals(8, array[median].intValue());
	}	
	
	@Test
	public void testPickMedian6() {
		Integer[] array = {8, 2};
		QuickSortAlt<Integer> qsort = new QuickSortAlt<Integer>();
		int median = qsort.pickIndexOfMedian(array, 0, array.length-1);
		assertEquals(0, median);
		assertEquals(8, array[median].intValue());
	}	
}

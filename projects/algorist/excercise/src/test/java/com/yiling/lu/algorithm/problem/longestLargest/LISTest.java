package com.yiling.lu.algorithm.problem.longestLargest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LISTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindLIS() {
		Integer[] array = new Integer[]{10,12,13};
		
		List<Comparable> list = LongestIncreasingSequence.findLIS(array);
		
		assertEquals(10, list.get(0));
	}
	
	@Test
	public void testFindLIS2() {
		Integer[] array = new Integer[]{10};
		
		List<Comparable> list = LongestIncreasingSequence.findLIS(array);
		
		assertEquals(10, list.get(0));
	}	
	
	@Test
	public void testFindLIS3() {
		Integer[] array = new Integer[]{};
		
		List<Comparable> list = LongestIncreasingSequence.findLIS(array);
		
		assertTrue(list.isEmpty());
	}	
	
	@Test
	public void testFindLIS4() {
		Integer[] array = new Integer[]{50,10,12,13};
		
		List<Comparable> list = LongestIncreasingSequence.findLIS(array);
		
		assertEquals(10, list.get(0));
	}	
	
	@Test
	public void testFindLIS5() {
		Integer[] array = new Integer[]{50, 10, 5, 6, 12,13};
		
		List<Comparable> list = LongestIncreasingSequence.findLIS(array);
		
		assertEquals(5, list.get(0));
	}	
	
	@Test
	public void testFindLIS6() {
		Integer[] array = new Integer[]{50, 60, 70, 80, 90, 5, 6, 7, 12,13};
		//0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15,
		List<Comparable> list = LongestIncreasingSequence.findLIS(array);
		
		assertEquals(5, list.get(0));
	}	
	
	@Test
	public void testFindLIS7() {
		Integer[] array = new Integer[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		//0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 1
		List<Comparable> list = LongestIncreasingSequence.findLIS(array);
		
		
		assertEquals(0, list.get(0));
		assertEquals(2, list.get(1));
		assertEquals(6, list.get(2));
		assertEquals(9, list.get(3));
		assertEquals(11, list.get(4));
		assertEquals(15, list.get(5));
	}	

}

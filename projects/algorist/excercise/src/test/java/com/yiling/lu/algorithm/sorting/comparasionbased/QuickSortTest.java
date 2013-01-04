package com.yiling.lu.algorithm.sorting.comparasionbased;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import CtCILibrary.AssortedMethods;

import com.yiling.lu.algorithm.sorting.lineartime.CountingSort;
import com.yiling.lu.algorithm.util.AssortedUtils;

public class QuickSortTest {

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
	public void test() {
		String[] array = {"6", "z", "b", "c", "a", "d", "f", "y", "x", "n", "m", "q", "p", "l"};
		
		QuickSort.qsort(array);
		
		System.out.println("sorting result " + 
		AssortedMethods.stringArrayToString(array));
		AssortedUtils.verifyOrder(array);		
	}
	
	@Test
	public void testDuplicates() {
		String[] array = {"6", "z", "b", "c", "6", "a", "f", "y", "z", "n", "m", "b", "p", "z"};
		
		QuickSort.qsort(array);
		
		System.out.println("sorting result " + 
		AssortedMethods.stringArrayToString(array));
		AssortedUtils.verifyOrder(array);		
	}	
	
	@Test
	public void testAllDuplicates() {
		String[] array = {"z", "z", "z", "z", "z"};
		
		QuickSort.qsort(array);
		
		System.out.println("sorting result " + 
		AssortedMethods.stringArrayToString(array));
		AssortedUtils.verifyOrder(array);		
	}	
	
	@Test
	public void testSimple() {
		String[] array = {"c", "a"};
		
		QuickSort.qsort(array);
		
		System.out.println("sorting result " + 
		AssortedMethods.stringArrayToString(array));
		AssortedUtils.verifyOrder(array);		
	}	
	
	@Test
	public void testSimple2() {
		String[] array = {"c", "a", "b"};
		
		QuickSort.qsort(array);
		
		System.out.println("sorting result " + 
		AssortedMethods.stringArrayToString(array));
		AssortedUtils.verifyOrder(array);		
	}	
	
	@Test
	public void testSimple3() {
		String[] array = {"c"};
		
		QuickSort.qsort(array);
		
		System.out.println("sorting result " + 
		AssortedMethods.stringArrayToString(array));
		AssortedUtils.verifyOrder(array);		
	}	

	@Test
	public void testSimple4() {
		String[] array = {};
		
		QuickSort.qsort(array);
		
		System.out.println("sorting result " + 
		AssortedMethods.stringArrayToString(array));
		AssortedUtils.verifyOrder(array);		
	}	
}

package com.yiling.lu.algorithm.problem.sorting.comparasionbased;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.yiling.lu.algorithm.util.AssortedUtils;

import CtCILibrary.AssortedMethods;

public class RedWhiteBlueSortTest {
	@Test
	public void testSort() {
		char[] array = {'w','r','b','w'};
		RedWhiteBlueSort.sort(array);
		
		AssortedUtils.printArray(array);
	}
	
	@Test
	public void testSort2() {
		char[] array = {'w','b','r'};
		RedWhiteBlueSort.sort(array);
		
		AssortedUtils.printArray(array);
	}	
	
	@Test
	public void testSort3() {
		char[] array = {'b','w','r'};
		RedWhiteBlueSort.sort(array);
		
		AssortedUtils.printArray(array);
	}	
	
	@Test
	public void testSort4() {
		char[] array = {'r','w','b'};
		RedWhiteBlueSort.sort(array);
		
		AssortedUtils.printArray(array);
	}	
	
	@Test
	public void testSort5() {
		char[] array = {'r','b','w'};
		RedWhiteBlueSort.sort(array);
		
		AssortedUtils.printArray(array);
	}	
	
	@Test
	public void testSort6() {
		char[] array = {'w','r','b'};
		RedWhiteBlueSort.sort(array);
		
		AssortedUtils.printArray(array);
	}	
	
	@Test
	public void testSort7() {
		char[] array = {'b','r','w'};
		RedWhiteBlueSort.sort(array);
		
		AssortedUtils.printArray(array);
	}	
	
	@Test
	public void testSort8() {
		char[] array = {'b','w','w'};
		RedWhiteBlueSort.sort(array);
		
		AssortedUtils.printArray(array);
	}	
	
	@Test
	public void testSort9() {
		char[] array = {'b','w','w', 'r','r','b','w','w', 'r','r','b','b','r','b','w'};
		RedWhiteBlueSort.sort(array);
		
		AssortedUtils.printArray(array);
	}		
	
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



}

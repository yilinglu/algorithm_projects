package com.yiling.lu.algorithm.problem.combinatorics;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CombinationTest {

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
	public void testDoComboSize() {
		char[] input = {'a'};
		char[] input2 = {'a', 'b'};
		char[] input3 = {'a', 'b', 'c'};
		char[] input4 = {'a', 'b', 'c', 'd', 'e'};
		
		char[] array = input4;
		int setSize = 2;
		List<String> list = Combination.doComboSize(array, setSize);
		int actual = list.size();
		
		int expected = Combination.calcCombo(array.length, setSize);
		
		assertEquals(expected, actual);
		
	}

	@Test
	public void testTotalCombo() {
	}

	@Test
	public void testCalcCombo(){
		int actual = Combination.calcCombo(10, 2);
		assertEquals(45, actual);
	}
	
}

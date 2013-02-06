package com.yiling.lu.algorithm.problem.combinatorics;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.yiling.lu.algorithm.util.AssortedUtils;

import CtCILibrary.AssortedMethods;

public class PermutationTest {

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
	public void testPermutate() {
		char[] input = {'a', 'b', 'c'};
		List<String> results = Permutation.permutate(input);
		
		assertNotNull(results);
		assertTrue(!results.isEmpty());
		
		AssortedUtils.printCollection(results);
		
	}

}

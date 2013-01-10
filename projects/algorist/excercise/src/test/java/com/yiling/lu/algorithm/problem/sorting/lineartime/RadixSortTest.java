package com.yiling.lu.algorithm.problem.sorting.lineartime;

import static org.junit.Assert.*;

import org.junit.Test;

import com.yiling.lu.algorithm.problem.sorting.lineartime.RadixSort;
import com.yiling.lu.algorithm.util.AssortedUtils;

public class RadixSortTest {
	@Test
	public void testSimpleVariableLength() {
		String[] array = {"x", "abc"};
		String[] result = RadixSort.sort(array);
		
		AssortedUtils.verifyOrder(result);
	}
	
	@Test
	public void testVariableLength() {
		String[] array = {"x", "abc", "ab", "cdf", "xyz", "mn", "amn"};
		String[] result = RadixSort.sort(array);
		
		AssortedUtils.verifyOrder(result);
	}

	@Test
	public void testEqualLength() {
		String[] array = {"xxx", "abc", "abd", "cdf", "xyz", "mxn", "amn"};
		String[] rlt = RadixSort.sort(array);
		
		AssortedUtils.verifyOrder(rlt);
	}	
	
	@Test
	public void testEqualLengthSimple() {
		String[] array = {"ac", "bb"};
		String[] rlt = RadixSort.sort(array);
		
		AssortedUtils.verifyOrder(rlt);
	}	
}

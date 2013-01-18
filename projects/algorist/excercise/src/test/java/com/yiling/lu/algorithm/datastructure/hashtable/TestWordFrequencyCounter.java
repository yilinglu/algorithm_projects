package com.yiling.lu.algorithm.datastructure.hashtable;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestWordFrequencyCounter {

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
	public void test() {
		System.out.println("current directory: " + System.getProperty("user.dir"));
		String filePath = System.getProperty("user.dir") + "/src/test/test-files/simple.txt";
		WordFrequencyCounter counter = new WordFrequencyCounter();
		counter.processFile(filePath);
		
		System.out.println("max count " + counter.getMaxCount());
		System.out.println("max word " + counter.getMaxword());
	}

}

package com.yiling.lu.algorithm.careercup;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringCompressionTest {
	@Test
	public void testBuildOutput() {
	}

	@Test
	public void testCompressString() {
		String actual = StringCompression.compressString("AAACCCBBD");
		String expected = "A3C3B2D";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCompressString2() {
		String actual = StringCompression.compressString("ACCCBBD");
		String expected = "AC3B2D";
		assertEquals(expected, actual);
	}	
	
	@Test
	public void testCompressString3() {
		String actual = StringCompression.compressString("B");
		String expected = "B";
		assertEquals(expected, actual);
	}	

	@Test
	public void testCompressString4() {
		String actual = StringCompression.compressString("AB");
		String expected = "AB";
		assertEquals(expected, actual);
	}	
	
	@Test
	public void testCompressString5() {
		String actual = StringCompression.compressString("ABC");
		String expected = "ABC";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCompressString6() {
		String actual = StringCompression.compressString("ABCC");
		String expected = "ABC2";
		assertEquals(expected, actual);
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

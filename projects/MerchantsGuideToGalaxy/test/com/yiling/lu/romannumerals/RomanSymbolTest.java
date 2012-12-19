package com.yiling.lu.romannumerals;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class RomanSymbolTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void simpleTest() {
		
		int actual = RomanNumeral.C.intValue;
		char actualChar = RomanNumeral.C.charValue();
		Assert.assertEquals(100, actual);
		Assert.assertEquals('C', actualChar);
	}

}

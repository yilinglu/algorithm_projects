package com.yiling.lu.romannumerals.utils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.yiling.lu.romannumerals.RomanNumeral;
import com.yiling.lu.romannumerals.utils.RomanNumeralConversionUtil;

public class RomanSymbolConversionUtilSimpleTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testEmpty() {
		RomanNumeral[] num = {};
		
		int actual = RomanNumeralConversionUtil.getIntValue(num);
		Assert.assertEquals(0, actual);
	}
	
	@Test
	public void testMMXII() {
		RomanNumeral[] num = {RomanNumeral.M,RomanNumeral.M,RomanNumeral.X,RomanNumeral.I,RomanNumeral.I};
		
		int actual = RomanNumeralConversionUtil.getIntValue(num);
		Assert.assertEquals(2012, actual);
	}	
	
	@Test
	public void simpleTestDigitI() {
		RomanNumeral[] num = {RomanNumeral.I};
		
		int actual = RomanNumeralConversionUtil.getIntValue(num);
		Assert.assertEquals(1, actual);
	}
	
	@Test
	public void simpleTestDigitV() {
		RomanNumeral[] num = {RomanNumeral.V};
		
		int actual = RomanNumeralConversionUtil.getIntValue(num);
		Assert.assertEquals(5, actual);
	}
	
	@Test
	public void simpleTestDigitX() {
		RomanNumeral[] num = {RomanNumeral.X};
		
		int actual = RomanNumeralConversionUtil.getIntValue(num);
		Assert.assertEquals(10, actual);
	}
	
	@Test
	public void simpleTestDigitL() {
		RomanNumeral[] num = {RomanNumeral.L};
		
		int actual = RomanNumeralConversionUtil.getIntValue(num);
		Assert.assertEquals(50, actual);
	}
	
	@Test
	public void simpleTestDigitC() {
		RomanNumeral[] num = {RomanNumeral.C};
		
		int actual = RomanNumeralConversionUtil.getIntValue(num);
		Assert.assertEquals(100, actual);
	}
	
	@Test
	public void simpleTestDigitD() {
		RomanNumeral[] num = {RomanNumeral.D};
		
		int actual = RomanNumeralConversionUtil.getIntValue(num);
		Assert.assertEquals(500, actual);
	}
	
	@Test
	public void simpleTestDigitM() {
		RomanNumeral[] num = {RomanNumeral.M};
		
		int actual = RomanNumeralConversionUtil.getIntValue(num);
		Assert.assertEquals(1000, actual);
	}	
	
	@Test
	public void simpleTestTwoDigitsII() {
		RomanNumeral[] num = {RomanNumeral.I, RomanNumeral.I};
		
		int actual = RomanNumeralConversionUtil.getIntValue(num);
		Assert.assertEquals(2, actual);
	}
	
	@Test
	public void simpleTestTwoDigitsVI() {
		RomanNumeral[] num = {RomanNumeral.V, RomanNumeral.I};
		
		int actual = RomanNumeralConversionUtil.getIntValue(num);
		Assert.assertEquals(6, actual);
	}	
	
	
	@Test
	public void simpleTestTwoDigitsVII() {
		RomanNumeral[] num = {RomanNumeral.V, RomanNumeral.I, RomanNumeral.I};
		
		int actual = RomanNumeralConversionUtil.getIntValue(num);
		Assert.assertEquals(7, actual);
	}	

	@Test
	public void simpleTestTwoDigitsSubtraction() {
		RomanNumeral[] num = {RomanNumeral.I, RomanNumeral.V};
		
		int actual = RomanNumeralConversionUtil.getIntValue(num);
		Assert.assertEquals(4, actual);
	}	
	
	@Test
	public void simpleTestTwoDigitsSubtractionXL() {
		RomanNumeral[] num = {RomanNumeral.X, RomanNumeral.L};
		
		int actual = RomanNumeralConversionUtil.getIntValue(num);
		Assert.assertEquals(40, actual);
	}	
	
	@Test
	public void simpleTestTwoDigitsSubtractionXC() {
		RomanNumeral[] num = {RomanNumeral.X, RomanNumeral.C};
		
		int actual = RomanNumeralConversionUtil.getIntValue(num);
		Assert.assertEquals(90, actual);
	}		
	@Test
	public void simpleTestTwoDigitsSubtractionIX() {
		RomanNumeral[] num = {RomanNumeral.I, RomanNumeral.X};
		
		int actual = RomanNumeralConversionUtil.getIntValue(num);
		Assert.assertEquals(9, actual);
	}		
	@Test
	public void simpleTestTwoDigitsSubtractionCD() {
		RomanNumeral[] num = {RomanNumeral.C, RomanNumeral.D};
		
		int actual = RomanNumeralConversionUtil.getIntValue(num);
		Assert.assertEquals(400, actual);
	}	
	
	@Test
	public void simpleTestTwoDigitsSubtractionCM() {
		RomanNumeral[] num = {RomanNumeral.C, RomanNumeral.M};
		
		int actual = RomanNumeralConversionUtil.getIntValue(num);
		Assert.assertEquals(900, actual);
	}
	
	@Test
	public void simpleTestOneSubtractionRule() {
		RomanNumeral[] num = {RomanNumeral.M, RomanNumeral.X, RomanNumeral.X, RomanNumeral.L};
		// 1000+10+(50-10) = 1050
		int actual = RomanNumeralConversionUtil.getIntValue(num);
		Assert.assertEquals(1050, actual);
	}	
}

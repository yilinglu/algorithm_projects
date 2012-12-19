package com.yiling.lu.romannumerals.utils;

import org.junit.Before;
import org.junit.Test;

import com.yiling.lu.romannumerals.exception.InvalidNumeralException;

public class ValidationUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		ValidationUtil vUtil = new ValidationUtil();
		vUtil.validate("MMVI");
	}
	
	@Test(expected=InvalidNumeralException.class)
	public void testInvalid() {
		ValidationUtil vUtil = new ValidationUtil();
		vUtil.validate("MMDDDDVI");
	}	

	@Test(expected=InvalidNumeralException.class)
	public void testInvalidChar() {
		ValidationUtil vUtil = new ValidationUtil();
		vUtil.validate("MMDBDDTDVI");
	}
	
	@Test(expected=InvalidNumeralException.class)
	public void testRepetition() {
		ValidationUtil vUtil = new ValidationUtil();
		vUtil.validate("XXXIXXX");
	}	
}

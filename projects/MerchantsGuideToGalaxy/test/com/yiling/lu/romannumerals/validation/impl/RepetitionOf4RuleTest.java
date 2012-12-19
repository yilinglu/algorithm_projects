package com.yiling.lu.romannumerals.validation.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.yiling.lu.romannumerals.exception.InvalidNumeralException;
import com.yiling.lu.romannumerals.validation.rules.impl.RepetitionOf4Rule;

public class RepetitionOf4RuleTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testValid() {
		RepetitionOf4Rule rule = new RepetitionOf4Rule();
		rule.validate("MMMDM");
	}
	
	@Test(expected=InvalidNumeralException.class)
	public void testInValid() {
		RepetitionOf4Rule rule = new RepetitionOf4Rule();
		rule.validate("CCCMC");
	}	

	@Test(expected=InvalidNumeralException.class)
	public void testInValid2() {
		RepetitionOf4Rule rule = new RepetitionOf4Rule();
		rule.validate("MCCCMCI");
	}	
	
	
	@Test(expected=InvalidNumeralException.class)
	public void testInValid3() {
		RepetitionOf4Rule rule = new RepetitionOf4Rule();
		rule.validate("MCCCDCI");
	}	
	
	@Test(expected=InvalidNumeralException.class)
	public void testInValid4() {
		RepetitionOf4Rule rule = new RepetitionOf4Rule();
		rule.validate("DXXXDMXD");
	}	
}

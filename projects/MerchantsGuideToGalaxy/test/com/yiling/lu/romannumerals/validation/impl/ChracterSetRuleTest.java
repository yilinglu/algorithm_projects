package com.yiling.lu.romannumerals.validation.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.yiling.lu.romannumerals.exception.InvalidNumeralException;
import com.yiling.lu.romannumerals.validation.rules.impl.CharacterSetRule;

public class ChracterSetRuleTest {

	@Before
	public void setUp() throws Exception {
	}

	
	@Test(expected=InvalidNumeralException.class)
	public void testInvalid() {
		CharacterSetRule rule = new CharacterSetRule();
		rule.validate("mht");
	}	
	
	@Test(expected=InvalidNumeralException.class)
	public void testInvalid2() {
		CharacterSetRule rule = new CharacterSetRule();
		rule.validate("Wmht");
	}	
	
	@Test(expected=InvalidNumeralException.class)
	public void testInvalid3() {
		CharacterSetRule rule = new CharacterSetRule();
		rule.validate("h");
	}	
	
	@Test(expected=InvalidNumeralException.class)
	public void testInvalid4() {
		CharacterSetRule rule = new CharacterSetRule();
		rule.validate("mmvii5");
	}		
	
	@Test
	public void testValid() {
		CharacterSetRule rule = new CharacterSetRule();
		rule.validate("m");
	}	
	
	@Test
	public void testValid2() {
		CharacterSetRule rule = new CharacterSetRule();
		rule.validate("mmvii");
	}		

}

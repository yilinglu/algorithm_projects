package com.yiling.lu.romannumerals;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.yiling.lu.guidetogalaxy.NumeralTranslationTable;
import com.yiling.lu.romannumerals.exception.UndefinedExternalSymbolException;
import com.yiling.lu.romannumerals.utils.ExternalToRomanConversionUtil;
import com.yiling.lu.romannumerals.utils.RomanNumeralUtil;

public class NumeralTranslationTableTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testValidCase() throws UndefinedExternalSymbolException {
		NumeralTranslationTable transTable = NumeralTranslationTable.getInstance();
		transTable.addSymbol("A", RomanNumeral.I);
		transTable.addSymbol("B", RomanNumeral.V);
		
		String romanNumeral = ExternalToRomanConversionUtil.convertToRoman(new String[]{"B","A"});
		
		Assert.assertEquals("VI", romanNumeral);
		
		int intValue = RomanNumeralUtil.convertRomanToInt(romanNumeral);
		Assert.assertEquals(6, intValue);
	}

	/**
	 * MCMLIV
	 * @throws UndefinedExternalSymbolException
	 */
	@Test
	public void testValidCase2() throws UndefinedExternalSymbolException {
		NumeralTranslationTable transTable = NumeralTranslationTable.getInstance();
		transTable.addSymbol("A", RomanNumeral.V);
		transTable.addSymbol("B", RomanNumeral.M);
		transTable.addSymbol("STORM", RomanNumeral.C);
		transTable.addSymbol("BETA", RomanNumeral.I);
		transTable.addSymbol("alpha", RomanNumeral.L);
		
		String romanNumeral = ExternalToRomanConversionUtil.convertToRoman(
				new String[]{"B","STORM", "B", "alpha", "BETA", "A"});
			
		Assert.assertEquals("MCMLIV", romanNumeral);
		
		int intValue = RomanNumeralUtil.convertRomanToInt(romanNumeral);
		Assert.assertEquals(1954, intValue);
	}	
	
	@Test(expected=UndefinedExternalSymbolException.class)
	public void testUndefinedSymbol() throws UndefinedExternalSymbolException {
		NumeralTranslationTable transTable = NumeralTranslationTable.getInstance();
		transTable.addSymbol("A", RomanNumeral.V);
		transTable.addSymbol("B", RomanNumeral.M);
		transTable.addSymbol("STORM", RomanNumeral.C);
		transTable.addSymbol("BETA", RomanNumeral.I);
		transTable.addSymbol("alpha", RomanNumeral.L);
		
		String romanNumeral = ExternalToRomanConversionUtil.convertToRoman(
				new String[]{"B","STORM", "B", "Alpha", "BETA", "A"});
			
		Assert.assertEquals("MCMLIV", romanNumeral);
		
		int intValue = RomanNumeralUtil.convertRomanToInt(romanNumeral);
		Assert.assertEquals(1954, intValue);
	}	
}

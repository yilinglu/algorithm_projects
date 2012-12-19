package com.yiling.lu.romannumerals.utils;

import java.util.HashMap;

import com.yiling.lu.romannumerals.RomanNumeral;
import com.yiling.lu.romannumerals.exception.InvalidNumeralException;

public class RomanNumeralUtil {
	// allow look up RomanNumeral by character
	private static HashMap<Character,RomanNumeral> lookupMap = new HashMap<Character,RomanNumeral>();
	
	static {
		lookupMap.put('I', RomanNumeral.I);
		lookupMap.put('V', RomanNumeral.V);
		lookupMap.put('X', RomanNumeral.X);
		lookupMap.put('L', RomanNumeral.L);
		lookupMap.put('C', RomanNumeral.C);
		lookupMap.put('D', RomanNumeral.D);
		lookupMap.put('M', RomanNumeral.M);	
	}
	/**
	 * Validate and convert a Roman numeral string to base 10 integer representation.
	 * 
	 * @param romanNumeral expect Roman numeral string
	 * @return Base 10 integer representation of the input Roman numeral.
	 * @exception InvalidNumeralException if the input string fails the validation
	 */
	public static int convertRomanToInt(String romanNumeral){
		
		ValidationUtil validationUtil = new ValidationUtil();
		validationUtil.validate(romanNumeral);
		
		RomanNumeral[] array = RomanNumeralConversionUtil.convertToRomanNumerals(romanNumeral);
		int v = RomanNumeralConversionUtil.getIntValue(array);
		return v;
	}
	
	public static RomanNumeral lookUpRomanNumeral(char c){
		return lookupMap.get(c);
	}	
}

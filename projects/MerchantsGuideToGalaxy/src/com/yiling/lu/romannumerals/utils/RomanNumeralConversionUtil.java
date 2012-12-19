package com.yiling.lu.romannumerals.utils;

import com.yiling.lu.romannumerals.RomanNumeral;

/**
 * Converting Roman numeral string to integer.
 * <p>
 * 
 * This class considers the following rule in the Roman numeral to integer conversion process:
 * </p>
 * <ul>
 * <li>
 * Only one small-value symbol may be subtracted from any large-value symbol
 * </li>
 * </ul>
 * 
 * Though "Generally, symbols are placed in order of value, starting with the largest values",
 * "MXXL" does not violates any other rules we have seen so far in this assignments. It is
 * reasonable to conceive that someone might write a Roman numeral number this way, in which case we will 
 * use the rule <b>"Only one small-value symbol may be subtracted from any large-value symbol"</b>
 * to only subtract one X from L, and use addition when it comes to the second X.
 * <p/>
 * 
 * @author yiling.lu@outlook.com
 *
 */
public class RomanNumeralConversionUtil {
	
	protected static int convertToInt(String str){
		RomanNumeral[] array = convertToRomanNumerals(str);
		int v = getIntValue(array);
		return v;
	}
	
	protected static void validate(String str){
		
	}

	protected static int getIntValue(RomanNumeral[] symbols) {
		int total = 0;
		
		// keep track of symbols already used in subtraction operation in order to
		// conform to the rule "Only one small-value symbol may be subtracted from any large-value symbol"
		boolean[] usedInSubtraction = new boolean[symbols.length];
		
		for (int i = symbols.length - 1; i >= 0; i--) {
			int sign = 1;

			if (i < symbols.length - 1) {
				
				int v = symbols[i].order - symbols[i + 1].order;
				
				if(usedInSubtraction[i] || usedInSubtraction[i+1]){
					//keep going with addition
				}else{
					sign = v == 0 ? 1 : v / Math.abs(v);
					
					if(sign<0){
						usedInSubtraction[i]=true;
						usedInSubtraction[i+1]=true;
					}
				}

			}
			total = total + sign * symbols[i].intValue;
		}
		return total;
	}

	protected static RomanNumeral[] convertToRomanNumerals(String str) {
		String symbolStr = str.toUpperCase();
		RomanNumeral[] a = new RomanNumeral[str.length()];

		for (int i = 0; i < symbolStr.length(); i++) {
			a[i] = charToSymbol(symbolStr.charAt(i));

		}
		return a;
	}

	protected static RomanNumeral charToSymbol(char c) {
		RomanNumeral result = null;
		
		switch (c) {
			case 'I':
				result = RomanNumeral.I;
				break;
			case 'V':
				result = RomanNumeral.V;
				break;
			case 'X':
				result = RomanNumeral.X;
				break;
			case 'L':
				result = RomanNumeral.L;
				break;
			case 'C':
				result = RomanNumeral.C;
				break;
			case 'D':
				result = RomanNumeral.D;
				break;
			case 'M':
				result = RomanNumeral.M;
				break;
		}
		return result;

	}

	protected static String convertToString(RomanNumeral[] symbols) {
		StringBuilder sym = new StringBuilder();
		
		for (int i = 0; i < symbols.length; i++) {
			sym.append(symbols[i].charValue());
		}
		return sym.toString();
	}
}

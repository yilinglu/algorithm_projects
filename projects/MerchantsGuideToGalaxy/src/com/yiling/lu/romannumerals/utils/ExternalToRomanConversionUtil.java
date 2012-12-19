package com.yiling.lu.romannumerals.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import com.yiling.lu.guidetogalaxy.NumeralTranslationTable;
import com.yiling.lu.romannumerals.RomanNumeral;
import com.yiling.lu.romannumerals.exception.UndefinedExternalSymbolException;

/**
 * @author yiling.lu@outlook.com
 *
 */
public class ExternalToRomanConversionUtil {
	
	/**
	 * @param externalSymbols Collection of symbols. Caller of this function
	 * should ensure each symbol has a predefined mapping to a Roman numeral, 
	 *  
	 * 
	 * @return Roman numeral string, such as XXII
	 * @throws UndefinedExternalSymbolException 
	 */
	public static String convertToRoman(Collection<String> externalSymbols) 
			throws UndefinedExternalSymbolException{
		StringBuilder br = new StringBuilder();
		
		Iterator<String> it = externalSymbols.iterator();
		
		while(it.hasNext()){
			String next = it.next();
			RomanNumeral romanNumeral = NumeralTranslationTable.getInstance().getRomanNumeral(next);
			
			if(romanNumeral != null){
				Character ch = romanNumeral.charValue();
				br.append(ch);
			}else{
				throw new UndefinedExternalSymbolException(errorMessge(next));
			}
		}
		return br.toString();
	}
	
	/**
	 * @param externalSymbols
	 * @return Roman numeral string, such as XXII
	 * @throws UndefinedExternalSymbolException 
	 * @see 
	 */
	public static String convertToRoman(String[] externalSymbols) 
			throws UndefinedExternalSymbolException{
		return convertToRoman(Arrays.asList(externalSymbols));
	}
	
	private static String errorMessge(String undefinedSymbol){
		StringBuilder br = new StringBuilder();
		br.append(StringEncodingUtil.quotes(undefinedSymbol));
		br.append(" is not mapped to a Roman numeral.");
		
		return br.toString();
	}
	
}

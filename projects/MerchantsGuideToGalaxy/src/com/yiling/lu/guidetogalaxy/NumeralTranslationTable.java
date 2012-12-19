package com.yiling.lu.guidetogalaxy;

import java.util.HashMap;
import java.util.Iterator;

import com.yiling.lu.romannumerals.RomanNumeral;
import com.yiling.lu.romannumerals.utils.StringEncodingUtil;

/**
 * <p>
 * Singleton class to maintain a bi-directional mapping between intergalaxtical 
 * symbols to Roman numeral.
 * </p>
 * 
 * 
 * @author yiling.lu@outlook.com
 *
 */
public class NumeralTranslationTable {
	
	/**
	 * User "glob is V" for example:<br/>
	 * key in the map is the external symbol, i.e. glob
	 * value is the corresponding Roman numeral V
	 */
	private static HashMap<String,RomanNumeral> externalToRoman = new HashMap<String,RomanNumeral>();
	
	/**
	 * 
	 */
	private static HashMap<Character,String> romanToExternal = new HashMap<Character,String>();
	
	/**
	 * Map between encoded Roman numeral and user defined
	 * variable name (symbol). This map can be used for variable name
	 * substitution to enhance user messages.
	 * <p>
	 * key: encoded Roman numeral, e.g. {I}, value: user defined
	 * variable name, e.g. glob.
	 * </p>
	 */
	private static HashMap<String,String> encodedRomanToExternal = new HashMap<String,String>();
	
	/**
	 *  All numerals appear in the same order as the order value for each Roman Numeral enum type
	 */
	private static RomanNumeral[] allRomanNumerals = {RomanNumeral.I, RomanNumeral.V,
		RomanNumeral.X, RomanNumeral.L, RomanNumeral.C, 
		RomanNumeral.D, RomanNumeral.M};
		
	private static NumeralTranslationTable instance;
	
	private NumeralTranslationTable(){

	}
	
	public static NumeralTranslationTable getInstance(){
		if(instance==null){
			instance = new NumeralTranslationTable();
		}
		return instance;
	}
	
	/**
	 * @param userSymbol
	 * @param romanNumeral
	 */
	public void addSymbol(String userSymbol, RomanNumeral romanNumeral){
		romanToExternal.put(new Character(romanNumeral.charValue()), userSymbol);
		externalToRoman.put(userSymbol, romanNumeral);
		
		String str = new Character(romanNumeral.charValue()).toString();
		encodedRomanToExternal.put(StringEncodingUtil.encode(str).trim(),userSymbol);
	}
	
	public RomanNumeral getRomanNumeral(String userSymbol){
		return externalToRoman.get(userSymbol);
	}
	
	/**
	 * 
	 * @param ch Roman numeral character
	 * @return External symbol for given Roman numeral character
	 */
	public String getSymbol(Character ch){
		return romanToExternal.get(ch);
	}
	
	/**
	 * Test if argument string is already mapped to a Roman Numeral
	 * 
	 * @param str String 
	 * 
	 * @return True if argument string has been mapped to a Roman numeral, 
	 * return False otherwise.
	 */
	public boolean isDefined(String str){
		return externalToRoman.containsKey(str);
	}
	
	/**
	 * @param args
	 * @return Map with encoded Roman numeral string mapped to user symbol.
	 */
	public HashMap<String,String> getEncodedMap(){
		return encodedRomanToExternal;
	}
	
	public RomanNumeral[] getAllRomanNumerals() {
		return allRomanNumerals;
	}

	public void dumpExternalSymbols(){
		System.out.println("");
		System.out.println("== Begin symbol table dump ==");
		Iterator<String> it = externalToRoman.keySet().iterator();
		while(it.hasNext()){
			String key = it.next();
			System.out.println(key + "->" +externalToRoman.get(key));
		}
		System.out.println("== End symbol table dump ==");
		System.out.println("");
	}
}

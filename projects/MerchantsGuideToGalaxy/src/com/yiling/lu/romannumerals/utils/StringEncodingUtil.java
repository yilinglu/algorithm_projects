package com.yiling.lu.romannumerals.utils;

import java.util.Collection;

/**
 * <p>
 * A set of utility functions to enclose single string, character, or collection
 * of strings 
 * </p>
 * @author yiling.lu@outlook.com
 *
 */
public class StringEncodingUtil {
	
	private static String[] curlyBraces = {"{", "}"};
	private static String[] quotes = {"\"", "\""};
	
	/**
	 * <p>
	 * Surround input string with curly braces.
	 * </p>
	 * For instance, abc encoded to {abc}
	 * <p/>
	 * @param s input string 
	 * @return curly braces enclosed string
	 */
	public static String encode(String s){
		return encode(s, StringEncodingUtil.curlyBraces);
	}
	
	/**
	 * <p>
	 * Surround input string with quotes
	 * </p>
	 * e.g. input is abc, output will be "abc"
	 * <p/>
	 * @param s
	 * @return Quoted input string
	 */
	public static String quotes(String s){
		return encode(s, StringEncodingUtil.quotes);
	}	
	
	/**
	 * Encode input string with user provided brace set
	 * 
	 * @param s input string
	 * @param braceSet should have two elements, with first
	 * used on the left and second used on the right to enclose
	 * the input string to product the output string
	 * 
	 * @return string enclosed using symbol from the provided brace set array.
	 */
	private static String encode(String s, String[] braceSet){
		StringBuilder br = new StringBuilder();
		br.append(" ");
		br.append(braceSet[0]);
		br.append(s);
		br.append(braceSet[1]);
		br.append(" ");
		
		return br.toString();
	}
	
	/**
	 * e.g. Input character J, return value will be {J}
	 * @param c input character value
	 * @return string enclosed with curly braces. 
	 */
	public static String encode(char c){
		return StringEncodingUtil.encode(new Character(c));
	}
	
	public static String encode(Character ch){
		return StringEncodingUtil.encode(ch);
	}	

	/**
	 * <p>
	 * Enclose each element in the collection with curly braces, and
	 * separate each curly braces enclosed string with separator character
	 * provided.
	 * <br/>
	 * e.g. input collection: [abc, BBC, D, debug], separator "," the return string will be
	 * {abc},{BBC},{D},{debug}
	 * <br/>
	 *
	 * </p>
	 * 
	 * 
	 * @param separator used for separate each element in the output string.
	 * @param col Collection of strings
	 * @return Collection of strings with each string enclosed by curly braces
	 * and separated by separator provided
	 */
	public static String encode(char separator, Collection<String> col){
		String[] array = col.toArray(new String[0]);
		
		return encode(separator, array);
	}
	
	/**
	 * 
	 * 
	 * @param separator
	 * @param a
	 * @return
	 */
	public static String encode(char separator, String[] a){
		StringBuilder br = new StringBuilder();
		
		for(int i=0; i<a.length; i++){
			br.append(" ");
			br.append(curlyBraces[0]);
			br.append(a[i]);
			br.append(curlyBraces[1]);
			br.append(new Character(separator));
		}
		br.setLength(br.length()-1);
		br.append(" ");
		
		return br.toString();
	}	
}

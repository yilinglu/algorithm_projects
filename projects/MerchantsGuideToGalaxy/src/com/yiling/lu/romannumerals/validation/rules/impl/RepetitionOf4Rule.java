/**
 * 
 */
package com.yiling.lu.romannumerals.validation.rules.impl;

import java.util.ArrayList;
import java.util.HashMap;

import com.yiling.lu.romannumerals.exception.InvalidNumeralException;
import com.yiling.lu.romannumerals.validation.rules.AbstractRomanNumeralValidationRule;

/**
 * <p>
 * We already implemented rule:<br/>
 * The symbols "I", "X", "C", and "M" can be repeated three times in succession, 
 * but no more. "D", "L", and "V" can never be repeated.<br/>
 * (See {@link com.yiling.lu.romannumerals.validation.rules.impl.RepetitionRule})
 * </p>
 * 
 * This class implement the following logic: (deal with exactly 4 occurrences of ("I", "X", "C", and "M"))
 * <br/>
 * They ("I", "X", "C", and "M") may appear four times if the third and fourth are separated by a 
 * smaller value, such as XXXIX. (Please note, because I is the smallest value, we already have
 * checked 4 consecutive I's as invalid in a the other repetition rule, we can therefore ignore I in this rule.)
 * 
 * <p>
 * In other words, if one of "X", "C", and "M" appear exactly 4 times, they have to appear
 * in pattern like MMMDM or CCCLC, as defined above.
 * </p>
 * 
 * @author yiling.lu@outlook.com
 *
 */
public class RepetitionOf4Rule extends AbstractRomanNumeralValidationRule {
	private int[] charset = new int[256];
	/**
	 * key: Character
	 * value: list if index in ascending order of the occurrance of the key character
	 */
	private HashMap<Character, ArrayList<Integer>> map = new HashMap<Character, ArrayList<Integer>>();
	
	public RepetitionOf4Rule(){
	}
	
	@Override
	public void validate(String symbolStr) throws InvalidNumeralException {
		String upperCaseSymbol = symbolStr.toUpperCase();

		for(int i=0; i<upperCaseSymbol.length(); i++){
			char c = upperCaseSymbol.charAt(i);
			charset[c-'0']++;
			addToMap(c, i);
		}		
		checkRepetitionPattern(upperCaseSymbol, new String[]{"X", "C", "M"});
	}
	
	private void addToMap(char c, int index){
		
		Character ch = new Character(c);
		
		if(map.get(ch)==null){
			map.put(ch, new ArrayList<Integer>());
		}
		map.get(ch).add(index);
	}
	
	/**
	 * When one of "X", "C", "M" has been repeated 4 times, 
	 * <ol>
	 * <li>
	 * We check that it appears in patter of 3 consecutive occurrence, followed by a single letter,
	 * then another occurrence (by checking the indices). Throws InvalidNumeralException
	 * if this pattern not found.
	 * </li>
	 * <li>
	 * When the above patter is confirmed, we will check that the
	 * third and fourth are separated by a smaller value. 
	 * <br/>
	 * e.g. For letter X, XXX[IV]X is expected. for letter C CCC[IVXL]C is expected,
	 * for letter M, MMM[IVXLCD]M is excepted.
	 * </li>
	 * </ol>
	 * @param args expecting "X", "C", "M"
	 * @param orgStr The entire Roman numeral we are inspecting.
	 * @exception InvalidNumeralException when the rule related to 4 occurrences is violated.
	 */
	private void checkRepetitionPattern(String orgStr, String[] args){
		for(int i=0; i<args.length; i++){
			if(charset[args[i].charAt(0)-'0']==4){
				
				ArrayList<Integer> indexList = map.get(args[i].charAt(0));
				
				if(indexList.get(0).equals(indexList.get(1).intValue()-1)
						&& indexList.get(1).equals(indexList.get(2).intValue()-1)
						&& indexList.get(2).equals(indexList.get(3).intValue()-2)){
					
					// this is the valid pattern we are expecting
					// now check for if the third and fourth are separated by a 
					// smaller value, such as XXXIX.
					char separator = orgStr.charAt(indexList.get(3).intValue()-1);
					
					int begin = indexList.get(0);
					int end = indexList.get(3).intValue()+1;
					
					String subStr = orgStr.substring(begin, end);				
					
					if(args[i]=="X"){
						// V and I are valid separators for third and fourth occurrence.
						String options = "IV";
						
						if(options.indexOf(separator) == -1){
							throw new InvalidNumeralException(buildErrorMessage(separator, subStr, options));
						}
					}else if(args[i] == "C"){
						String options = "IVXL";
						
						if(options.indexOf(separator) == -1){
							throw new InvalidNumeralException(buildErrorMessage(separator, subStr, options));
						}						
					}else if(args[i] == "M"){
						String options = "IVXLCD";
						
						if(options.indexOf(separator) == -1){
							throw new InvalidNumeralException(buildErrorMessage(separator, subStr, options));
						}						
					}
					
				}else{
					throw new InvalidNumeralException(buildErrorMessage2(args[i]));
				}
			}
		}
	}
	
	private String buildErrorMessage(char sep, String str, String options){
		StringBuilder br = new StringBuilder();
		
		br.append("{");
		br.append(sep);
		br.append("}");

		br.append(" in ");
		
		for(int i=0; i<str.length(); i++){
			br.append("{");
			br.append(str.charAt(i));
			br.append("}");
			br.append(" ");
		}
		br.append("should be replaced by a smaller value, such as one of ");
		
		for(int i=0; i<options.length(); i++){
			br.append("{");
			br.append(options.charAt(i));
			br.append("}");
			br.append(",");
		}
		
		br.setLength(br.length()-1);
		
		return br.toString();
	}
	
	private String buildErrorMessage2(String str){
		StringBuilder br = new StringBuilder("The occurrence pattern of {");
		br.append(str);
		br.append("} is invalid.");
		
		return br.toString();
	}

}

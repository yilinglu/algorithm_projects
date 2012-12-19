package com.yiling.lu.romannumerals.validation.rules.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.yiling.lu.romannumerals.exception.InvalidNumeralException;
import com.yiling.lu.romannumerals.exception.RepetitionException;
import com.yiling.lu.romannumerals.validation.rules.AbstractRomanNumeralValidationRule;

/**
 * The symbols "I", "X", "C", and "M" can be repeated three times in succession,
 * but no more. * 
 * <br/>
 * "D", "L", and "V" can never be repeated.
 *  
 * @author yiling.lu@outlook.com
 *
 */
public class RepetitionRule extends AbstractRomanNumeralValidationRule {
	// catch 4 or more times consecutive letters
	private static String regex = ".*I{4,}?.*|.*X{4,}?.*|.*C{4,}?.*|.*M{4,}?.*";
	
	private int[] charset = new int[256];
	
	private Pattern pattern;
	
	public RepetitionRule(){
		pattern = Pattern.compile(regex);
	}
	
	@Override
	public void validate(String symbolStr) throws RepetitionException {
		String upperCaseSymbol = symbolStr.toUpperCase();
		Matcher m = pattern.matcher(upperCaseSymbol);
		
		if(m.matches()){
			throw new RepetitionException("no more than 3 consecutive repetitions for {I}, {X}, {C}, or {M}");
		}
		
		for(int i=0; i<upperCaseSymbol.length(); i++){
			char c = upperCaseSymbol.charAt(i);
			charset[c-'0']++;
		}
		checkRepetition("I","X", "C", "M");
		checkNoRepetition("D", "L", "V");
		
	}
	
	/**
	 * Check anywhere in the string 5 or more times occurrence of certain symbols. 
	 * There is an overlap between this check and the regex check in this class, 
	 * the reason not to include this case in the regex is to exclude 
	 * the case such as "XXXIX" (implemented in another class).
	 * Because of it, we cannot catch 4 or more overall occurrences, because 4 is 
	 * allowed in cases like XXXIX.	 
	 * 
	 * @param args, expecting "I","X", "C", "M"
	 */
	private void checkRepetition(String... args){
		for(int i=0; i<args.length; i++){
			if(charset[args[i].charAt(0)-'0']>=5){
				throw new InvalidNumeralException("5 or more occurrences of {" + args[i] + "} not allowed.");
			}
		}
	}
	
	/**
	 * @param args expecting "D", "L", "V"
	 */
	private void checkNoRepetition(String... args){
		for(int i=0; i<args.length; i++){
			if(charset[args[i].charAt(0)-'0']>1){
				throw new InvalidNumeralException("{" + args[i] + "} not allowed to repeat.");
			}
		}
	}	

}

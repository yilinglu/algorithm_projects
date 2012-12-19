package com.yiling.lu.romannumerals.validation.rules.impl;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.yiling.lu.romannumerals.exception.InvalidNumeralException;
import com.yiling.lu.romannumerals.utils.StringEncodingUtil;
import com.yiling.lu.romannumerals.validation.rules.AbstractRomanNumeralValidationRule;

/**
 * Check symbol set only contains valid symbols.
 * 
 * @author yiling.lu@outlook.com
 *
 */
public class CharacterSetRule extends AbstractRomanNumeralValidationRule {
	private static String regex = "[^IVXLCDMivxlcdm]+?";
	private Pattern pattern;
	
	public CharacterSetRule(){
		pattern = Pattern.compile(regex);
	}
	
	@Override
	public void validate(String symbolStr) throws InvalidNumeralException {
		Matcher matcher = pattern.matcher(symbolStr);
		ArrayList<String> invalidChars = new ArrayList<String>();
		
		while(matcher.find()){
			invalidChars.add(matcher.group());
		}		
		
		if(!invalidChars.isEmpty()){
			throw new InvalidNumeralException(errorMessage(invalidChars));
		}
	}
	
	private String errorMessage(ArrayList<String> args){
		StringBuilder br = new StringBuilder("These symbol(s) are invalid: ");
		br.append(StringEncodingUtil.encode(',', args));
		br.append(".");
		
		return br.toString();
	}

}

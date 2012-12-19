package com.yiling.lu.romannumerals.validation.rules.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.yiling.lu.romannumerals.exception.InvalidNumeralException;
import com.yiling.lu.romannumerals.utils.StringEncodingUtil;
import com.yiling.lu.romannumerals.validation.rules.AbstractRomanNumeralValidationRule;

/**
 * <p>
 * This class implements the following rules regarding subtraction.
 * <br/>
 * <ol>
 * <li>
 * "I" can be subtracted from "V" and "X" only. 
 * </li>
 * <li>
 * "X" can be subtracted from "L" and "C" only. 
 * </li>
 * <li>
 * "C" can be subtracted from "D" and "M" only. (don't need to check as this indicates
 * C can be followed by any other Roman numeral. Except it cannot be subtracted more than once, 
 * but that is checked by another rule)
 * </li>
 * <li>
 * "V", "L", and "D" can never be subtracted.
 * </li>
 * </ol>
 *  </p>
 *  
 * @author yiling.lu@outlook.com
 *
 */
public class SubtractionRule extends AbstractRomanNumeralValidationRule {
	// invalid combinations with I
	private static String regexInvalidI = ".*(IL).*|.*IC.*|.*ID.*|.*IM.*";
	private static String regexInvalidX = ".*XD.*|.*XM.*";
	private static String regexInvalidV = ".*VX.*|.*VL.*|.*VC.*|.*VD.*|.*VM.*";
	private static String regexInvalidL = ".*LC.*|.*LD.*|.*LM.*";
	private static String regexInvalidD = ".*DM.*";
	
	private Pattern pattern;
	
	public SubtractionRule(){
		pattern = Pattern.compile(regexInvalidI);
	}
	
	@Override
	public void validate(String symbolStr) throws InvalidNumeralException {
		String upper = symbolStr.toUpperCase();
		
		if(upper.matches(regexInvalidI)){
			
			throw new InvalidNumeralException(buildErrorMessage("I", "V", "X"));
			
		}else if(upper.matches(regexInvalidX)){
			
			throw new InvalidNumeralException(buildErrorMessage("X", "L", "C"));
			
		}else if(upper.matches(regexInvalidV)){
			
			throw new InvalidNumeralException(buildErrorMessage2("V"));
			
		}else if(upper.matches(regexInvalidL)){
			
			throw new InvalidNumeralException(buildErrorMessage2("L"));
			
		}else if(upper.matches(regexInvalidD)){
			
			throw new InvalidNumeralException(buildErrorMessage2("D"));
		}
	}

	private String buildErrorMessage(String minuend, String... subtrahend1){
		StringBuilder br = new StringBuilder();
		br.append(StringEncodingUtil.encode(minuend));
		br.append(" can be subtracted from");
		br.append(StringEncodingUtil.encode(',', subtrahend1));
		br.append("only");
		
		return br.toString();
		
	}
	
	private String buildErrorMessage2(String minuend){
		StringBuilder br = new StringBuilder();
		br.append(StringEncodingUtil.encode(minuend));
		br.append(" can never be subtracted.");
		
		return br.toString();
		
	}	
}

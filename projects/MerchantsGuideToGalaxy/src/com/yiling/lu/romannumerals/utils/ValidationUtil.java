package com.yiling.lu.romannumerals.utils;

import java.util.ArrayList;
import java.util.Iterator;

import com.yiling.lu.romannumerals.validation.rules.RomanNumeralValidationRule;
import com.yiling.lu.romannumerals.validation.rules.impl.CharacterSetRule;
import com.yiling.lu.romannumerals.validation.rules.impl.RepetitionOf4Rule;
import com.yiling.lu.romannumerals.validation.rules.impl.RepetitionRule;
import com.yiling.lu.romannumerals.validation.rules.impl.SubtractionRule;

public class ValidationUtil {
	private ArrayList<RomanNumeralValidationRule> rules = 
			new ArrayList<RomanNumeralValidationRule>();
	
	public ValidationUtil(){
		rules.add(new CharacterSetRule());
		rules.add(new RepetitionOf4Rule());
		rules.add(new RepetitionRule());
		rules.add(new SubtractionRule());
	}
	
	/**
	 * Validate a string expected to be consists of Roman numerals.
	 * Each character in the string will be treated as a Roman numeral.
	 * 
	 * @param str Roman numberal String, such as MMVI.
	 */
	protected void validate(String str){
		Iterator<RomanNumeralValidationRule> it = rules.iterator();
		while(it.hasNext()){
			RomanNumeralValidationRule rule = it.next();
			rule.validate(str);
		}
	}
}

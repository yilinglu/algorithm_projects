package com.yiling.lu.romannumerals.validation.rules;

import com.yiling.lu.romannumerals.exception.InvalidNumeralException;

public abstract class AbstractRomanNumeralValidationRule implements
		RomanNumeralValidationRule {
	public abstract void validate(String symbolStr) throws InvalidNumeralException;
}

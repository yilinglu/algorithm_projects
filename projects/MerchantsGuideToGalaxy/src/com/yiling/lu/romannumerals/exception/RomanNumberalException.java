package com.yiling.lu.romannumerals.exception;

/**
 * <p>
 * A marker super class, the error message in all sublcasses of this class
 * have substitution markup to allow user to substitute variable names (external
 * symbols with mapping defined to Roman numerals).
 * </p>
 * 
 * 
 * @author yiling.lu@outlook.com
 *
 */
public class RomanNumberalException extends RuntimeException {
	public RomanNumberalException(String msg){
		super(msg);
	}
}

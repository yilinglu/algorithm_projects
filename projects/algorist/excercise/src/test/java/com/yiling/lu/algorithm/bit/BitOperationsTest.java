package com.yiling.lu.algorithm.bit;

import org.junit.Test;

import junit.framework.Assert;

public class BitOperationsTest {

	@Test
	public void testBinaryToIntConversion(){
		int actual = binaryToInt("0111111111111111");
		Assert.assertEquals(3, actual);
	}
	
	public int binaryToInt(String binary){
		if(binary == null || binary.length() == 0) return 0;
		int result = 0;
		for(int i=0; i<binary.length(); i++){
			char ch = binary.charAt(i);
			if(ch == '1'){
				result = result*2 + 1;
			}else if(ch == '0'){
				result = result*2;
			}else{
				throw new IllegalArgumentException("Invalid character found: " + ch + ".");
			}
			
		}
		return result;
	}
}

package com.yiling.lu.algorithm.bit;

import org.junit.Test;

import junit.framework.Assert;

public class BitOperationsTest {

	@Test
	public void testBinaryToIntConversion(){
		String bits32 = "11111111111111111111111111111111";
		int actual = binaryToInt(bits32);
		Assert.assertEquals(3, actual);
	}
	
	@Test
	public void testBinaryToIntConversion2(){
		String bits32 = genKthBitsBinary(31);
		Assert.assertEquals(31, bits32.length());
		int actual = binaryToInt(bits32);
		Assert.assertEquals(3, actual);
	}	
	
	public static String genKthBitsBinary(int k){
		StringBuffer buf = new StringBuffer();
		for(int i=0; i<k; i++){
			buf.append("1");
		}
		return buf.toString();
	}
	
	public int binaryToInt(String binary){
		if(binary == null || binary.length() == 0) return 0;
		int result = 0;
		for(int i=0; i<binary.length(); i++){
			char ch = binary.charAt(i);
			result = result*2 + ch;
		}
		return result;
	}
	
	public String convertToBinary(int x){
		StringBuilder buf = new StringBuilder();
		while(x>0){
			int bit = x%2;
			x = x/2;
			buf.insert(0, bit);
		}
		return buf.toString();
	}
	
	@Test
	public void testDecimalToBinaryConversion(){
		String binary = convertToBinary(4);
		Assert.assertEquals("100", binary);
	}
	
	@Test
	public void testDecimalToBinaryConversion2(){
		//1000000100000000111111111
		int num = 16908799;
		String binary = convertToBinary(num);
		System.out.println(num + ": binary is: " + binary);
		Assert.assertEquals("100", binary);
	}
}

package com.yiling.lu.algorithm.hashing;

import junit.framework.Assert;

import org.junit.Test;

public class HashingTest {

	@Test
	public void test() {
		double value = Hashing.computHash("a");
		
		Assert.assertEquals(0.0, value);
		
		value = Hashing.computHash("b");
		Assert.assertEquals(1.0, value);		

		value = Hashing.computHash("c");
		Assert.assertEquals(2.0, value);		

		value = Hashing.computHash("d");
		Assert.assertEquals(3.0, value);		

		value = Hashing.computHash("e");
		Assert.assertEquals(4.0, value);		

		value = Hashing.computHash("ba");
		Assert.assertEquals(26.0, value);		

		value = Hashing.computHash("bb");
		Assert.assertEquals(27.0, value);		
	}
	
	@Test
	public void testUpperCase(){
		double value = Hashing.computHash("A");
		
		Assert.assertEquals(0.0, value);
	}	
	
	@Test
	public void testLargeNumber(){
		String s = "zzz";
		double value = Hashing.computHash(s);
		
		System.out.println("Hash value of " + s + " is " + value);
		Assert.assertEquals(17575.0, value);
	}
	
	@Test
	public void testLargeNumber2(){
		StringBuilder builder = new StringBuilder();
		
		for(int i=0; i<4; i++){
			builder.append("z");
		}
		String s = builder.toString();
		
		double value = Hashing.computHash(s);
		
		System.out.println("Hash value of " + s + " is " + value);
		Assert.assertEquals(456975.0, value);
	}	

}

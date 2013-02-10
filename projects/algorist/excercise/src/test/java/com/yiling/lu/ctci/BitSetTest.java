package com.yiling.lu.ctci;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BitSetTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
//	public void test() {
//		BitSet bitset = new BitSet(32000);
//		bitset.set(31001);
//		boolean actual = bitset.get(1001);
//		
//		assertEquals(true, actual);
//	}
	
	@Test
	public void testSetBit(){
		setBit(31);
	}
	
	public void setBit(int pos) {
		int wordNumber = (pos >> 5); // divide by 32
		int bitNumber = (pos & 0x1F); // mod 32
		int mod = pos%32;
		int what = 1 << bitNumber;
		int result = 0;
		
		String binaryBefore = convertToBinary(result);
		System.out.println(binaryBefore);

		result |= 1 << bitNumber;
		
		String binary = convertToBinary(result);
		System.out.println(binary);
	}	

	
	@Test
	public void testDecimaltoBinary(){
		String actual = convertToBinary(156);
		assertEquals("10011100", actual);
	}
	
	public int convertToInt(String binary){
		int x = 0;
		for(int i=0; i<binary.length(); i++){
			x = x<<1;
			if(binary.charAt(i) == '1'){
				x = x+1;
			}
		}
		return x;
	}
	
	public String convertToBinary(int number){
		List<String> buf = new ArrayList<String>();
		while(number>0){
			Integer n = number%2;
			buf.add(0,n.toString());
			number = number/2;
		}
		StringBuilder bdr = new StringBuilder();
		for(int k=0; k<buf.size(); k++){
			bdr.append(buf.get(k));
		}
		return bdr.toString();
	}
	
	@Test
	public void testConvertToInt(){
		String bits = "00011111";
		//1011001
		int actual = convertToInt(bits);
		assertEquals(32, actual);
	}
	
	@Test
	public void testConvertToInt5(){
		String bits = "10000000";
		//1011001
		int actual = convertToInt(bits);
		assertEquals(128, actual);
	}	
	
	@Test
	public void testConvertToInt3(){
		String bits = "1011001";
		int actual = convertToInt(bits);
		assertEquals(89, actual);
	}	
	
	@Test
	public void testConvertToInt4(){
		String bits = "10011011";
		int actual = convertToInt(bits);
		assertEquals(155, actual);
	}	
	
	@Test
	public void testConvertToInt2(){
		String bits = "11100000";
		int actual = convertToInt(bits);
		assertEquals(224, actual);
		
		System.out.println(convertToInt("11100000"));
		System.out.println(convertToInt("11000000"));
		System.out.println(convertToInt("10000000"));
		System.out.println(convertToInt("00000000"));
	}	

}

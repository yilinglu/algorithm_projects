package com.yiling.lu.algorithm;

import CtCILibrary.AssortedMethods;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
	        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    @org.junit.Test
    public void testCharConversion(){
    	// asci value for A is 65
    	char ch = 'A';
    	int minusZero = ch - '0';
    	int plusZero = ch + '0';
    	int intvalue = ch;
    	
    	System.out.println("plusZero " + plusZero);
    	System.out.println("minusZero " + minusZero);
    	System.out.println("cast to num " + (int)ch);
    	
    	char space = ' ';
    	System.out.println("int value of space " + (int)' ');
    	
    }
    
    @org.junit.Test
    public void testConvertIntToChar(){
    	int intvalue = 65;
    	
    	System.out.println("char value " + (char)intvalue);
    }
    
    @org.junit.Test
    public void testStringOrder(){
    	String a = "x";
    	String b = "abcd";
    	
    	int r = a.compareTo(b);
    	
    	System.out.println("comparision result: " + r);
    }
    
    @org.junit.Test
    public void testMod(){
    	int value = -44;
    	System.out.println("negative mod " + value%4);
    }
}

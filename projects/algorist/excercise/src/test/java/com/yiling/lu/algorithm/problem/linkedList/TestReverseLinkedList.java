/**
 * 
 */
package com.yiling.lu.algorithm.problem.linkedList;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

/**
 * @author ylu
 *
 */
public class TestReverseLinkedList {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.yiling.lu.algorithm.problem.linkedList.ReverseLinkedList#reverse(CtCILibrary.LinkedListNode)}.
	 */
	@Test
	public void testReverse() {
		
		LinkedListNode head = AssortedMethods.randomLinkedList(3, 11, 111);
		LinkedListNode tempHead = head;
		
		List<Integer> org = new ArrayList<Integer>();
		List<Integer> reversed = new ArrayList<Integer>();
		
		while(tempHead != null){
			org.add(tempHead.data);
			tempHead = tempHead.next;
		}
		
		LinkedListNode newHead = ReverseLinkedList.reverse(head);
		
		while(newHead != null){
			reversed.add(0, newHead.data);
			newHead = newHead.next;
		}

		for(int i=0; i<org.size(); i++){
			assertEquals("original: " + org.get(i) +  ", reversed: " + reversed.get(i), org.get(i), reversed.get(i));
		}
		
	}

}

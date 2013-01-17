/**
 * 
 */
package com.yiling.lu.algorithm.problem.linkedList;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
	public void testReverseIteratively() {
		
		LinkedListNode head = new LinkedListNode(15, null, null);
		LinkedListNode second = new LinkedListNode(20, null, null);
		LinkedListNode third = new LinkedListNode(25, null, null);
		head.next = second;
		second.next = third;
		
		LinkedListNode tempHead = head;
		
		List<Integer> org = new ArrayList<Integer>();
		
		while(tempHead != null){
			org.add(tempHead.data);
			tempHead = tempHead.next;
		}
		
		LinkedListNode newHead = ReverseLinkedList.reverseIteratively(head);
		
		List<Integer> reversed = new ArrayList<Integer>();
		while(newHead != null){
			reversed.add(0, newHead.data);
			newHead = newHead.next;
		}

		for(int i=0; i<org.size(); i++){
			assertEquals("original: " + org.get(i) +  ", reversed: " + reversed.get(i), org.get(i), reversed.get(i));
		}
		
	}
	
	@Test
	public void testReverseIterativelyDynamic() {
		int nodeCount = 100000;
		LinkedListNode head = AssortedMethods.randomLinkedList(nodeCount, 11, 1000000);
		LinkedListNode tempHead = head;
		
		List<Integer> org = new ArrayList<Integer>();
		List<Integer> reversed = new ArrayList<Integer>();
		
		while(tempHead != null){
			org.add(tempHead.data);
			tempHead = tempHead.next;
		}
		
		long startT = System.currentTimeMillis();
		LinkedListNode newHead = ReverseLinkedList.reverseIteratively(head);
		long endT = System.currentTimeMillis();
		
		long elapsedMs = (endT - startT);
		System.out.println("Elapsed time in ms in reversing " + nodeCount + " nodes: " + elapsedMs);
		
		long elapsedSeconds = (endT - startT)/1000;
		long elapsedMins = elapsedSeconds/60;
		
		System.out.println("Elapsed time in seconds in reversing " + nodeCount + " nodes: " + elapsedSeconds);
		
		System.out.println("Elapsed time in minutes in reversing " + nodeCount + " nodes: " + elapsedMins);
		
		while(newHead != null){
			reversed.add(0, newHead.data); //this function is extremely slow for processing 1 million nodes.
			// reversed.add(newHead.data);
			newHead = newHead.next;
		}

		for(int i=0; i<org.size(); i++){
			assertEquals("original: " + org.get(i) +  ", reversed: " + reversed.get(i), org.get(i), reversed.get(i));
		}
		
	}	
	
	
	/**
	 * Test method for {@link com.yiling.lu.algorithm.problem.linkedList.ReverseLinkedList#reverse(CtCILibrary.LinkedListNode)}.
	 */
	@Test
	public void testReverseRecursively() {
		
		LinkedListNode head = new LinkedListNode(300, null, null);
		LinkedListNode second = new LinkedListNode(200, null, null);
		LinkedListNode third = new LinkedListNode(100, null, null);
		head.next = second;
		second.next = third;
		
		LinkedListNode tempHead = head;
		
		List<Integer> org = new ArrayList<Integer>();
		
		while(tempHead != null){
			org.add(tempHead.data);
			tempHead = tempHead.next;
		}
		
		LinkedListNode newHead = ReverseLinkedList.reverseRecursively(head);
		
		List<Integer> reversed = new ArrayList<Integer>();
		while(newHead != null){
			reversed.add(0, newHead.data);
			newHead = newHead.next;
		}

		for(int i=0; i<org.size(); i++){
			assertEquals("original: " + org.get(i) +  ", reversed: " + reversed.get(i), org.get(i), reversed.get(i));
		}
		
	}
	
	@Test
	public void testReverseRecursivelyDynamic() {
		
		// around 9617 nodes using recursive function will cause failure, statckoverflow
		LinkedListNode head = AssortedMethods.randomLinkedList(10000, 11, 1000000);
		LinkedListNode tempHead = head;
		
		List<Integer> org = new ArrayList<Integer>();
		List<Integer> reversed = new ArrayList<Integer>();
		
		while(tempHead != null){
			org.add(tempHead.data);
			tempHead = tempHead.next;
		}
		
		LinkedListNode newHead = ReverseLinkedList.reverseRecursively(head);
		
//		while(newHead != null){
//			reversed.add(0, newHead.data);
//			newHead = newHead.next;
//		}
//
//		for(int i=0; i<org.size(); i++){
//			assertEquals("original: " + org.get(i) +  ", reversed: " + reversed.get(i), org.get(i), reversed.get(i));
//		}
		
	}	
	

}

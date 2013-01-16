package com.yiling.lu.algorithm.problem.linkedList;

import CtCILibrary.LinkedListNode;

public class ReverseLinkedList {

	private static void doReverse(LinkedListNode x, LinkedListNode first, LinkedListNode resultHead){
		
		LinkedListNode second = first.next;
		
		first.next = x;
		
		if(second != null){
			doReverse(first, second, resultHead);
		}else{
			resultHead = first;
		}
	}
	
	public static LinkedListNode reverse(LinkedListNode head){
		LinkedListNode n = null;
		doReverse(null, head, n);
		return n;
	}
	
}

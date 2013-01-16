package com.yiling.lu.algorithm.problem.linkedList;

import CtCILibrary.LinkedListNode;

public class ReverseLinkedList {

	private static LinkedListNode doReverse(LinkedListNode x, LinkedListNode first){
		
		LinkedListNode second = first.next;
		
		first.next = x;
		
		if(second != null){
			return doReverse(first, second);
		}else{
			return first;
		}
	}
	
	public static LinkedListNode reverse(LinkedListNode head){
		return doReverse(null, head);
	}
	
}

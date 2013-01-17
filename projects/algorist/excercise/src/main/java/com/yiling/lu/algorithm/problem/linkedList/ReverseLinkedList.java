package com.yiling.lu.algorithm.problem.linkedList;

import CtCILibrary.LinkedListNode;

/**
 * 
 * @author ylu
 *
 */
public class ReverseLinkedList {

	private static LinkedListNode doReverseRecursively(LinkedListNode x, LinkedListNode first){
		
		LinkedListNode second = first.next;
		
		first.next = x;
		
		if(second != null){
			return doReverseRecursively(first, second);
		}else{
			return first;
		}
	}
	
	public static LinkedListNode reverseRecursively(LinkedListNode head){
		return doReverseRecursively(null, head);
	}
	
	public static LinkedListNode reverseIteratively(LinkedListNode head){
		return doReverseIteratively(null, head);
	}	
	
	private static LinkedListNode doReverseIteratively(LinkedListNode x, LinkedListNode first) {
		
		while (first != null) {
			LinkedListNode second = first.next;
			first.next = x;
			x = first;

			if (second == null) {
				break;
			} else {
				first = second;
			}
		}
		return first;
	}
		
	
}

package com.yiling.lu.algorithm.datastructure.tree;

import CtCILibrary.TreeNode;

public class BinaryTree {

	/**
	 * Given two tree nodes, determine if they are exactly the same.
	 * Better than comparing pre and inorder traversal sequence method.
	 * 
	 * @param r1
	 * @param r2
	 */
	public static boolean isMatch(TreeNode r1, TreeNode r2) {
		if (r1 == r2)
			return true;
		if ((r1 != null && r2 == null) || (r1 == null && r2 != null))
			return false;

		if (r1.data == r1.data) {
			return isMatch(r1.left, r2.left) && isMatch(r1.right, r2.right);
		} else {
			return false;
		}
	}

	/**
	 * This internal method assumes s<=t
	 * 
	 * @param array
	 * @param s
	 * @param t
	 * @return
	 */
	private static TreeNode buildTree(Integer[] array, int s, int t) {

		if (s > t) {
			return null;
		}
		int mid = (s + t) / 2;
		TreeNode root = new TreeNode(array[mid]);

		root.right = buildTree(array, mid + 1, t);
		root.left = buildTree(array, s, mid - 1);

		return root;
	}

	public static TreeNode constructTree(Integer[] array) {
		return buildTree(array, 0, array.length - 1);
	}

	public static int getHeight(TreeNode root) {
		if (root == null)
			return -1;
		else {
			return 1 + Math.max(getHeight(root.left), getHeight(root.right));
		}
	}
	
	public static void inorder(TreeNode root){
		if(root == null)
			return;
		inorder(root.left);
		System.out.print(root.data + " - ");
		inorder(root.right);
	}
	
	
	public static TreeNode kthSmallest(TreeNode root, int k){
		TreeNode result = kthSmallestHelper(root, k, new Counter());
		return result;
	}
	
	public static TreeNode kthSmallestHelper(TreeNode root, int k, Counter count) {
		if (root == null)
			return root;
		TreeNode temp = kthSmallestHelper(root.left, k, count);
		
		if(temp == null){
			count.increment();
			if (count.getCnt() == k) {
				return root;
			}
			temp = kthSmallestHelper(root.right, k, count);
		}
		
		return temp;
	}
	
	
	public static TreeNode kthSmallestWithPrimitiveType(TreeNode root, Integer k){
		TreeNode result = kthSmallestWithPrimitiveTypeHelper(root, k, 0);
		return result;
	}	
	
	private static TreeNode kthSmallestWithPrimitiveTypeHelper(TreeNode root, int k, int count) {
		int localCount = count;
		if (root == null)
			return root;
		TreeNode temp = kthSmallestWithPrimitiveTypeHelper(root.left, k, count);
		
		if(temp == null){
			localCount++;
			count++;
			if (localCount == k) {
				return root;
			}
			temp = kthSmallestWithPrimitiveTypeHelper(root.right, k, localCount);
		}
		
		return temp;
	}	
	
	public static TreeNode kthMaxInternal(TreeNode root, int k, int count){
		if(root==null) return root;
		
		TreeNode temp = kthMaxInternal(root.right, k, count);
		if(temp==null){
			count++;
			if(count==k){
				return root;
			}
			temp = kthMaxInternal(root.left, k, count);
		}
		return temp;
	}
	
	public static TreeNode kthMax(TreeNode root, int k){
		return kthMaxInternal(root, k, 0);
	}	


}

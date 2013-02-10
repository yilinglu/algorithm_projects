package com.yiling.lu.algorithm.datastructure.tree;

import CtCILibrary.TreeNode;

public class BinaryTree {

	/**
	 * Given two tree nodes, determine if they are exactly the same
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
	

}

package com.yiling.lu.algorithm.problem.theAlgorithmDesignManual.graphTraversal;

import CtCILibrary.TreeNode;

/**
 * Find ith node in Tree
 * 
 * @author yilingfamily
 *
 */
public class Question532 {

	private int counter = 1;
	private TreeNode foundNode = null;
	
	public Question532(int counter_arg){
		counter = counter_arg;
	}
	public void findithNode(TreeNode root){
		if(root == null || foundNode != null || counter ==0){
			return;
		}else{
			findithNode(root.left);
			counter--;
			if(counter == 0){
				foundNode = root;
			}
			findithNode(root.right);
		}
	}
	
	public TreeNode getFoundNode(){
		return foundNode;
	}
	
	
	public TreeNode findithNodeAlt(TreeNode root){
		if(root == null || counter ==0){
			return root;
		}else{
			TreeNode node = findithNodeAlt(root.left);
			counter--;
			if(counter == 0){
				return node;
			}else{
				return findithNodeAlt(root.right);
			}
		}
	}	
}

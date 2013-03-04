package com.yiling.lu.algorithm.datastructure.tree;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.yiling.lu.algorithm.problem.sorting.comparasionbased.QuickSort;

import CtCILibrary.AssortedMethods;
import CtCILibrary.TreeNode;
import Question4_1.QuestionBrute;

public class BinaryTreeTest {

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

	@Test
	public void testIsMatch() {
		Integer[] array = {6,5,70,80,90,2,3,1};
		TreeNode r1 = BinaryTree.constructTree(array);
		TreeNode r2 = BinaryTree.constructTree(array);
		
		boolean match = BinaryTree.isMatch(r1, r2);
		
		assertEquals(true, match);
	}
	
	@Test
	public void testIsMatch2() {
		Integer[] array = {6,5,70,80,90,2,3,1};
		TreeNode r1 = BinaryTree.constructTree(array);
		
		Integer[] array2 = {6,5,70,80,90,2,3};
		TreeNode r2 = BinaryTree.constructTree(array2);
		
		r1.print();
		System.out.println("===");
		r2.print();
		boolean match = BinaryTree.isMatch(r1, r2);
		
		assertEquals(false, match);
	}	

	@Test
	public void testConstructTree() {
		Integer[] array = {6,5,70,80,90,2,3,1};
		TreeNode root = BinaryTree.constructTree(array);
		
		root.print();
	}
	
	@Test
	public void testConstructBST() {
		Integer[] array = {6,5,70,80,90,2,3,1};
		QuickSort.qsort(array);
		TreeNode root = BinaryTree.constructTree(array);
		
		root.print();
		
		int h = BinaryTree.getHeight(root);
		int h2 = QuestionBrute.getHeight(root);
		
		assertEquals(3, h);
		assertEquals(4, h2);
	}	
	
	@Test
	public void testCreateBST() {
		int[] array = {6};
		TreeNode root = TreeNode.createMinimalBST(array);		
		root.print();
		
		int h = BinaryTree.getHeight(root);
		
		assertEquals(0, h);
	}	
	
	/**
	 * Use the CtCi TreeNode method for getting height, the
	 * result on a single node tree is wrong, it should be 0,
	 * but this method in this class returns 1.
	 * 
	 */
	@Test
	public void testComputeTreeHeight() {
		Integer[] array = {6};
		QuickSort.qsort(array);
		TreeNode root = BinaryTree.constructTree(array);
		
		root.print();
		
		int h = root.height();
		
		assertEquals(0, h);
	}	
	
	
	@Test
	public void testComputeTreeHeight2() {
		Integer[] array = {6,3};
		QuickSort.qsort(array);
		TreeNode root = BinaryTree.constructTree(array);
		
		root.print();
		
		int h = BinaryTree.getHeight(root);
		
		assertEquals(1, h);
	}	
	
	
	@Test
	public void testComputeTreeHeight3() {
		int h = BinaryTree.getHeight(null);
		
		assertEquals(-1, h);
	}	
	
	@Test
	public void testInorderTraversal(){
		Integer[] array = {0,1,2,3,5,70,80,90};
		TreeNode root = BinaryTree.constructTree(array);
		root.print();
		BinaryTree.inorder(root);
	}
	
	@Test
	public void testKthSmallest(){
		Integer[] array = {0,1,2,3,5,70,80,90};
		TreeNode root = BinaryTree.constructTree(array);
		root.print();
		TreeNode node = BinaryTree.kthSmallest(root, 4);		
		
		node.print();
		
		Assert.assertEquals(3, node.data);
	}
	
	@Test
	public void testKthSmallestPrimitiveTypeAsCounter(){
		Integer[] array = {0,1,2,3,5,70,80,90};
		TreeNode root = BinaryTree.constructTree(array);
		root.print();
		TreeNode node = BinaryTree.kthSmallestWithPrimitiveType(root, 4);		
		
		node.print();
		Assert.assertEquals(3, node.data);
	}	
	
	@Test
	public void testKthMax(){
		Integer[] array = {0,1,2,3,5,70,80,90};
		TreeNode root = BinaryTree.constructTree(array);
		root.print();
		TreeNode node = BinaryTree.kthMax(root, 3);		
		
		node.print();
		Assert.assertEquals(70, node.data);		
	}

}

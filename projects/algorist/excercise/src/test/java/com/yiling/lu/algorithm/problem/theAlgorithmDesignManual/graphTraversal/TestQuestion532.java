package com.yiling.lu.algorithm.problem.theAlgorithmDesignManual.graphTraversal;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import CtCILibrary.AssortedMethods;
import CtCILibrary.BTreePrinter;
import CtCILibrary.TreeNode;

public class TestQuestion532 {

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
	public void testFindithNode() {
		int[] array = {1,2,3};
		TreeNode root = AssortedMethods.createTreeFromArray(array);
		
		BTreePrinter.printNode(root);
		
		Question532 question = new Question532(3);
		question.findithNode(root);
		
		TreeNode found = question.getFoundNode();
		
		Assert.assertNotNull(found);
		
		Assert.assertEquals(3, found.data);
	}
	
	@Test
	public void testFindithNodeStatic() {
		int[] array = {1,2,3};
		TreeNode root = AssortedMethods.createTreeFromArray(array);
		
		BTreePrinter.printNode(root);
		TreeNode found = null;
		
		Question532.findithNodeStatic(root, found, 3);
		
		Assert.assertNotNull(found);
		
		Assert.assertEquals(3, found.data);
	}	
	
	@Test
	public void testFindithNode2() {
		int[] array = {1,2,3};
		TreeNode root = AssortedMethods.createTreeFromArray(array);
		
		BTreePrinter.printNode(root);
		
		Question532 question = new Question532(1);
		question.findithNode(root);
		
		TreeNode found = question.getFoundNode();
		
		Assert.assertNotNull(found);
		
		Assert.assertEquals(2, found.data);
	}	

	@Test
	public void testFindithNode1() {
		int[] array = {1,2,3};
		TreeNode root = AssortedMethods.createTreeFromArray(array);
		
		BTreePrinter.printNode(root);
		
		Question532 question = new Question532(2);
		question.findithNode(root);
		
		TreeNode found = question.getFoundNode();
		
		Assert.assertNotNull(found);
		
		Assert.assertEquals(1, found.data);
	}	
	
	
	@Test
	public void testFindithNode4() {
		int[] array = {1,2,3,4,5,6};
		TreeNode root = AssortedMethods.createTreeFromArray(array);
		
		BTreePrinter.printNode(root);
		
		Question532 question = new Question532(6);
		question.findithNode(root);
		
		TreeNode found = question.getFoundNode();
		
		Assert.assertNotNull(found);
		
		Assert.assertEquals(3, found.data);
	}	
	
	@Test
	public void testFindithNode5() {
		TreeNode root = new TreeNode(3);
		
		BTreePrinter.printNode(root);
		
		Question532 question = new Question532(1);
		question.findithNode(root);
		
		TreeNode found = question.getFoundNode();
		
		Assert.assertNotNull(found);
		
		Assert.assertEquals(3, found.data);
	}	
	
	@Test
	public void testFindithNodeTestNull() {
		TreeNode root = null;
		
		BTreePrinter.printNode(root);
		
		Question532 question = new Question532(1);
		question.findithNode(root);
		
		TreeNode found = question.getFoundNode();
		
		Assert.assertNull(found);
	}	
}

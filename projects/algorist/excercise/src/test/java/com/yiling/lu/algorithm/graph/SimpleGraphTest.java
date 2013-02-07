package com.yiling.lu.algorithm.graph;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SimpleGraphTest {

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
	public void testInsertEdge() {
		SimpleGraph graph = new SimpleGraph();
		graph.insertEdge(1, 2, false);
//		graph.insertEdge(1, 3, false);
//		graph.insertEdge(4, 2, false);
//		graph.insertEdge(4, 3, false);
		
		SimpleGraph.printGraph(graph);
		
	}

	@Test
	public void testPrintGraph() {
		fail("Not yet implemented");
	}

}

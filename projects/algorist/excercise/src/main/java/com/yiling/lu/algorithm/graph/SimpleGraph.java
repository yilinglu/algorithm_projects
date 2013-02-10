package com.yiling.lu.algorithm.graph;

import java.util.ArrayList;
import java.util.List;

public class SimpleGraph {
	public static final int MAXV = 1000;

	public GraphNode[] edges = new GraphNode[MAXV];
//	public List<GraphNode>[] adjacencyList = new ArrayList[MAXV];
//	
//	public List<GraphNode>[] adjacencyList2 = new List[MAXV];
	public int[] degree = new int[MAXV];
	public int nvertices = 0;
	public int nedges = 0;
	boolean directed;

	public void insertEdge(int x, int y, boolean directed) {
		GraphNode p = new GraphNode();
		p.y = y;
		p.next = edges[x];
		edges[x] = p;

		degree[x]++;

		if (!directed) {
			insertEdge(y, x, true);
		} else {
			nedges++;
		}

	}

	public static void printGraph(SimpleGraph g) {
		for (int i = 0; i < g.edges.length; i++) {
			GraphNode node = g.edges[i];
			if (node != null) {
				while (node != null) {
					System.out.println(i + "->" + node.y);
					node = node.next;
				}

			}
		}
	}

}

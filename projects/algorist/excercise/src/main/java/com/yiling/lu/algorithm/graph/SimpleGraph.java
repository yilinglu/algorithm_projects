package com.yiling.lu.algorithm.graph;

import java.util.List;


public class SimpleGraph {
	public static final int MAXV = 1000;
	
	public GraphNode[] edges = new GraphNode[MAXV];
	public int[] degree = new int[MAXV];
	public int nvertices = 0;
	public int nedges = 0;
	boolean directed;
	
	public void insertEdge(SimpleGraph g, int x, int y, boolean directed){
		GraphNode p = new GraphNode();
		p.y = y;
		edges[x] = p;
		
		
		g.degree[x]++;
		
		if(!directed){
			insertEdge(g, y, x, true);
		}else{
			g.nedges++;
		}
		
	}
	
	public void printGraph(SimpleGraph g){
		for(int i=0; i<edges.length; i++){
			GraphNode p = edges[i];
			while(p != null){
				System.out.print(p.y);
				p = p.next;
				
				if(p != null){
					System.out.print(",");
				}
			}
			System.out.println();
		}
	}
			
}

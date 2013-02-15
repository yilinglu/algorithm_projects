package com.yiling.lu.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SimpleEditDistance {
	
	protected static List<String> getOneEditWorlds(char[] word){
		List<String> result = new ArrayList<String>();
		
		for(int i=0; i<word.length; i++){
			int p = 'a';
			int q = 'z';
			
			while(p<=q){
				if((char)p != word[i]){
					char[] w = Arrays.copyOf(word, word.length);
					w[i] = (char)p;
					result.add(new String(w));
				}
				p++;
			}
		}
		return result;
	}
	
	public static List<String> transform(String start, String end, HashSet<String> dictionary){
		Hashtable<String, Boolean> visited = new Hashtable<String, Boolean>();
		Hashtable<String, String> track = new Hashtable<String,String>();
		List<String> path = new ArrayList<String>();
		
		Queue<String> queue = new LinkedList<String>();
		queue.add(start);
		visited.put(start, true);
		
		while(!queue.isEmpty()){
			String next = queue.remove();
			
			System.out.println("dequeue word: " + next);
			if(next.equalsIgnoreCase(end)){
				path.add(0, next);
				
				// recover path by backtracking the track map
				String parent = track.get(next);
				while(parent != null){
					path.add(0,parent);
					parent = track.get(parent);
				}
				
				return path;
			}
			
			List<String> adj = getOneEditWorlds(next.toCharArray());
			
			for(int i=0; i<adj.size(); i++){
				String w = adj.get(i);
				Boolean seen = visited.get(w);
				if((seen == null || !seen) && dictionary.contains(w)){
					System.out.println("adding to queue: " + w);
					queue.add(w);
					track.put(w, next);
					
					visited.put(w,true);
				}
				
			}
			
		}
		
		return path;
	}
	
	private static boolean isInDict(String wd, int index){
		return (index%2 != 0)? true: false;
	}
	

}

package com.yiling.lu.algorithm.problem.combinatorics;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	private static void doPermutate(char[] array, boolean[] selected, List<String> solution, String start, int curLevel, int maxLevel){
		if(curLevel < maxLevel){
			
			for(int k=0; k<array.length; k++){
				
				if(!selected[k]){
					selected[k] = true;
					String result = start + array[k];
					
					doPermutate(array, selected, solution, result, ++curLevel, maxLevel);
				}
			}
		}else{
			solution.add(start);
		}
	}
	
	public static List<String> permutate(char[] array){
		List<String> solution = new ArrayList<String>();
		
		
		//System.out.println("start length " + start.length());
		
		for(int i=0; i<array.length; i++){
			boolean[] selected = new boolean[array.length];
			String start = new Character(array[i]).toString();
			selected[i] = true;
			
			int max = array.length;
			doPermutate(array, selected, solution, start, 0, max-1);
			
		}
		
		return solution;
	}
}

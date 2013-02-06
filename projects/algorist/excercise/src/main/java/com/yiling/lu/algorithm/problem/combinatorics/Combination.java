package com.yiling.lu.algorithm.problem.combinatorics;

import java.util.ArrayList;
import java.util.List;

public class Combination {

	private static void doCombo(char[] elements, int size, StringBuffer result,
			int curLevel, List<String> solutions) {
		
		if(result.length()<size){
			for (int i = 0; i < elements.length; i++) {
				if(i>=curLevel ){
					result.append(elements[i]);
					doCombo(elements, size, result, i+1, solutions);
					
					//backtracking
					result.setLength(result.length()-1);
				}
			}
		}else{
			solutions.add(result.toString());
			System.out.println(result.toString());
		}
		
	}
	public static List<String> doComboSize(char[] elements, int size){
		int level = 0;
		StringBuffer buf = new StringBuffer();
		List<String> solutions = new ArrayList<String>();
		doCombo(elements,size,buf,level,solutions);
		
		return solutions;
	}
	
	public static List<String> totalCombo(char[] elements){
		List<String> total = new ArrayList<String>();
		for(int i=0; i<elements.length; i++){
			List<String> temp = doComboSize(elements, i+1);
			total.addAll(temp);
		}
		
		return total;
	}
	
	public static int calcCombo(int n, int k){
		if(k>n) return 0;
		
		if(k == 1) return n;
		if(k == n) return 1;
		
		return calcCombo(n-1, k-1) + calcCombo(n-1,k);		
	}
	
	public static int computCombo(int n, int k){
		if(n>0 && k>0){
			return calcCombo(n, k);
		}else{
			return 0;
		}
	}
}

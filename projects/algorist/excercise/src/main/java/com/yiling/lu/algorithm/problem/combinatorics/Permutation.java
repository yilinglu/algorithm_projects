package com.yiling.lu.algorithm.problem.combinatorics;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	private static void doPermutate(char[] array, boolean[] selected,
			List<String> solution, StringBuffer buffer, int curLevel,
			int maxLevel) {
		
		if (curLevel < maxLevel) {

			for (int k = 0; k < array.length; k++) {

				if (!selected[k]) {
					selected[k] = true;
					buffer.append(array[k]);

					doPermutate(array, selected, solution, buffer,
							curLevel + 1, maxLevel);
					
					// BACKTRACKING!!!
					// IF using ++curLevel instead of curLevel + 1 in recursive call, 
					// then need --curLevel here to backtrack!
					selected[k] = false;
					buffer.setLength(buffer.length() - 1);
				}
			}
		} else {
			solution.add(buffer.toString());
		}
	}

	public static List<String> permutate(char[] array) {
		List<String> solution = new ArrayList<String>();

		boolean[] selected = new boolean[array.length];
		StringBuffer start = new StringBuffer();

		int max = array.length;
		doPermutate(array, selected, solution, start, 0, max);

		return solution;
	}
	
}

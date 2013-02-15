package com.yiling.lu.algorithm.problem.sorting.comparasionbased;

/**
 * Question 4-18 in TADM
 * 
 * @author yiling
 * 
 */
public class RedWhiteBlueSort {
	/**
	 * example: {'r','r','b','w'}
	 */
	public static void sort(char[] array) {
		if (array != null && array.length > 1) {
			int s = sortOneColor(array, 0, 'r');
			sortOneColor(array, s, 'w');
		}
	}

	/**
	 * Move all element of one color to the front of the array
	 * 
	 * @return
	 */
	private static int sortOneColor(char[] array, int start, char front) {
		int lead = start;
		int i = start;

		while (i < array.length) {
			if (array[i] == front) {
				swap(array, i, lead);
				lead++;
			}
			i++;
		}
		return lead;
	}

	private static void swap(char[] input, int a, int b) {
		char tmp = input[a];
		input[a] = input[b];
		input[b] = tmp;
	}
}

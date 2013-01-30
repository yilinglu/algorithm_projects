package com.yiling.lu.algorithm.util;

import junit.framework.Assert;

public class AssortedUtils {

	public static void verifyOder(int[] input, boolean ascending) {
		if (input == null || input.length < 2)
			return;
		System.out.print(input[0]);

		for (int i = 1; i < input.length; i++) {
			System.out.print("," + input[i]);
			if (ascending) {
				Assert.assertTrue("expecting " + input[i] + " >= "
						+ input[i - 1], input[i] >= input[i - 1]);
			} else {
				Assert.assertTrue(input[i] <= input[i - 1]);
			}
		}
		System.out.println();
	}

	public static void verifyOrder(Comparable[] input) {
		for (int i = 1; i < input.length; i++) {
			Comparable str1 = input[i - 1];
			Comparable str2 = input[i];
			int result = str1.compareTo(str2);

			Assert.assertTrue("expecting " + str1 + " be after (greater than) "
					+ str2, result <= 0);
		}
	}

	public static <T extends Comparable<T>> void verifyOrder(T[] input,
			boolean ascending) {
		if (input == null || input.length < 2)
			return;

		
		System.out.print(input[0] + ",");
		for (int i = 1; i < input.length; i++) {
			System.out.print(input[i]);
			if(i!= input.length -1){
				System.out.print(",");
			}

			if (ascending) {
				Assert.assertTrue("expecting " + input[i] + " >= "
						+ input[i - 1], input[i].compareTo(input[i - 1]) >= 0);
			} else {
				Assert.assertTrue("expecting " + input[i] + " <= "
						+ input[i - 1], input[i].compareTo(input[i - 1]) <= 0);
			}
		}
	}
}

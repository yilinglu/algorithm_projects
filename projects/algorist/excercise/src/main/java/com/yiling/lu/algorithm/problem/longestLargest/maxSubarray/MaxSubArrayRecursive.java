package com.yiling.lu.algorithm.problem.longestLargest.maxSubarray;

public class MaxSubArrayRecursive {

	private static int[] findMaxSubarrayInternal(int[] input, int low, int high) {

		if (low == high) {
			return new int[] { low, high, input[low] };

		} else {
			int mid = (low + high) / 2;
			int[] leftResult = findMaxSubarrayInternal(input, low, mid);
			int[] rightResult = findMaxSubarrayInternal(input, mid + 1, high);
			int[] crossingResult = findCrossingMaxSubarrayInternal(input, low, mid, high);

			if (leftResult[2] > rightResult[2]
					&& leftResult[2] > crossingResult[2]) {
				return leftResult;
			} else if (rightResult[2] > leftResult[2]
					&& rightResult[2] > crossingResult[2]) {
				return rightResult;
			} else if (crossingResult[2] > leftResult[2]
					&& crossingResult[2] > rightResult[2]) {
				return crossingResult;
			}
			return rightResult;
		}

	}

	private static int[] findCrossingMaxSubarrayInternal(int[] input, int low,
			int mid, int high) {
		// examine low to mid
		int maxLeft = input[mid];
		int left = mid;
		int k = mid - 1;
		int runningTotal = maxLeft;
		
		while (k >= low) {
			runningTotal = runningTotal + input[k];
			if (runningTotal > maxLeft) {
				maxLeft = runningTotal;
				left = k;
			}
			k--;
		}

		// examine mid + 1 to high
		int maxRight = input[mid + 1];
		int right = mid + 1;
		k = mid + 2;
		runningTotal = maxRight;
		
		while (k <= high) {
			runningTotal = runningTotal + input[k];
			if (runningTotal > maxRight) {
				maxRight = runningTotal;
				right = k;
			}
			k++;
		}

		return new int[] { left, right, maxLeft + maxRight };
	}

	public static int[] maxSubarray(int[] input) {
		return findMaxSubarrayInternal(input, 0, input.length - 1);
	}

}

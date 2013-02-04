package com.yiling.lu.algorithm.problem.coursera.stanford;

/**
 * The file contains all of the integers between 1 and 10,000 (inclusive, with
 * no repeats) in unsorted order. The integer in the ith row of the file gives
 * you the ith entry of an input array.
 * 
 * Your task is to compute the total number of comparisons used to sort the
 * given input file by QuickSort. As you know, the number of comparisons depends
 * on which elements are chosen as pivots, so we'll ask you to explore three
 * different pivoting rules. You should not count comparisons one-by-one.
 * Rather, when there is a recursive call on a subarray of length m, you should
 * simply add m−1 to your running total of comparisons. (This is because the
 * pivot element is compared to each of the other m−1 elements in the subarray
 * in this recursive call.)
 * 
 * WARNING: The Partition subroutine can be implemented in several different
 * ways, and different implementations can give you differing numbers of
 * comparisons. For this problem, you should implement the Partition subroutine
 * exactly as it is described in the video lectures (otherwise you might get the
 * wrong answer).
 * 
 * DIRECTIONS FOR THIS PROBLEM:
 * 
 * For the first part of the programming assignment, you should always use the
 * first element of the array as the pivot element.
 * 
 * @author ylu
 * 
 * @param <E>
 */
public class QuickSortAlt<E> {
	private int comps;

	public void qsort(Comparable<E>[] array) {
		// shuffle(array);
		qsortInternal(array, 0, array.length - 1);
	}

	/**
	 * @param input
	 * @param start
	 *            starting index of the sub-array
	 * @param end
	 *            index of the sub-array
	 */
	private void qsortInternal(Comparable<E>[] input, int start, int end) {
		if (start < end) {
			int i = partition(input, start, end);
			// after this partition, element at ith position is at its sorted
			// position
			// in the final sorted array
			qsortInternal(input, start, i - 1);
			qsortInternal(input, i + 1, end);
		}
	}

	/**
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	private int partition(Comparable<E>[] array, int start, int end) {
		comps = comps + (end - start);
		Comparable<E> pivot = array[start];
		int low = start;

		// low is always pointing at the right most element of the left part of
		// the array
		// , which is the part that is less than or equal to the pivot value.
		for (int high = low + 1; high <= end; high++) {

			if (array[high].compareTo((E) pivot) < 0) {
				low = low + 1;
				swap(array, low, high);
			}
		}
		swap(array, start, low);

		return low;
	}

	// private <E> void shuffle(Comparable<E>[] array){
	// Random rand = new Random();
	// int r = rand.nextInt(7);
	//
	// for(int i=0; i<array.length; i++){
	// int w = (i+r)%array.length;
	// swap(array, i,w);
	// }
	// }

	private void swap(Comparable<E>[] input, int a, int b) {
		if (a != b) {
			Comparable<E> tmp = input[a];
			input[a] = input[b];
			input[b] = tmp;
		}
	}

	public int getComparisonCount() {
		return comps;
	}
}

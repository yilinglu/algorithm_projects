package com.yiling.lu.algorithm.sorting.lineartime;

/**
 * Counting sort assume each of the n input elements is an integer
 * between 0 to k, for some integer k. When k=O(n), the sort runs in Big Theta n time.
 * 
 * The running time is O(k+n), if k is n square or NlogN, then this algorithm does not 
 * give linear time performance. It is therefore suited for cases where k is smaller than n
 * 
 * Chapter 8 of LCRS book.
 * 
 * @author yilingl@gmail.com
 *
 */
public class CountingSort {

	public static int[] sort(int[] array){
		if(array.length==0)
			return array;
		
		int max = findMax(array);
		
		// initialize array for 0 to max
		int[] cnt = new int[max+1];
		int[] result = new int[array.length];
		
		// do the counting
		for(int i=0; i<array.length; i++){
			cnt[array[i]] = cnt[array[i]]+1;
		}
		// do the accumulative counting
		for(int i=1; i<cnt.length; i++){
			cnt[i] = cnt[i] + cnt[i-1];
		}
		
		for(int i=array.length-1; i>=0; i--){
			result[cnt[array[i]]-1] = array[i];
			cnt[array[i]] = cnt[array[i]]-1;
		}
		return result;
	}
	
	private static int findMax(int[] input){
		int max = input[0];
		
		for(int i=1; i<input.length; i++){
			if(input[i]>max){
				max = input[i];
			}
		}
		return max;
	}
	
	/**
	 * <p>
	 * Use counting sort to sort the input string array by the character at specified index position.
	 * </p>
	 * <p>
	 * Index starts from the first char of a string at value 0, to length of the string -1.
	 * </p>
	 * 
	 * <p>
	 * If pos is greater than or equal to length of the string, use empty space as the key character.
	 * </p>
	 * 
	 * 
	 * @param input
	 * @param pos
	 * @return input sorted by character at specified position
	 * 
	 */
	public static String[] sortStringArray(String[] input, int pos){
		// each element initialized to zero
		int[] count = new int[256];
		String[] result = new String[input.length];
		
		for(String str: input){
			int key = getKey(str, pos);
			count[key]++;
		}
		
		for(int i=1; i<count.length; i++){
			count[i] = count[i] + count[i-1];
		}
		
		for(int i=input.length-1; i>=0; i--){
			int key = getKey(input[i], pos);
			int cnt = count[key];
			result[cnt-1] = input[i];
			count[key] = count[key]-1;
		}
		return result;
	}
	
	/**
	 * When pos is out of range of the argument string, treat argument
	 * string as back padded by empty spaces.
	 * 
	 * @param str
	 * @param pos
	 * @return ASCI value of the character as argument index
	 */
	protected static int getKey(String str, int pos){
		
		if(pos>(str.length()-1)){
			return ' ';

		}else{
			return (int)(str.charAt(pos));
		}
		
	}	
	
//	protected static int getKey(String str, int pos, int maxLen){
//		
//		if(str.length()<maxLen){
//			if(pos < maxLen - str.length()){
//				// front pad with empty space when string is shorter than maxLen
//				return (int)' ';
//			}else{
//				return str.charAt(pos - maxLen + str.length());
//			}
//		}else{
//			return (int)(str.charAt(pos));
//		}
//		
//	}
		
}

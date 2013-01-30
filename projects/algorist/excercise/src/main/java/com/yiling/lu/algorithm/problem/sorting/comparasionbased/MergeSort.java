package com.yiling.lu.algorithm.problem.sorting.comparasionbased;

public class MergeSort {

	public int inversionCount = 0;
	
	public int[] mergeSort(int[] input){
		if(input == null || input.length ==0 || input.length == 1){
			return input;
		}else{
			return mergesortInternal(input, 0, input.length-1);
		}
	}
	private int[] mergesortInternal(int[] array, int s, int e){
		if(s == e){
			return new int[] {array[s]};
		}else{
			int mid = (s+e)/2;
			int[] left = mergesortInternal(array, s, mid);
			int[] right = mergesortInternal(array, mid+1, e);
			
			int[] temp = new int[left.length+right.length];
			
			int i=0; int j=0; int k=0;
			
			while(i<left.length && j<right.length){
				if(left[i]<=right[j]){
					temp[k] = left[i];
					i++;
					k++;
				}else{
					temp[k] = right[j];
					j++;
					k++;
					inversionCount = inversionCount + left.length-i;
				}
			}
			
			copyArray(left, i, temp, k);
			int copyLen = left.length-i;
			copyArray(right, j, temp, k+copyLen);
			
			return temp;
		}
	}
	
	private void copyArray(int[] source, int soureStart, int[] target, int targetStart){
		while(soureStart<source.length){
			target[targetStart] = source[soureStart];
			soureStart++;
			targetStart++;
		}
	}
}

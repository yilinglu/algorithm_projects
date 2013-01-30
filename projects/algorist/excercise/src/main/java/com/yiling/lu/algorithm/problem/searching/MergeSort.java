package com.yiling.lu.algorithm.problem.searching;

public class MergeSort {
	private int inversionCount = 0;
	
	public int[] mergeSort(int[] input){
		if(input == null || input.length ==0 || input.length == 1){
			return input;
		}else{
			return mergesortInternal(input, 0, input.length-1);
		}
	}
	private int[] mergesortInternal(int[] a, int s, int e){
		if(s == e){
			return new int[] {a[s]};
		}else{
			int mid = (s+e)/2;
			int[] left = mergesortInternal(a, s, mid);
			int[] right = mergesortInternal(a, mid+1, e);
			
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
					inversionCount = inversionCount + left.length-i-1;
				}
			}
			
			copyArray(left, i+1, a, k+1);
			copyArray(right, j+1, a, k+1+(left.length - i -1));
			
			return temp;
		}
	}
	
	private void copyArray(int[] a, int start, int[] target, int tStart){
		while(start<a.length){
			target[tStart] = a[start];
			start++;
			tStart++;
		}
	}
}

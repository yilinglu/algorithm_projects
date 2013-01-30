package com.yiling.lu.algorithm.problem.sorting.comparasionbased;

public class MergeSort {

	private long inversionCount = 0;
	
	public Integer[] mergeSort(Integer[] input){
		if(input == null || input.length ==0 || input.length == 1){
			return input;
		}else{
			return mergesortInternal(input, 0, input.length-1);
		}
	}
	private Integer[] mergesortInternal(Integer[] array, int s, int e){
		if(s == e){
			return new Integer[] {array[s]};
		}else{
			int mid = (s+e)/2;
			Integer[] left = mergesortInternal(array, s, mid);
			Integer[] right = mergesortInternal(array, mid+1, e);
			
			Integer[] temp = new Integer[left.length+right.length];
			
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
					
					int count = left.length-i;
					
					if(count<0){
						System.out.println("count should not be negative: " + count + ".");
						System.exit(1);
					}
					increaseCount(count);
				}
			}
			
			copyArray(left, i, temp, k);
			int copyLen = left.length-i;
			copyArray(right, j, temp, k+copyLen);
			
			return temp;
		}
	}
	
	private void copyArray(Integer[] source, int soureStart, Integer[] target, int targetStart){
		while(soureStart<source.length){
			target[targetStart] = source[soureStart];
			soureStart++;
			targetStart++;
		}
	}
	public long getInversionCount() {
		return inversionCount;
	}
	
	public void increaseCount(int increment){
		inversionCount = inversionCount + increment;
		System.out.println("inversionCount : " + inversionCount);
	}
}

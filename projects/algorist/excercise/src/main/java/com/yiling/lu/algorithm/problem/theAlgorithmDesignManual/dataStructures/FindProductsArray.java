package com.yiling.lu.algorithm.problem.theAlgorithmDesignManual.dataStructures;

/**
 * 3-28. You have an unordered array X of n integers. Find the array M
 * containing n elements where Mi is the product of all integers in X except for
 * Xi. You may not use division. You can use extra memory. (Hint: There are
 * solutions faster than O(n2).)
 * 
 * @author yilingfamily
 * 
 */
public class FindProductsArray {

	/**
	 * This method was based on a wrong understanding of the problem.
	 * For strange reason, my brain got on the track of understanding the problem
	 * as "where Mi is the product of all integers in X whose index is strictly less than i."
	 * How on earth did I get to this understanding? I kick myself!!!
	 * 
	 * @param x
	 * @return
	 */
	public static int[] findProductsArray(int[] x){
		if(x == null) 
			return null;
		
		int[] m = new int[x.length];
		
		if(x.length == 0){
			return m;
		}else if(x.length > 0){
			m[0] = 0;
			
			if(x.length > 1){
				m[1] = x[0];
			}
			
			if(x.length > 2){
				for(int k=2; k< x.length; k++){
					m[k] = x[k-1]*m[k-1];
				}				
			}
		}
		
		return m;
	}
	
	/**
	 * What should M contains when there is only one element in the array? 
	 * As one option, we defined the result as an one element array contains 
	 * value 0;
	 * 
	 * @param a
	 * @return
	 */
	public static int[] findProdArray(int[] a){
		if(a == null || a.length == 0){
			return a;
		}else if(a.length == 1){
			return new int[]{0};
		}else{
			int[] prefix = new int[a.length];
			int[] suffix = new int[a.length];
			int[] m = new int[a.length];
			
			int prod = 1;
			for(int i=0; i<a.length; i++){
				prod = prod*a[i];
				prefix[i] = prod;
			}
			
			prod = 1;
			
			for(int k=a.length-1; k>=0; k--){
				prod = a[k]*prod;
				suffix[k] = prod;
				
				int pre = 1;
				int suf = 1;
				
				if(k+1 < a.length){
					suf = suffix[k+1];
				}
				
				if(k-1 >=0){
					pre = prefix[k-1];
				}
				
				// m[k] = suffix[k+1] * prefix[k-1];
				m[k] = pre*suf;
			}
			
			return m;
		}
	}
	
}

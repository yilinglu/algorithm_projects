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
	
}

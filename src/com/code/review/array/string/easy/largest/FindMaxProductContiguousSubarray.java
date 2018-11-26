package com.code.review.array.string.easy.largest;

public class FindMaxProductContiguousSubarray {
	/**
	 * 	Find the contiguous subarray within an array (containing at least one number) which has the 
	 *  largest product.
		Return an integer corresponding to the maximum product possible.
		
		Input : [2, 3, -2, 4]
		Return : 6 
		
		Possible with [2, 3]
		
		my approach:
		if no negative number , all elements must produce max product
		Therefore i keep go further, record all elements product as maximum number
		once find current product is smaller than max product, current product =1
		recalculate again 
		
	 */
	public static int findMaxProduct(int A[]) {
		if (null==A || 0==A.length) return 0;
		int max = Integer.MIN_VALUE;   // historic Max
		int maxProd =Integer.MIN_VALUE; // current Max
		int currentProd = 1;
		for (int i =0; i< A.length; i++) {
			currentProd *=A[i];
			max = Math.max(max, maxProd);  // record historic
			if (currentProd>=maxProd) {
				maxProd = currentProd;
				
			} else {
				currentProd = 1;
				maxProd = Integer.MIN_VALUE;
			}
		}
		max = Math.max(max, maxProd);
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {2, 3, -2, 4,2};
		System.out.println(findMaxProduct(A));
		int A2[] = {2, 3, -2, 4, 2, -4, 5,2};
		System.out.println(findMaxProduct(A2));
	}
}

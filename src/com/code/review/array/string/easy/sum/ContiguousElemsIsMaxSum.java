package com.code.review.array.string.easy.sum;

import java.util.ArrayList;
import java.util.List;

public class ContiguousElemsIsMaxSum {
	/**
	 * From Larry He
	 * Given Array with positive and negative integers, find contiguous subarray sum is max
	 * example arr[] = {1,-2,3,10,-4,7,2,1,-5} , maximum sum is {3,10,-4, 7, 2} , sum 18
	 * solution:
	 * set current sum when it is or less than zero , take current element as start element to 
	 * contiguously add to current sum. 
	 * 
	 * comment: this kind of question: there must be negative or 0 element in array,otherwise max 
	 * summary must be sum of all elements
	 * (1) define currSum=0;
	 */
	
	/*
	 *  Passed leetcode
     *  Use Dynamic Programming
     *. dp[n+1] , dp[0]
      * dp[i] = max(dp[i-1]+A[i-1],A[i-1])
      * max = max(dp[i],max)
     */
    public int maxSubArray(int[] A) {
        if (null==A || 0==A.length) return 0;
        int n = A.length;
        int dp[] = new int[n+1];
        // from bottom to up
        dp[0]=0;
        int max = Integer.MIN_VALUE;
        for (int i=1; i<=n; i++) {
            dp[i] = Math.max(dp[i-1]+A[i-1],A[i-1]);  // dp[i] is max (dp[i-1]+A[i-1], A[i-1])
            max = Math.max(max,dp[i]);
        }
        return max;
    }
	
	 public static int ContiguousElemsIsMaxSum(int arr[]) {
		 int currSum=0;
		 
		 int maxSum = Integer.MIN_VALUE;
		 for (int i=0; i< arr.length;i++) {   // i=0 , i=1, i=2
			 if (currSum<=0) {                // i=0 currSum = 0 , i=1 currSum=1, i=2 currSum=-1, i=3 currSum=3, i=4 currSum=13, i=5 currSum=9, i=6 currSum=16
				 currSum = arr[i];            // i=0 currSum = arr[0] = 1, i=2 currSum = 3
			 } else {
				currSum+=arr[i];              // i=1 currSum = -1, i=3 currSum = 3+10=13, i=4 currSum=13-4 =9, i=5 currSum=9+7=16, i=6 currSum=16+2=18
				if (currSum>maxSum) {         // i=1 maxSum = 1 i=3 maxSum=13, i=4 maxsum=16, i=6 maxSum=18
					maxSum = currSum;
				}
			 }			 
		 }
		 return maxSum;
	 }
	 // Return List<Integer>
	 public static List<Integer> ContiguousElemsIsMaxSum2(int arr[]) {
		 int currSum=0;
		 List<Integer> list = new ArrayList<Integer>();
		 List<Integer> result = new ArrayList<Integer>();
		 int maxSum = Integer.MIN_VALUE;
		 for (int i=0; i< arr.length;i++) {
			// System.out.println(currSum+","+arr[i]);
			 if (currSum<=0) {
				 currSum = arr[i];
				 list= new ArrayList<Integer>();
				 list.add(arr[i]);
			 } else {
				currSum+=arr[i]; 
				list.add(arr[i]);
				if (currSum>maxSum) {
					maxSum = currSum;
					result = new ArrayList<Integer>();
					result.addAll(list);
				} 
			 }			 
		 }
		 
		 return result;
	 }
	 // Return List<Integer>
	 public static List<Integer> ContiguousElemsIsMaxSum3(int arr[]) {
		 int currSum=0;
		 List<Integer> list = new ArrayList<Integer>();
		 List<Integer> result = new ArrayList<Integer>();
		 int maxSum = Integer.MIN_VALUE;
		 for (int i=0; i< arr.length;i++) {
			// System.out.println(currSum+","+arr[i]);
			 
				currSum+=arr[i]; 
				list.add(arr[i]);
				if (currSum>maxSum) {
					maxSum = currSum;
					result = new ArrayList<Integer>();
					result.addAll(list);
				}
		 }
		 
		 return result;
	 }
	 public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,-2,3,10,-4,7,2,-5,1}; 
		System.out.println(ContiguousElemsIsMaxSum(arr));
		List<Integer> list = ContiguousElemsIsMaxSum3(arr);
		System.out.println(list.toString());
		
	}

}

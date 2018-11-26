package com.code.review.array.string.easy.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ContiguousElemsIsSum {
/**
 * FaceBook interview question from careerCup.com, I failed the interview because I gave O(N^2) solution SAD!!!
 * Given an array of positive integer and a target of X , find if there exists a contiguous subarray with
 * sum = X
 * 
 * 
 * This is typical brutal force two loop loop we can solve this problem stupid should be O(n)
 * 
 * @param args
 */ 
	/**Wrong result  !!!
	public static boolean contiguousElemsIsSum(int arr[], int target) {
		boolean retVal=false;
		for (int i=0; i<arr.length;i++) {
			int trySum = 0;
			for (int j=i; j< arr.length;j++) {
				trySum += arr[j];
				if (trySum==target) {
					return true;
				}
			}
		}
		return false;
	}
	*/
/**
 *
	Find subarray with given sum | Set 1 (Nonnegative Numbers)
	
	Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number.
	
	Examples:
	
	Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
	Ouptut: Sum found between indexes 2 and 4
	
	Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
	Ouptut: Sum found between indexes 1 and 4
	
	Input: arr[] = {1, 4}, sum = 0
	Output: No subarray found
	
	There may be more than one subarrays with sum as the given sum. The following solutions print first 
	such subarray.
	
	Source: Google Interview Question
 *  	
 */
	 // Wrong result !!!
	public static boolean contiguousSumIsTarget(int A[], int target) {
		if (null==A || 0==A.length) {
			return false;
		}
		
		for (int i=0; i<A.length; i++) {
			int trySum = 0;
			for (int j=i; j< A.length;j++) {
				trySum += A[j];
				if (trySum==target) {
					return true;
				} else if (trySum>target) {
					
					break;
				} 
				 
			}
		}
		return false;
	}
	 
	// Correct result O(n^2)
	public static boolean contiguousSumIsTarget2(int A[], int target) {
		if (null==A || 0==A.length) {
			return false;
		}
	 
		
		int trySum = 0;
	 
		for (int i=0; i<A.length; i++) {
			trySum =0;
			for (int j=i; j< A.length;j++) {
				trySum += A[j];
				 
				if (trySum==target) {
					return true;
				} else if (trySum>target) {
			 		break;					
				}
			}
		}
		return false;
	}
	// method 2 (Efficient) , Facebook dump me because above solution is O(n^2) !!!
	/**
	 * My new Approach O(n)
	 * Initialize a variable curr_sum as first element. curr_sum indicates the sum of current 
	 * subarray. Start from the second element and add all elements one by one to the curr_sum. 
	 * If curr_sum becomes equal to sum, then print the solution. If curr_sum exceeds the sum, 
	 * then remove trailing elemnents while curr_sum is greater than sum.
		Following is the implementation of the above approach.
	 * @param args
	 */
	 
	/**
	 *  my Approach: i-start
	 *  start and i point, calculate sum of element from start to i
	 *  if sum < target, i++ , if sum > target , sum-A[start] , start++
	 *  if sum == target , return true
	 *  
	 *  
	
	*/
	public static boolean contiguousElemIsSum(int A[], int target) {
		if (null==A || 0==A.length) return false;
		int sum =A[0];
		int start = 0;
		for (int i=1; i<A.length;i++) {
			while (sum>target && start<i-1) {
				sum -= A[start];
				start++;
			}
			if (sum == target) {
				return true;
			}
			if (i<A.length) {
				sum+=A[i];
			}
		}
		return false; 
	}
	/**
	 * (1) sum=A[0], start=0; list<Integer> result;
	 * (2) i=1 to A.length loop
	 * (3) modify sum, while(sum>target && start<i-1)) { sum-=A[start];  start++ 
	 * (4) check if sum==target ,j=start to i loop result.add(A[j]) return result;
	 * (5) check if i<A.length ; sum+=A[i] ; list.add(A[i])
	 * 
	 * 
	 * @param A
	 * @param target
	 * @return
	 */
	public static int[] contiguousElemIsSumReturnArray(final int A[], int target) {
		if (null==A || A.length==0) return null;
		int sum=A[0];
		
		int start=0;
		List<Integer> result= new ArrayList<Integer>();
		 
		for (int i=1;i<A.length;i++) {
			while(sum>target && start<i-1) {
				sum-=A[start];
				 
				start++;
			}
			if (sum==target) {
				 
				return Arrays.copyOfRange(A,start,i);
			}
			if (i<A.length) {
				sum+=A[i];
				
			}
		}
		return null; 
	}
	
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,1,5,16,13,7,9,10,33};
		int x = 8;
		 
		x=8;
		System.out.println("x="+x+", result:"+contiguousElemIsSum(arr, x));
		
		x=9;
		System.out.println("x="+x+", result:"+contiguousElemIsSum(arr, x));
		x=29;
		System.out.println("x="+x+", result:"+contiguousElemIsSum(arr, x));
		x=21;
		System.out.println("x="+x+", result:"+contiguousElemIsSum(arr, x));
		
		x=26;
		System.out.println("x="+x+", result:"+contiguousElemIsSum(arr, x));
		
		x=43;
		System.out.println("x="+x+", result:"+contiguousElemIsSum(arr, x));
		
		x=45;
		System.out.println("x="+x+", result:"+contiguousElemIsSum(arr, x));
		
	 	Integer A[]= {45,43,9,26,29};
		 
	    System.out.println(Arrays.toString(contiguousElemIsSumReturnArray(arr, x)));
		 
		 
	}

}

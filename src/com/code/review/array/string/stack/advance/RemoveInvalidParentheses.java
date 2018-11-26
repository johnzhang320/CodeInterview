package com.code.review.array.string.stack.advance;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveInvalidParentheses {
	/**
	 *  ZhangYunKe tell Facebook phone interview question
	 *  
	 *  One String contains parentheses "(" and ")" , remove illegal one make one legal parentheses, O(n)
	 *  
	 *  input: "()())()"
		Output: "()()()"
		
		(a)())()
		Output
		(a)()()
		
		))(())()(()(((((((
		
		output
		(())()()
	 *  
	 *  Analysis
	 *  make stack record "(" index and if stack is empty and ch==")" , list.add(i)
	 *  if ch=="(" unconditionally stack.push(i); 
	 *  if (stack is not empty and ch==")", stack.pop()
	 *  when loop finish , loop list, A[i] = " " and loop stack A[i]=" "
	 *  O(n) , one n pass and one k pass, k only present number of extra "("s  
	 */
	public static String deletedInvalidChars(char A[]) {
		if (null==A || A.length==0) return null;
		Stack<Integer> stack = new Stack<Integer>();
		char ch;
		for (int i=0; i<A.length;i++) {
			ch = A[i];
			if (stack.isEmpty() && ch==')') {
				A[i]=' ';  // save index mean A[index] will be deleted
				continue;
			}
			if (ch=='(')  stack.push(i);
			if (!stack.empty() && ch==')') {
				stack.pop();
			}
		}
		while (!stack.empty()) {
			int i=stack.pop();
			A[i]=' ';
		}
		String result = new String(A).replace(" ", "");
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str=")))(((adc))()(()))))(((((((";
		System.out.println("Result="+deletedInvalidChars(str.toCharArray()));
	}
}

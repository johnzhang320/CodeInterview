package com.code.review.binary.search.tree.path.sum;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;

/**
 *  yahoo-interview-questions

		
		Find the deepest node in a binary tree:
		
		Example:
		
		  A
		/   \
		B    C
	   / \  / \
	   D E  F G
		\
		 H

		Return Node ‘H’
 *    My Approach:
 *    1. Create Node which has character val, Node left and Node right
 *    2. This is not Binary Search Tree, no rule about left child < parent and right child > parent
 *    3. Using stack to DFS search each leaf node
 */


public class FindDeepestNodeInBinaryTree extends TestCase {
	class Node {
		char data;
		Node left;
		Node right;
		public Node(char data) {
			this.data = data;
			left=null;
			right=null;
		}
		public void connect(Node left, Node right) {
			this.left = left;
			this.right = right;
		}
	}
	FindDeepestNodeInBinaryTree bst;
	
	public Node A=new Node('A');
	public Node B=new Node('B');
	public Node C=new Node('C');
	public Node D=new Node('D');
	public Node E=new Node('E');
	public Node F=new Node('F');
	public Node G=new Node('G');
	public Node H=new Node('H');
	public Node I=new Node('I');
	
	/**
	 * 	  A
		/   \
		B    C
	   / \  / \
	   D E  F G
		\
		 H
        /
       I
	 */
	public void setUp() {
		A.connect(B, C);
		B.connect(D, E);
		D.connect(null, H);
		H.connect(I, null);
		C.connect(F, G);
		bst = new FindDeepestNodeInBinaryTree();
	}

 
	public Node FindDeepestNodeInBinaryTree(Node root) {
		 
		if (null == root) return null;
		ArrayList<Node> curList = new ArrayList<Node>();
		ArrayList<Node> result = new ArrayList<Node>(); 
		dfs(root,curList,result);
		System.out.println("\nresult.size()="+result.size());
		
		Node maxNode = result.get(result.size()-1); 
		System.out.println("\nMax Node:"+	maxNode.data+", depth is "+result.size());
		return result.get(result.size());
	
	}
	private void dfs(Node t, ArrayList<Node> curList,ArrayList<Node> result) {
		
		// t from root to bottom
		curList.add(t);
		
		if (t.left==null && t.right==null) {
			
				
			System.out.println("");
			if (curList.size()>result.size()) {			 
				result = new ArrayList(curList);	
				System.out.print("Root to leaf Max path:");
				result.forEach((n)->System.out.print(n.data+" "));
			} else {
				System.out.print("Root to leaf path:");
				curList.forEach((n)->System.out.print(n.data+" "));		
			}
			curList = new ArrayList<Node>();
			return;
		}
		if (t.left!=null) {			
			dfs(t.left,curList,result);
			curList.remove(curList.size()-1);
		}
		if (t.right!=null) {
			 
			dfs(t.right,curList,result);
			curList.remove(curList.size()-1);
		}
	}
	@Test
	public void testLongestConsecutive() {
		System.out.println("FindDeepestNodeInBinaryTree()");
	 
		Node deepNode = bst.FindDeepestNodeInBinaryTree(A);
	    System.out.println("result deepest node is "+deepNode.data);
		 
	}
}

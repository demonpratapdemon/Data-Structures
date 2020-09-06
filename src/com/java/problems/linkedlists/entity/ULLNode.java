/**
 * 
 */
package com.java.problems.linkedlists.entity;

/**
 * @author PRATAP
 *
 */
public class ULLNode {

	public ULLNode next;
	
	public int numElements;
	
	public int array[];

	public ULLNode(int n) {
		next = null;
		numElements = 0;
		array = new int[n];
	}
}

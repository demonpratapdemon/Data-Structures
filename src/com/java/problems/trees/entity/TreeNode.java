/**
 * 
 */
package com.java.problems.trees.entity;

/**
 * @author PRATAP
 *
 */
public class TreeNode {

	public int key;
	public TreeNode left, right;
	
	public TreeNode() {
		left = right = null;
	}

	public TreeNode(int value) {
		this.key = value;
		left = right = null;
	}
}

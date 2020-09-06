package com.java.problems.trees.util;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.java.problems.trees.entity.TreeNode;

/**
 * @author PRATAP
 *
 */
public class TraversalUtil {

	public static void preOrderTraversal(TreeNode treeNode) {
		// TODO Auto-generated method stub
		if (treeNode == null) {
			return;
		}
		System.out.print(treeNode.key + " ");
		preOrderTraversal(treeNode.left);
		preOrderTraversal(treeNode.right);
	}

	public static void inOrderTraversal(TreeNode treeNode) {
		// TODO Auto-generated method stub
		if (treeNode == null)
			return;
		inOrderTraversal(treeNode.left);
		System.out.print(treeNode.key + " ");
		inOrderTraversal(treeNode.right);

	}

	public static void postOrderTraversal(TreeNode treeNode) {
		// TODO Auto-generated method stub
		if (treeNode == null)
			return;
		postOrderTraversal(treeNode.left);
		postOrderTraversal(treeNode.right);
		System.out.print(treeNode.key + " ");
	}

	public static void levelOrderTraversal(TreeNode treeNode) {
		if (treeNode == null)
			return;
		Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
		Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
		TreeNode temp = treeNode;
		queue1.add(temp);
		while (!queue1.isEmpty()) {
			Iterator<TreeNode> iterator = queue1.iterator();
			while (iterator.hasNext()) {
				temp = iterator.next();
				if (temp.left != null)
					queue2.add(temp.left);
				if (temp.right != null)
					queue2.add(temp.right);
				System.out.print(temp.key + " ");
			}
			System.out.println();
			while (!queue1.isEmpty()) {
				queue1.remove();
			}
			while (!queue2.isEmpty()) {
				queue1.add(queue2.remove());
			}
		}
	}

	public static void levelOrderTraversalInReverse(TreeNode treeNode) { // if right to left is pushed in stack then the
																			// order will be from left to right
		// TODO Auto-generated method stub
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		queue.add(treeNode);
		while (!queue.isEmpty()) {
			if (queue.peek().right != null)
				queue.add(queue.peek().right);
			if (queue.peek().left != null)
				queue.add(queue.peek().left);
			stack.push(queue.remove());
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop().key);
			if (!stack.isEmpty())
				System.out.print(" ");
		}
	}

}

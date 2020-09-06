/**
 * 
 */
package com.java.problems.trees.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import com.java.problems.trees.entity.TreeNode;

/**
 * @author PRATAP
 *
 */
public class TreeUtil {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static TreeNode insertLevelOrder(TreeNode root, Integer[] arr, int index) {
		// TODO Auto-generated method stub
		if (index < arr.length && arr[index] != null) { // index is used to track which array value should go to which
														// subtree
			TreeNode temp = new TreeNode(arr[index]);
			root = temp;
			// insert left child
			temp.left = insertLevelOrder(temp.left, arr, 2 * index + 1);

			// insert right child
			temp.right = insertLevelOrder(temp.right, arr, 2 * index + 2);
		}
		return root;
	}

	public static Integer findMaxNode(TreeNode treeNode) {
		// TODO Auto-generated method stub
		if (treeNode == null)
			return null;
		else if (treeNode.left == null && treeNode.right == null)
			return treeNode.key;
		else {
			Integer max = max(findMaxNode(treeNode.left), findMaxNode(treeNode.right));
			return (treeNode.key > max) ? treeNode.key : max;
		}
	}

	private static Integer max(Integer data1, Integer data2) {
		// TODO Auto-generated method stub
		return (data1 > data2) ? data1 : data2;
	}

	public static boolean searchElement(TreeNode treeNode, Integer data) {
		// TODO Auto-generated method stub
		if (data == null || treeNode == null)
			return false;
		if (treeNode.key == data)
			return true;
		else {
			boolean left = searchElement(treeNode.left, data);
			boolean right = false;
			if (!left)
				right = searchElement(treeNode.right, data);
			if (left || right)
				return true;
			return false;
		}
	}

	public static TreeNode insertNode(TreeNode treeNode, int data) {
		// TODO Auto-generated method stub
		if (treeNode == null) {
			return new TreeNode(data);
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(treeNode);
		while (!queue.isEmpty()) {
			if (queue.peek().left == null) {
				queue.peek().left = new TreeNode(data);
				break;
			} else if (queue.peek().right == null) {
				queue.peek().right = new TreeNode(data);
				break;
			} else {
				queue.add(queue.peek().left);
				queue.add(queue.peek().right);
				queue.remove();
			}
		}
		return treeNode;
	}

	public static int sizeOfBinaryTree(TreeNode treeNode) {
		// TODO Auto-generated method stub
		if (treeNode == null)
			return 0;
		if (treeNode.left == null && treeNode.right == null) {
			return 1;
		} else {
			return (1 + sizeOfBinaryTree(treeNode.left) + sizeOfBinaryTree(treeNode.right));
		}

	}

	public static int findHeight(TreeNode treeNode) {
		// TODO Auto-generated method stub
		if (treeNode == null)
			return 0;
		return 1 + max(findHeight(treeNode.left), findHeight(treeNode.right));
	}

	public static TreeNode deleteNode(TreeNode treeNode, int deleteData) {
		// TODO Auto-generated method stub
		if (treeNode == null) {
			System.out.println("There are no nodes to be deleted. First create a Binary Tree");
			return treeNode;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(treeNode);
		TreeNode deepestNode = findDeepestNode(treeNode);
		while (!queue.isEmpty()) {
			if (queue.peek().key == deleteData) {
				TreeNode temp = queue.peek();
				queue.peek().key = deepestNode.key;
				deepestNode.key = temp.key;
				break;
			}
			if (queue.peek().left != null)
				queue.add(queue.peek().left);
			if (queue.peek().right != null)
				queue.add(queue.peek().right);
			queue.remove();
		}
		if (treeNode == deepestNode)
			return null;
		queue.add(treeNode);
		while (!queue.isEmpty()) {
			if (queue.peek().left == deepestNode) {
				queue.peek().left = null;
				break;
			} else if (queue.peek().right == deepestNode) {
				queue.peek().right = null;
				break;
			}
			if (queue.peek().left != null)
				queue.add(queue.peek().left);
			if (queue.peek().right != null)
				queue.add(queue.peek().right);
			queue.remove();
		}
		return treeNode;
	}

	public static int noOfLeaves(TreeNode treeNode) {
		// TODO Auto-generated method stub
		if (treeNode == null)
			return 0;
		if (treeNode.left == null && treeNode.right == null)
			return 1;
		else
			return noOfLeaves(treeNode.left) + noOfLeaves(treeNode.right);
	}

	public static TreeNode findDeepestNode(TreeNode treeNode) {
		// TODO Auto-generated method stub

		if (treeNode == null)
			return treeNode;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(treeNode);
		TreeNode temp = null;
		while (!queue.isEmpty()) {
			if (queue.peek().left != null)
				queue.add(queue.peek().left);
			if (queue.peek().right != null)
				queue.add(queue.peek().right);
			temp = queue.remove();
		}
		return temp;
	}

	public static int noOfFullNodes(TreeNode treeNode) {
		// TODO Auto-generated method stub
		if (treeNode == null)
			return 0;
		if (treeNode.left != null && treeNode.right != null)
			return 1 + noOfFullNodes(treeNode.left) + noOfFullNodes(treeNode.right);
		else
			return noOfFullNodes(treeNode.left) + noOfFullNodes(treeNode.right);
	}

	public static int noOfHalfNodes(TreeNode treeNode) {
		// TODO Auto-generated method stub
		if (treeNode == null)
			return 0;
		if ((treeNode.left == null && treeNode.right != null) || (treeNode.left != null && treeNode.right == null))
			return 1 + noOfHalfNodes(treeNode.left) + noOfHalfNodes(treeNode.right);
		else
			return noOfHalfNodes(treeNode.left) + noOfHalfNodes(treeNode.right);
	}

	public static int findDiameter(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null)
			return 0;
		int lheight = findHeight(root.left);
		int rheight = findHeight(root.right);
		int ldiameter = findDiameter(root.left);
		int rdiameter = findDiameter(root.right);
		return max(lheight + rheight + 1, max(ldiameter, rdiameter));
	}

	public static String findMaximumSumLevel(TreeNode treeNode) {
		// TODO Auto-generated method stub
		if (treeNode == null)
			return "The tree is empty. Create a tree first";
		int maxmSum = 0, level = 0, maxLevel = 0, currentSum = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(treeNode);
		queue.add(null); // 1 null 2 3 null 4 5 6 7 null ---> here null acts as a separator for level
							// wise addition
		while (!queue.isEmpty()) {
			TreeNode temp = queue.remove();
			if (temp == null) {
				if (currentSum > maxmSum) {
					maxmSum = currentSum;
					maxLevel = level;
				}
				currentSum = 0;
				level++;
				if (!queue.isEmpty())
					queue.add(null);
			} else {
				currentSum += temp.key;
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
			}
		}
		System.out.println("Maximum sum is : " + maxmSum);
		return String.valueOf(maxLevel);
	}

	public static void pathsFromRootToLeaf(TreeNode treeNode, String path) {
		// TODO Auto-generated method stub
		if (treeNode == null)
			return;
		if (treeNode.left == null && treeNode.right == null)
			System.out.println(path + treeNode.key);
		else {
			path += treeNode.key + "->";
			pathsFromRootToLeaf(treeNode.left, path);
			pathsFromRootToLeaf(treeNode.right, path);
		}
	}

	public static TreeNode createMirrorTree(TreeNode treeNode) {
		// TODO Auto-generated method stub
		if (treeNode != null) {
			createMirrorTree(treeNode.left);
			createMirrorTree(treeNode.right);
			TreeNode temp = treeNode.left;
			treeNode.left = treeNode.right;
			treeNode.right = temp;
		}
		return treeNode;
	}

	public static TreeNode findLowestCommonAncestor(TreeNode root, TreeNode first, TreeNode second) {
		// TODO Auto-generated method stub
		if (root == null) // if root is null return null
			return root;
		if (root.key == first.key || root.key == second.key) // this is for the searching of the node between first or
																// second. Whichever is matched is returned
			return root;
		TreeNode left = findLowestCommonAncestor(root.left, first, second); // for searching the nodes
		TreeNode right = findLowestCommonAncestor(root.right, first, second);// for searching the nodes
		if (left != null && right != null) // if returned from both left and right are not null, then the current root
											// is the LCA
			return root;
		else
			return (left != null) ? left : right; // if one of the left or right is not null then return that node which
													// indicates we have found the one node
	}

}

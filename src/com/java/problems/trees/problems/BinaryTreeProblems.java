/**
 * 
 */
package com.java.problems.trees.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.java.problems.trees.entity.TreeNode;
import com.java.problems.trees.util.TraversalUtil;
import com.java.problems.trees.util.TreeUtil;

/**
 * @author PRATAP
 *
 */
public class BinaryTreeProblems {

	/**
	 * @param args
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Welcome to Tree Traversal");
		TreeNode treeNode = null;
		TreeNode mirrorTree = null;
		try (Scanner scan = new Scanner(System.in)) {
			do {
				System.out.println("1. Create a Binary Tree");
				System.out.println("2. Preorder traversal");
				System.out.println("3. Inorder traversal");
				System.out.println("4. Postorder traversal");
				System.out.println("5. Levelorder traversal");
				System.out.println("6. Find maximum element");
				System.out.println("7. Search an element");
				System.out.println("8. Insert an element");
				System.out.println("9. Calculate size of the Binary Tree");
				System.out.println("10. Print level order traversal in reverse");
				System.out.println("11. Find Height of the Binary Tree");
				System.out.println("12. Find the deepest node of the Binary Tree");
				System.out.println("13. No of leaves the Binary Tree");
				System.out.println("14. Delete a node from the Binary Tree");
				System.out.println("15. Full Nodes in the Binary Tree");
				System.out.println("16. Half Nodes in the Binary Tree");
				System.out.println("17. Find Diameter of the Binary Tree");
				System.out.println("18. Level of the Binary Tree with maximum sum");
				System.out.println("19. Print all the root-to-leaf paths in the Binary Tree");
				System.out.println("20. Create a mirror tree of the Binary Tree");
				System.out.println("21. Lowest Common Ancestor of two nodes of the Binary Tree");
				System.out.print("Enter your choice : ");
				int choice = Integer.parseInt(br.readLine());
				switch (choice) {
				case 1: {
					System.out.println("Put double space when no node is there. (n+1) spaces for 'n' no of null nodes");
					System.out.println("Enter the nodes : ");
					String[] nodesList = br.readLine().split(" ");
					Integer[] arr = new Integer[nodesList.length];
					for (int i = 0; i < nodesList.length; i++) {
						if (nodesList[i] != null && !nodesList[i].equalsIgnoreCase("")) {
							arr[i] = Integer.parseInt(nodesList[i]);
						} else {
							arr[i] = null;
						}
					}
					treeNode = TreeUtil.insertLevelOrder(treeNode, arr, 0);
					break;
				}
				case 2: {
					System.out.print("Nodes in preorder traversal is : ");
					TraversalUtil.preOrderTraversal(treeNode);
					System.out.println();
					break;
				}
				case 3: {
					System.out.print("Nodes in inorder traversal is : ");
					TraversalUtil.inOrderTraversal(treeNode);
					System.out.println();
					break;
				}
				case 4: {
					System.out.print("Nodes in postorder traversal is : ");
					TraversalUtil.postOrderTraversal(treeNode);
					System.out.println();
					break;
				}
				case 5: {
					System.out.println("Nodes in levelorder traversal is : ");
					TraversalUtil.levelOrderTraversal(treeNode);
					break;
				}
				case 6: {
					System.out.println("Maximum element in the tree is : " + TreeUtil.findMaxNode(treeNode));
					break;
				}
				case 7: {
					System.out.println("Enter the node value to be searched : ");
					System.out.println("Is the element present? : "
							+ TreeUtil.searchElement(treeNode, Integer.parseInt(br.readLine())));
					break;
				}
				case 8: {
					System.out.println("Enter the node value to be inserted : ");
					treeNode = TreeUtil.insertNode(treeNode, Integer.parseInt(br.readLine()));
					break;
				}
				case 9: {
					System.out.println("Size of the Binary tree is : " + TreeUtil.sizeOfBinaryTree(treeNode));
					break;
				}
				case 10: {
					System.out.println("Level order traversal in reverse : ");
					TraversalUtil.levelOrderTraversalInReverse(treeNode);
					System.out.println();
					break;
				}
				case 11: {
					System.out.println("Height of the tree is : " + TreeUtil.findHeight(treeNode));
					break;
				}
				case 12: {
					System.out.println(
							"Deepest node value of the Binary tree is : " + TreeUtil.findDeepestNode(treeNode).key);
					break;
				}
				case 13: {
					System.out.println("No of leaves in the Binary Tree : " + TreeUtil.noOfLeaves(treeNode));
					break;
				}
				case 14: {
					System.out.print("Enter the node value to be deleted : ");
					treeNode = TreeUtil.deleteNode(treeNode, Integer.parseInt(br.readLine()));
					System.out.println("Deletion is successful");
					break;
				}
				case 15: {
					System.out.println("No of full nodes in the Binary tree is : " + TreeUtil.noOfFullNodes(treeNode));
					break;
				}
				case 16: {
					System.out.println("No of half nodes in the Binary tree is : " + TreeUtil.noOfHalfNodes(treeNode));
					break;
				}
				case 17: {
					System.out.println("Diameter of the Binary Tree is : " + TreeUtil.findDiameter(treeNode));
					break;
				}
				case 18: {
					System.out.println("Level with the maximum sum is : " + TreeUtil.findMaximumSumLevel(treeNode));
					break;
				}
				case 19: {
					System.out.println("The paths from root to leaf are as follows : ");
					TreeUtil.pathsFromRootToLeaf(treeNode, "");
					break;
				}
				case 20: {
					mirrorTree = TreeUtil.createMirrorTree(treeNode);
					System.out.println("Mirror tree is successfully created");
					break;
				}
				case 21: {
					System.out.print("Enter the 2 nodes value to find their LCA : ");
					TreeNode ancestor = TreeUtil.findLowestCommonAncestor(treeNode, new TreeNode(scan.nextInt()),
							new TreeNode(scan.nextInt()));
					System.out.println("The LCA is : " + ancestor.key);
					break;
				}
				default:
					System.exit(0);
				}
			} while (true);
		}

	}

}

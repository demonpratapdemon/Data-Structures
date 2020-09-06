/**
 * 
 */
package com.java.problems.linkedlists.util;

import com.java.problems.linkedlists.entity.SingleLinkedListNode;

/**
 * @author PRATAP
 *
 */
public class LinkedListsUtil {

	public static void printNodes(SingleLinkedListNode singleLinkedListNode) {
		// TODO Auto-generated method stub
		if (singleLinkedListNode == null) {
			System.out.println("No nodes in the list");
		} else {
			System.out.print("The nodes in the linked list are as follows : ");
			while (singleLinkedListNode != null) {
				System.out.print(singleLinkedListNode.getData() + " ");
				singleLinkedListNode = singleLinkedListNode.getNextNode();
			}
			System.out.println();
		}
	}

	public static int countNoOfNodes(SingleLinkedListNode singleLinkedListNode) {
		// TODO Auto-generated method stub
		if (singleLinkedListNode == null)
			return 0;
		else {
			int count = 1;
			while (singleLinkedListNode.getNextNode() != null) {
				count++;
				singleLinkedListNode = singleLinkedListNode.getNextNode();
			}
			return count;
		}

	}

	public static SingleLinkedListNode insertAtBeginning(SingleLinkedListNode singleLinkedListNode, int data) {
		// TODO Auto-generated method stub
		if (singleLinkedListNode == null) {
			singleLinkedListNode = new SingleLinkedListNode();
			singleLinkedListNode.setData(data);
			singleLinkedListNode.setNextNode(null);
		} else {
			SingleLinkedListNode newNode = new SingleLinkedListNode();
			newNode.setData(data);
			newNode.setNextNode(singleLinkedListNode);
			singleLinkedListNode = newNode;
		}
		return singleLinkedListNode;
	}

	public static SingleLinkedListNode insertAtMiddle(SingleLinkedListNode singleLinkedListNode, int position,
			int newData) {
		// TODO Auto-generated method stub
		if (position == 1)
			singleLinkedListNode = insertAtBeginning(singleLinkedListNode, newData);
		else if (position == LinkedListsUtil.countNoOfNodes(singleLinkedListNode) + 1)
			singleLinkedListNode = insertAtEnd(singleLinkedListNode, newData);
		else {
			SingleLinkedListNode newNode = new SingleLinkedListNode();
			newNode.setData(newData);
			int count = 1;
			SingleLinkedListNode modifiedNode = singleLinkedListNode;
			while (modifiedNode != null && count++ != position - 1) {
				modifiedNode = modifiedNode.getNextNode();
			}
			newNode.setNextNode(modifiedNode.getNextNode());
			modifiedNode.setNextNode(newNode);
		}
		return singleLinkedListNode;
	}

	public static SingleLinkedListNode insertAtEnd(SingleLinkedListNode singleLinkedListNode, int data) {
		// TODO Auto-generated method stub
		if (singleLinkedListNode == null) {
			singleLinkedListNode = new SingleLinkedListNode();
			singleLinkedListNode.setData(data);
			singleLinkedListNode.setNextNode(null);
		} else {
			SingleLinkedListNode newNode = new SingleLinkedListNode();
			newNode.setData(data);
			newNode.setNextNode(null);
			SingleLinkedListNode checkNode = singleLinkedListNode;
			while (checkNode.getNextNode() != null) {
				checkNode = checkNode.getNextNode();
			}
			checkNode.setNextNode(newNode);
		}
		return singleLinkedListNode;
	}

	public static SingleLinkedListNode deleteNode(SingleLinkedListNode singleLinkedListNode, int position) {

		if (singleLinkedListNode == null || position == 0) {
			System.out.println("Linked list is either empty or position is invalid");
			return singleLinkedListNode;
		}
		if (position > LinkedListsUtil.countNoOfNodes(singleLinkedListNode)) {
			System.out.println("Position entered is greater than the no of nodes");
			return singleLinkedListNode;
		}
		if (position == 1) {
			singleLinkedListNode = singleLinkedListNode.getNextNode();
			return singleLinkedListNode;
		}
		SingleLinkedListNode temp = singleLinkedListNode;
		while (temp != null && position - 1 != 1) {
			temp = temp.getNextNode();
			position--;
		}
		temp.setNextNode(temp.getNextNode().getNextNode());
		return singleLinkedListNode;
	}

	public static SingleLinkedListNode reverseLinkedListIteratively(SingleLinkedListNode singleLinkedListNode) {
		// TODO Auto-generated method stub
		if (singleLinkedListNode == null)
			return null;
		if (singleLinkedListNode.getNextNode() == null)
			return singleLinkedListNode;
		else {
			SingleLinkedListNode temp = null, nextNode = null;
			while (singleLinkedListNode != null) {
				nextNode = singleLinkedListNode.getNextNode();
				singleLinkedListNode.setNextNode(temp);
				temp = singleLinkedListNode;
				singleLinkedListNode = nextNode;
			}
			return temp;
		}

	}

	public static SingleLinkedListNode reverseLinkedListRecursively(SingleLinkedListNode singleLinkedListNode) {
		// TODO Auto-generated method stub
		if (singleLinkedListNode == null || singleLinkedListNode.getNextNode() == null) {
			return singleLinkedListNode;
		} else {
			SingleLinkedListNode temp = null;
			temp = singleLinkedListNode;
			singleLinkedListNode = singleLinkedListNode.getNextNode();
			singleLinkedListNode = reverseLinkedListRecursively(singleLinkedListNode);
			temp.setNextNode(null);
			SingleLinkedListNode reverse = singleLinkedListNode;
			while (reverse.getNextNode() != null)
				reverse = reverse.getNextNode();
			reverse.setNextNode(temp);
		}
		return singleLinkedListNode;
	}

	public static void printInReverse(SingleLinkedListNode singleLinkedListNode) {
		// TODO Auto-generated method stub
		if (singleLinkedListNode == null) {
			return;
		} else {
			printInReverse(singleLinkedListNode.getNextNode());
			System.out.print(singleLinkedListNode.getData() + " ");
		}
	}

	public static SingleLinkedListNode reverseInPairs(SingleLinkedListNode singleLinkedListNode) {
		// TODO Auto-generated method stub
		if (singleLinkedListNode == null || singleLinkedListNode.getNextNode() == null)
			return singleLinkedListNode;
		else {
			SingleLinkedListNode temp = singleLinkedListNode.getNextNode();
			singleLinkedListNode.setNextNode(temp.getNextNode());
			temp.setNextNode(singleLinkedListNode);
			singleLinkedListNode = temp;
			singleLinkedListNode.getNextNode()
					.setNextNode(reverseInPairs(singleLinkedListNode.getNextNode().getNextNode()));
		}
		return singleLinkedListNode;
	}
}

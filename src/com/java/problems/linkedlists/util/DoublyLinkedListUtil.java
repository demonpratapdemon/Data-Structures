/**
 * 
 */
package com.java.problems.linkedlists.util;

import com.java.problems.linkedlists.entity.DoubleLinkedListNode;

/**
 * @author PRATAP
 *
 */
public class DoublyLinkedListUtil {

	public static DoubleLinkedListNode insertAtBeginning(DoubleLinkedListNode node, int data) {
		// TODO Auto-generated method stub
		DoubleLinkedListNode newNode = new DoubleLinkedListNode();
		if (node == null) {
			newNode.setData(data);
			newNode.setPrevNode(null);
			newNode.setNextNode(null);
			node = newNode;
		} else {
			newNode.setData(data);
			newNode.setNextNode(node);
			newNode.setPrevNode(null);
			newNode.getNextNode().setPrevNode(newNode);
			node = newNode;
		}
		return node;
	}

	public static void printNodes(DoubleLinkedListNode node) {
		// TODO Auto-generated method stub
		if (node == null) {
			System.out.print("No nodes are present in the doubly linked list");
			System.out.println();
			return;
		} else {
			System.out.print("Nodes present in the list : ");
			while (node != null) {
				System.out.print(node.getData() + " ");
				node = node.getNextNode();
			}
			System.out.println();
		}

	}

	public static DoubleLinkedListNode insertAtEnd(DoubleLinkedListNode node, int data) {
		// TODO Auto-generated method stub
		DoubleLinkedListNode newNode = new DoubleLinkedListNode();
		if (node == null) {
			newNode.setData(data);
			;
			newNode.setNextNode(null);
			newNode.setPrevNode(null);
			node = newNode;
		} else {
			DoubleLinkedListNode temp = node;
			while (temp.getNextNode() != null) {
				temp = temp.getNextNode();
			}
			newNode.setData(data);
			newNode.setNextNode(null);
			newNode.setPrevNode(temp);
			temp.setNextNode(newNode);
		}
		return node;
	}

	public static DoubleLinkedListNode insertAtMiddle(DoubleLinkedListNode node, int position, int data) {
		// TODO Auto-generated method stub
		if (position == 0) {
			System.out.println("Enter a valid position");
			return node;
		}
		if (position == 1) {
			return DoublyLinkedListUtil.insertAtBeginning(node, data);
		}
		if (position == DoublyLinkedListUtil.countNodes(node) + 1) {
			return DoublyLinkedListUtil.insertAtEnd(node, data);
		}
		if (position > DoublyLinkedListUtil.countNodes(node) + 1) {
			System.out.println("Position is greater than the no of nodes");
			return node;
		}
		DoubleLinkedListNode newNode = new DoubleLinkedListNode();
		DoubleLinkedListNode temp = node;
		while (temp != null && position - 1 > 1) {
			temp = temp.getNextNode();
			position--;
		}
		newNode.setData(data);
		newNode.setNextNode(temp.getNextNode());
		temp.getNextNode().setPrevNode(newNode);
		temp.setNextNode(newNode);
		newNode.setPrevNode(temp);
		return node;
	}

	public static int countNodes(DoubleLinkedListNode node) {
		// TODO Auto-generated method stub
		int count = 0;
		if (node == null) {
			System.out.println("No nodes present in the Doubly Linked List");
			return 0;
		} else {
			DoubleLinkedListNode temp = node;
			while (temp != null) {
				count++;
				temp = temp.getNextNode();
			}
			return count;
		}

	}

	public static DoubleLinkedListNode deleteBeginningNode(DoubleLinkedListNode node) {
		// TODO Auto-generated method stub
		if (node == null) {
			System.out.println("There are no nodes to be deleted");
			return null;
		}
		if (node.getNextNode() != null)
			node.getNextNode().setPrevNode(null);
		node = node.getNextNode();
		return node;
	}

	public static DoubleLinkedListNode deleteEndNode(DoubleLinkedListNode node) {
		// TODO Auto-generated method stub
		if (node == null) {
			System.out.println("There are no nodes in the Doubly Linked list");
			return null;
		}
		if (node.getNextNode() == null)
			return null;
		DoubleLinkedListNode temp = node;
		while (temp.getNextNode() != null)
			temp = temp.getNextNode();
		temp.getPrevNode().setNextNode(null);
		temp.setPrevNode(null);
		return node;
	}

	public static DoubleLinkedListNode deleteInterMediateNode(DoubleLinkedListNode node, int position) {
		// TODO Auto-generated method stub
		if (node == null) {
			System.out.println("There are no nodes in the Doubly Linked list");
			return null;
		}
		if (position > DoublyLinkedListUtil.countNodes(node)) {
			System.out.println("Enter a valid position of the node to be deleted");
			return node;
		}
		if (position == 1) {
			return DoublyLinkedListUtil.deleteBeginningNode(node);
		}
		if (position == DoublyLinkedListUtil.countNodes(node))
			return DoublyLinkedListUtil.deleteEndNode(node);
		DoubleLinkedListNode temp = node;
		while (temp != null && position != 1) {
			temp = temp.getNextNode();
			position--;
		}
		temp.getPrevNode().setNextNode(temp.getNextNode());
		temp.getNextNode().setPrevNode(temp.getPrevNode());
		temp.setNextNode(null);
		temp.setPrevNode(null);
		return node;
	}

}

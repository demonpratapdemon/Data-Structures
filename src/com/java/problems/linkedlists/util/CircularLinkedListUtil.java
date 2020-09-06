/**
 * 
 */
package com.java.problems.linkedlists.util;

import com.java.problems.linkedlists.entity.SingleLinkedListNode;

/**
 * @author PRATAP
 *
 */
public class CircularLinkedListUtil {

	public static SingleLinkedListNode insertNodeAtEnd(SingleLinkedListNode node, int data) {
		// TODO Auto-generated method stub
		SingleLinkedListNode newNode = new SingleLinkedListNode();
		if (node == null) {
			newNode.setData(data);
			newNode.setNextNode(newNode);
			return newNode;
		}
		SingleLinkedListNode head = node;
		while (node.getNextNode() != head) {
			node = node.getNextNode();
		}
		newNode.setData(data);
		node.setNextNode(newNode);
		newNode.setNextNode(head);
		return head;
	}

	public static int countNodes(SingleLinkedListNode node) {
		// TODO Auto-generated method stub
		if (node == null)
			return 0;
		SingleLinkedListNode head = node;
		int count = 1;
		while (node.getNextNode() != head) {
			node = node.getNextNode();
			count++;
		}
		return count;
	}

	public static void printNodes(SingleLinkedListNode node) {
		// TODO Auto-generated method stub
		if (node == null) {
			System.out.println("There are no nodes in the Circular Linked List");
			return;
		}
		System.out.print("The nodes in the Circular Linked List : ");
		SingleLinkedListNode head = node;
		do {
			System.out.print(node.getData() + " ");
			node = node.getNextNode();
		} while (node != head);
		System.out.println();
	}

	public static SingleLinkedListNode insertNodeAtBeginning(SingleLinkedListNode node, int data) {
		// TODO Auto-generated method stub
		SingleLinkedListNode newNode = new SingleLinkedListNode();
		newNode.setData(data);
		if (node == null) {
			newNode.setNextNode(newNode);
			return newNode;
		}
		newNode.setNextNode(node);
		SingleLinkedListNode head = node;
		while (node.getNextNode() != head) {
			node = node.getNextNode();
		}
		node.setNextNode(newNode);
		return newNode;
	}

	public static SingleLinkedListNode deleteLastNode(SingleLinkedListNode node) {
		// TODO Auto-generated method stub
		if (node == null) {
			System.out.println("There are no nodes to be deleted");
			return null;
		}
		if (CircularLinkedListUtil.countNodes(node) == 1) {
			return null;
		}
		SingleLinkedListNode head = node;
		while (node.getNextNode().getNextNode() != head) { // to stop at the previous node of the tail node
			node = node.getNextNode();
		}
		node.getNextNode().setNextNode(null);
		node.setNextNode(head);
		System.gc();
		return head;
	}

	public static SingleLinkedListNode deleteFirstNode(SingleLinkedListNode node) {
		// TODO Auto-generated method stub
		if (node == null) {
			System.out.println("There are no nodes to be deleted");
			return null;
		}
		if (CircularLinkedListUtil.countNodes(node) == 1) {
			return null;
		}
		SingleLinkedListNode head = node;
		while (node.getNextNode() != head) {
			node = node.getNextNode();
		}
		node.setNextNode(head.getNextNode());
		head.setNextNode(null);
		head =node.getNextNode();
		return head;
	}

}

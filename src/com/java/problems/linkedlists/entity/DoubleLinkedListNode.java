/**
 * 
 */
package com.java.problems.linkedlists.entity;

/**
 * @author PRATAP
 *
 */
public class DoubleLinkedListNode {

	private DoubleLinkedListNode prevNode;

	private int data;

	private DoubleLinkedListNode nextNode;

	public DoubleLinkedListNode getPrevNode() {
		return prevNode;
	}

	public void setPrevNode(DoubleLinkedListNode prevNode) {
		this.prevNode = prevNode;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public DoubleLinkedListNode getNextNode() {
		return nextNode;
	}

	public void setNextNode(DoubleLinkedListNode nextNode) {
		this.nextNode = nextNode;
	}
}

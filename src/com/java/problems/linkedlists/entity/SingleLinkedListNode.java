/**
 * 
 */
package com.java.problems.linkedlists.entity;

/**
 * @author PRATAP
 *
 */
public class SingleLinkedListNode {

	private int data;
	private SingleLinkedListNode nextNode;

	public SingleLinkedListNode getNextNode() {
		return nextNode;
	}

	public void setNextNode(SingleLinkedListNode nextNode) {
		this.nextNode = nextNode;
	}

	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(int data) {
		this.data = data;
	}
}

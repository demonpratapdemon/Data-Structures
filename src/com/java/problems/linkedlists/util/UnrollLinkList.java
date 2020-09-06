/**
 * 
 */
package com.java.problems.linkedlists.util;

import com.java.problems.linkedlists.entity.ULLNode;

/**
 * @author PRATAP
 *
 */
public class UnrollLinkList {

	private ULLNode start_pos;
	private ULLNode end_pos;
	int size_node;
	int nNode; // to keep track of the total no of nodes in the ULL

	public UnrollLinkList(int capacity) {
		start_pos = null;
		end_pos = null;
		nNode = 0;
		size_node = capacity + 1;
	}

	public void insert(int num) {
		nNode++;
		// Check if the list starts from NULL
		if (start_pos == null) {
			start_pos = new ULLNode(size_node);
			start_pos.array[0] = num;
			start_pos.numElements++;
			end_pos = start_pos;
			return;
		}
		// Attaching the elements into nodes
		if (end_pos.numElements + 1 < size_node) {
			end_pos.array[end_pos.numElements] = num;
			end_pos.numElements++;
		}
		// Creation of new Node
		else {
			ULLNode node_pointer = new ULLNode(size_node);
			int j = 0;
			for (int i = end_pos.numElements / 2 + 1; i < end_pos.numElements; i++) {
				node_pointer.array[j++] = end_pos.array[i];
				end_pos.array[i] = 0;
			}
			node_pointer.array[j++] = num;
			node_pointer.numElements = j;
			end_pos.numElements = end_pos.numElements / 2 + 1;
			end_pos.next = node_pointer;
			end_pos = node_pointer;
		}
	}

	public void display() {
		// TODO Auto-generated method stub
		System.out.println("The values in the Unrolled Linked List");
		ULLNode temp = start_pos;
		while (temp != null) {
			for (int i = 0; i < temp.numElements; i++) {
				System.out.print(temp.array[i] + " ");
			}
			System.out.println();
			temp = temp.next;
		}
	}
}

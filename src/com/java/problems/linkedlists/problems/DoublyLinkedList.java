/**
 * 
 */
package com.java.problems.linkedlists.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.java.problems.linkedlists.entity.DoubleLinkedListNode;
import com.java.problems.linkedlists.util.DoublyLinkedListUtil;

/**
 * @author PRATAP
 *
 */
public class DoublyLinkedList {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DoubleLinkedListNode node = null;
		do {
			System.out.println("1. Enter a node at the beginning of a Doubly Linked List");
			System.out.println("2. Enter a node at the end of a Doubly Linked List");
			System.out.println("3. Enter a node at the middle of a Doubly Linked List");
			System.out.println("4. Delete first node of Doubly Linked List");
			System.out.println("5. Delete last node of  Doubly Linked List");
			System.out.println("6. Delete intermediate node of Doubly Linked List");
			System.out.println("7. Count the no of nodes in Doubly Linked List");
			System.out.println("8. Print all the nodes in the Doubly Linked List");
			System.out.println("9. Exit");
			int choice = Integer.parseInt(br.readLine());
			switch (choice) {
			case 1: {
				System.out.println("Enter the value to be inserted");
				node = DoublyLinkedListUtil.insertAtBeginning(node, Integer.parseInt(br.readLine()));
				break;
			}
			case 2: {
				System.out.println("Enter the value to be inserted");
				node = DoublyLinkedListUtil.insertAtEnd(node, Integer.parseInt(br.readLine()));
				break;
			}
			case 3: {
				System.out.println("Enter the position and the value to be inserted");
				node = DoublyLinkedListUtil.insertAtMiddle(node, Integer.parseInt(br.readLine()),
						Integer.parseInt(br.readLine()));
				break;
			}
			case 4: {
				node = DoublyLinkedListUtil.deleteBeginningNode(node);
				break;
			}
			case 5: {
				node = DoublyLinkedListUtil.deleteEndNode(node);
				break;
			}
			case 6: {
				System.out.println("Enter the position of the node to be deleted");
				node = DoublyLinkedListUtil.deleteInterMediateNode(node, Integer.parseInt(br.readLine()));
				break;
			}
			case 7: {
				System.out.println("No of Nodes in the Doubly Linked List : " + DoublyLinkedListUtil.countNodes(node));
				break;
			}
			case 8: {
				DoublyLinkedListUtil.printNodes(node);
				break;
			}
			case 9:
				System.exit(0);
			default:
				System.exit(0);
			}
		} while (true);
	}

}

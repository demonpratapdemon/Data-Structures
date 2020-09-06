/**
 * 
 */
package com.java.problems.linkedlists.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.java.problems.linkedlists.entity.SingleLinkedListNode;
import com.java.problems.linkedlists.util.CircularLinkedListUtil;

/**
 * @author PRATAP
 *
 */
public class CircularLinkedList {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		SingleLinkedListNode node = null;
		do {
			System.out.println("1. Enter node in the end of Circular Linked List");
			System.out.println("2. Enter node in the beginning of Circular Linked List");
			System.out.println("3. Delete last node of Circular Linked List");
			System.out.println("4. Delete first node of Circular Linked List");
			System.out.println("5. Count no of nodes in Circular Linked List");
			System.out.println("6. Print the nodes in Circular Linked List");
			System.out.println("9. Exit");
			System.out.print("Enter choice : ");
			int choice = Integer.parseInt(br.readLine());
			switch (choice) {
			case 1: {
				System.out.println("Enter the value to be inserted");
				node = CircularLinkedListUtil.insertNodeAtEnd(node, Integer.parseInt(br.readLine()));
				break;
			}
			case 2: {
				System.out.println("Enter the value to be inserted");
				node = CircularLinkedListUtil.insertNodeAtBeginning(node, Integer.parseInt(br.readLine()));
				break;
			}
			case 3: {
				node = CircularLinkedListUtil.deleteLastNode(node);
				break;
			}
			case 4: {
				node = CircularLinkedListUtil.deleteFirstNode(node);
				break;
			}
			case 5: {
				System.out.println("No of nodes in Circular Linked List : " + CircularLinkedListUtil.countNodes(node));
				break;
			}
			case 6: {
				CircularLinkedListUtil.printNodes(node);
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

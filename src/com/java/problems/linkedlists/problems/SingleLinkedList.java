/**
 * 
 */
package com.java.problems.linkedlists.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.java.problems.linkedlists.entity.SingleLinkedListNode;
import com.java.problems.linkedlists.util.LinkedListsUtil;

/**
 * @author PRATAP
 *
 */
public class SingleLinkedList {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		SingleLinkedListNode singleLinkedListNode = null;
		do {
			System.out.println("1. Enter node at the beginning of linked list");
			System.out.println("2. Enter node at the end of linked list");
			System.out.println("3. Enter node at the middle of linked list");
			System.out.println("4. Delete node from linked list");
			System.out.println("5. Print linked list");
			System.out.println("6. Reverse the linked list Iteratively");
			System.out.println("7. Reverse the linked list Recursively");
			System.out.println("8. Print linked list in Reverse Pattern");
			System.out.println("9. Reverse the linked list in pairs");
			System.out.println("10. Exit");
			System.out.print("Enter your choice : ");
			int choice = Integer.parseInt(br.readLine());
			switch (choice) {
			case 1: {
				System.out.println("Enter the node value to be inserted");
				singleLinkedListNode = LinkedListsUtil.insertAtBeginning(singleLinkedListNode,
						Integer.parseInt(br.readLine()));
				break;
			}
			case 2: {
				System.out.println("Enter the node value to be inserted");
				singleLinkedListNode = LinkedListsUtil.insertAtEnd(singleLinkedListNode,
						Integer.parseInt(br.readLine()));
				break;
			}
			case 3: {
				System.out.println("Enter the position and node value to be inserted");
				singleLinkedListNode = LinkedListsUtil.insertAtMiddle(singleLinkedListNode,
						Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()));
				break;
			}
			case 4: {
				System.out.println("Enter the position of node to be deleted");
				singleLinkedListNode = LinkedListsUtil.deleteNode(singleLinkedListNode,
						Integer.parseInt(br.readLine()));
				break;
			}
			case 5: {
				LinkedListsUtil.printNodes(singleLinkedListNode);
				break;
			}
			case 6: {
				singleLinkedListNode = LinkedListsUtil.reverseLinkedListIteratively(singleLinkedListNode);
				break;
			}
			case 7: {
				singleLinkedListNode = LinkedListsUtil.reverseLinkedListRecursively(singleLinkedListNode);
				break;
			}
			case 8: {
				System.out.print("Nodes in reverse are : ");
				LinkedListsUtil.printInReverse(singleLinkedListNode);
				System.out.println();
				break;
			}
			case 9: {
				singleLinkedListNode = LinkedListsUtil.reverseInPairs(singleLinkedListNode);
				break;
			}
			case 10:
				System.exit(0);
			default:
				System.exit(0);

			}
		} while (true);
	}
}

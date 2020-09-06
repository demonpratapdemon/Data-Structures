/**
 * 
 */
package com.java.problems.linkedlists.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.java.problems.linkedlists.util.UnrollLinkList;

/**
 * @author PRATAP
 *
 */
public class UnrolledLinkedList {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the array size of each node : ");
		int size = Integer.parseInt(br.readLine());
		UnrollLinkList ull = new UnrollLinkList(size);
		do {
			System.out.println("1. Insert into Unrolled Linked List");
			System.out.println("2. Check empty");
			System.out.println("3. Get size");
			System.out.println("4. Clear");
			System.out.println("5. Display Unrolled Linked List");
			int choice = Integer.parseInt(br.readLine());
			switch (choice) {
			case 1: {
				System.out.println("Enter integer element to insert");
				ull.insert(Integer.parseInt(br.readLine()));
				break;
			}
			case 2: {
				break;
			}
			case 3: {
				break;
			}
			case 4: {
				break;
			}
			case 5: {
				ull.display();
				break;
			}
			default: {
				System.exit(0);
			}

			}
		} while (true);
	}

}

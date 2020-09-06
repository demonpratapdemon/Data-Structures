/**
 * 
 */
package com.java.problems.stacks.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.java.problems.stacks.entity.ArrayStackEntity;
import com.java.problems.stacks.util.StackUtil;

/**
 * @author PRATAP
 *
 */
public class StackADT {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayStackEntity stack = null;
		do {
			System.out.println("0. Create stack");
			System.out.println("1. Push element onto stack");
			System.out.println("2. Pop element from stack");
			System.out.println("3. Is stack empty?");
			System.out.println("4. Is stack full?");
			System.out.println("5. Delete the stack");
			System.out.println("6. Dynamically increase stack size");
			System.out.println("7. Exit");
			System.out.println("Enter your choice : ");
			int choice = Integer.parseInt(br.readLine());
			switch (choice) {
			case 0: {
				System.out.print("Enter the size of stack required : ");
				int size = Integer.parseInt(br.readLine());
				stack = StackUtil.createStack(size);
				break;
			}
			case 1: {
				System.out.println("Enter the element to be pushed onto stack");
				stack = StackUtil.pushToStack(stack, Integer.parseInt(br.readLine()));
				break;
			}
			case 2: {
				System.out.println("Popped element from stack : " + StackUtil.popFromStack(stack));
				break;
			}
			case 3: {
				System.out.print("Stack is :  ");
				System.out.println((StackUtil.isStackEmpty(stack) == 1) ? "Empty" : "Not Empty");
				break;
			}
			case 4: {
				System.out.print("Stack is : ");
				System.out.println((StackUtil.isStackFull(stack) == 1) ? "Full" : "Not Full");
				break;
			}
			case 5: {
				stack = null;
				System.out.println("Stack has been deleted");
				break;
			}
			case 6: {

				System.out.println("Would you like to dynamically increase the size of the stack? Y/N");
				String option = br.readLine();
				if (option.equalsIgnoreCase("Y")) {
					stack = StackUtil.dynamicallyIncreaseStack(stack);
				}
				break;
			}
			case 7: {
				System.exit(0);
			}
			default:
				System.exit(0);
			}
		} while (true);
	}

}

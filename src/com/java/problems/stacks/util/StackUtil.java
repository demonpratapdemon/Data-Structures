/**
 * 
 */
package com.java.problems.stacks.util;

import java.util.Arrays;

import com.java.problems.stacks.entity.ArrayStackEntity;

/**
 * @author PRATAP
 *
 */
public class StackUtil {

	public static ArrayStackEntity pushToStack(ArrayStackEntity stack, int data) {
		// TODO Auto-generated method stub
		if (stack == null) {
			System.out.println("Stack has been deleted. Create a new stack to proceed");
			return stack;
		}
		if (isStackFull(stack) == 1) {
			System.out.println("Element cannot be inserted as the stack is full");
			return stack;
		}
		stack.setTop(stack.getTop() + 1);
		stack.arr[stack.getTop()] = data;
		System.out.println("Element has been pushed successfully");
		return stack;
	}

	public static int isStackFull(ArrayStackEntity stack) {
		// TODO Auto-generated method stub
		return (stack.getTop() == stack.getCapacity() - 1) ? 1 : 0;
	}

	public static String popFromStack(ArrayStackEntity stack) {
		// TODO Auto-generated method stub
		if (stack == null) {
			return "Stack has been deleted. Create a new stack to proceed";
		}
		if (isStackEmpty(stack) == 1) {
			return "Stack is empty";
		}
		int poppedElement = stack.arr[stack.getTop()];
		stack.setTop(stack.getTop() - 1);
		System.out.println("Stack element popped successfully");
		return String.valueOf(poppedElement);
	}

	public static int isStackEmpty(ArrayStackEntity stack) {
		// TODO Auto-generated method stub
		return (stack.getTop() == -1) ? 1 : 0;
	}

	public static ArrayStackEntity createStack(int capacity) {
		// TODO Auto-generated method stub
		return new ArrayStackEntity(capacity);
	}

	public static ArrayStackEntity dynamicallyIncreaseStack(ArrayStackEntity stack) {
		// TODO Auto-generated method stub
		if (stack == null) {
			System.out.println("Create a stack first");
			return stack;
		}
		int[] newArray = Arrays.copyOf(stack.arr, stack.arr.length * 2);
		stack.arr = null;
		stack.arr = newArray;
		stack.setCapacity(stack.arr.length);
		System.out.println("Stack size dynamically increased");
		return stack;
	}

	// A utility function to return precedence of a given operator
	// Higher returned value means higher precedence
	public static int precedence(Character value) {

		switch (value) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;

		}
		return -1;
	}

	public static int getAssociativity(Character value) { // 0 - left to right associative
															// 1 - right to left associative
		switch (value) {
		case '+':
		case '-':
		case '*':
		case '/':
			return 0;
		case '^':
			return 1;
		}
		return -1;
	}

	public static boolean isOperator(Character value) { // if operator - then true
														// else - false
		switch (value) {
		case '+':
		case '-':
		case '*':
		case '/':
		case '^':
		case '<':
		case '>':
			return true;
		default:
			return false;
		}
	}

}

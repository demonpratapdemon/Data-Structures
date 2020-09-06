/**
 * 
 */
package com.java.problems.stacks.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import com.java.problems.stacks.util.StackUtil;

/**
 * @author PRATAP
 *
 */
public class InfixToPostfix {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String choice = "";
		do {
			System.out.println("Enter the Infix expression to be converted to postfix");
			String infixExpr = br.readLine();
			String postfixExpr = infixToPostfix(infixExpr);
			System.out.println("The postfix expression is : " + postfixExpr);
			System.out.print("Do you want to continue? Y/N : ");
			choice = br.readLine();
		} while (choice.equalsIgnoreCase("Y"));
	}

	private static String infixToPostfix(String infixExpr) {
		// TODO Auto-generated method stub
		String result = "";
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < infixExpr.length(); i++) {
			char ch = infixExpr.charAt(i);
			if (Character.isLetterOrDigit(ch)) { // if operand is encountered directly append to postFIxExpression
													// result
				result += ch;
			} else if (ch == '(' || ch == '{' || ch == '[') { // if character encountered is opening braces simply push
																// it to the stack
				stack.push(ch);
			} else if (ch == ')' || ch == '}' || ch == ']') { // if character encountered is closing braces need to pop
																// everything until the closing brace of that type is
																// encountered else it's an Invalid expression
				while (!stack.isEmpty()) {
					if (ch == ')' && stack.peek() == '(') {
						stack.pop();
						break;
					} else if (ch == '}' && stack.peek() == '{') {
						stack.pop();
						break;
					} else if (ch == ']' && stack.peek() == '[') {
						stack.pop();
						break;
					} else if (ch == ')' && (stack.peek() == '{' || stack.peek() == '[')) {
						return "Invalid Expression";
					} else if (ch == '}' && (stack.peek() == '(' || stack.peek() == '[')) {
						return "Invalid Expression";
					} else if (ch == ']' && (stack.peek() == '{' || stack.peek() == '(')) {
						return "Invalid Expression";
					}
					result += stack.pop();
				}
			} else { // if the character encountered is an Operator, check the precedence of the
						// previous operator and then proceed
						// if the operator has the same precedence compared to the top of stack and is
						// right associative push it to stack
				while (!stack.isEmpty() && StackUtil.precedence(ch) <= StackUtil.precedence(stack.peek())
						&& StackUtil.getAssociativity(ch) != 1) {
					result += stack.pop();
				}
				stack.push(ch);
			}
		}
		while (!stack.isEmpty()) {
			if (stack.peek() == '(')
				return "Invalid Expression";
			result += stack.pop();
		}
		return result;
	}

}

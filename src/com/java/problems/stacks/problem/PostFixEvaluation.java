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
public class PostFixEvaluation {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("***************INSTRUCTIONS***************");
		System.out.println("Please use <> symbol for unary operators like 2<++> will evaluate to 3");
		System.out.println(
				"If it's a multi digit number please put a space before and after the number otherwise not required.");
		System.out.println("Space is only needed when multi digit number is there otherwise not");
		System.out.println("No space is needed between unary and binary operators");
		System.out.println(
				"If it's a multidigit number and unary operator has to be applied on the operand please put a space between the unary operator and the operand. The unary operator format is mentioned above");
		System.out.println("******************************************");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String choice = "";
		do {
			System.out
					.println("Enter the Postfix expression to be evaluated(Remember each digitshould be between 0-9)");
			String postfixExpr = br.readLine();
			int postfixEvaluatedValue = postfixEvaluation(postfixExpr);
			System.out.println("The postfix evaluated value is : " + postfixEvaluatedValue);
			System.out.print("Do you want to continue? Y/N : ");
			choice = br.readLine();
		} while (choice.equalsIgnoreCase("Y"));
	}

	private static int postfixEvaluation(String postfixExpr) {
		// TODO Auto-generated method stub
		if (postfixExpr == null || postfixExpr.equalsIgnoreCase(""))
			return 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < postfixExpr.length(); i++) {
			char ch = postfixExpr.charAt(i);
			if (Character.isDigit(ch)) {
				stack.push(Integer.parseInt(Character.toString(ch)));
			} else {
				switch (ch) {
				case ' ': {
					String multiDigit = "";
					int k = i - 1;// retracing index for multidigit
					while (k >= 0 && !String.valueOf(postfixExpr.charAt(k)).equalsIgnoreCase(" ") && !stack.isEmpty()
							&& (Character.isDigit(postfixExpr.charAt(i + 1))
									|| StackUtil.isOperator(postfixExpr.charAt(i + 1)))) {
						multiDigit = stack.pop() + multiDigit;
						k--;
					}
					if (multiDigit != null && !multiDigit.equalsIgnoreCase(""))
						stack.push(Integer.parseInt(multiDigit));
					break;
				}
				case '+': {
					int val2 = stack.pop();
					int val1 = stack.pop();
					stack.push(val1 + val2);
					break;
				}
				case '-': {
					int val2 = stack.pop();
					int val1 = stack.pop();
					stack.push(val1 - val2);
					break;
				}
				case '*': {
					int val2 = stack.pop();
					int val1 = stack.pop();
					stack.push(val1 * val2);
					break;
				}
				case '/': {
					int val2 = stack.pop();
					int val1 = stack.pop();
					stack.push(val1 / val2);
					break;
				}
				case '^': {
					int val2 = stack.pop();
					int val1 = stack.pop();
					Double powValue = Math.pow(Double.valueOf(val2), Double.valueOf(val1));
					stack.push(powValue.intValue());
					break;
				}
				case '<': {
					int val1 = stack.pop();
					Character operation = postfixExpr.charAt(i + 1);
					switch (operation) {
					case '+': {
						stack.push(++val1);
						i += 3;
						break;
					}
					case '-': {
						stack.push(--val1);
						i += 3;
						break;
					}
					}
				}
				}
			}
		}
		return stack.pop();
	}

}

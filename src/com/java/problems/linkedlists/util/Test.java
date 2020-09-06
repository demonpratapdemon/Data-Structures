/**
 * 
 */
package com.java.problems.linkedlists.util;

/**
 * @author PRATAP
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Scanner scanner = new Scanner(System.in);
		 * System.out.println("Enter the values of 'a' and 'b'"); int a =
		 * scanner.nextInt(); int b = scanner.nextInt(); System.out.println(a + b);
		 * scanner.close();
		 */
		/*
		 * int[] arr = { 1, 2, 3 }; int[] newArr = Arrays.copyOf(arr, 2 * arr.length);
		 * System.out.println(newArr.length); int length = 0; while (length <
		 * newArr.length) { System.out.print(newArr[length] + " "); length++; }
		 */
		String numberRegex = "\\d+";
		String check = "10";
		for (int i = 0; i < check.length(); i++) {
			if (Character.toString(check.charAt(i)).matches(numberRegex)) {
				System.out.println(Integer.parseInt(Character.toString(check.charAt(i))));
				
			}
		}
	}

}

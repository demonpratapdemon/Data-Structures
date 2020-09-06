/**
 * 
 */
package com.java.problems.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author PRATAP
 *
 */
public class GenerateAllStrings {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter the array length : ");
		int length = Integer.parseInt(br.readLine());
		System.out.println("Please enter the elements in the array now : ");
		int[] arr = new int[length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		System.out.println("Please enter the length 'k' of all strings to be generated : ");
		int k = Integer.parseInt(br.readLine());
		System.out.println("*****RESULT*****");
		k_String(arr, k, "");
	}

	private static void k_String(int[] arr, int k, String prefix) {
		// TODO Auto-generated method stub
		if (k == 0) {
			System.out.println(prefix);
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			String newPrefix = prefix + String.valueOf(arr[i]);
			k_String(arr, k - 1, newPrefix);
		}
	}

}

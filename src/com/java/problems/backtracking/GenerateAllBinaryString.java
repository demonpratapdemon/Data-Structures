/**
 * 
 */
package com.java.problems.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author PRATAP
 *
 */
public class GenerateAllBinaryString {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter the length of string : ");
		int length = Integer.parseInt(br.readLine());
		int[] arr = new int[length];
		printBinaryString(arr, length);
	}

	private static void printBinaryString(int[] arr, int length) {
		// TODO Auto-generated method stub
		if (length < 1) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		arr[length - 1] = 0;
		printBinaryString(arr, length - 1);
		arr[length - 1] = 1;
		printBinaryString(arr, length - 1);
	}

}

/**
 * 
 */
package com.java.problems.solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author PRATAP
 *
 */
public class SortedArrayUsingRecursion {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter the no of elements in the array : ");
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		System.out.println("Please eneter the elements : ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int checkStatus = checkSortedArray(arr, arr.length);
		String result = (checkStatus > 0) ? "Sorted" : "Unsorted";
		System.out.println("The arrray is :: " + result);
	}

	private static int checkSortedArray(int[] arr, int n) {
		// TODO Auto-generated method stub
		if (n <= 1) {
			return 1;
		}
		return (arr[n - 1] < arr[n - 2]) ? 0 : checkSortedArray(arr, n - 1);
	}

}

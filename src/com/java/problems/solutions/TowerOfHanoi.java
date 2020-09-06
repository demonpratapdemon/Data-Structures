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
public class TowerOfHanoi {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String source = "A", aux = "B", dest = "C";
		System.out.println("Please enter the no of disks in Source peg A");
		int noOfDisks = Integer.parseInt(br.readLine());
		System.out.println("No of disks = " + noOfDisks);
		System.out.println("**********MOVEMENTS**********");
		towerOfHanoi(noOfDisks, source, aux, dest);
	}

	private static void towerOfHanoi(int noOfDisks, String source, String aux, String dest) {
		// TODO Auto-generated method stub

		if (noOfDisks == 1) {
			System.out.println(source + "=====>" + dest);
			return;
		}
		towerOfHanoi(noOfDisks - 1, source, dest, aux);
		System.out.println(source + "=====>" + dest);
		towerOfHanoi(noOfDisks - 1, aux, source, dest);
	}

}

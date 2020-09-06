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
public class ConnectedCells {

	static int count, rowSize, colSize;

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter the row size and column size of matrix :: ");
		rowSize = Integer.parseInt(br.readLine());
		colSize = Integer.parseInt(br.readLine());
		int array[][] = new int[rowSize][colSize];
		System.out.println("Please enter the elements in the array : ");
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				array[i][j] = Integer.parseInt(br.readLine());
			}
		}
		System.out.println("********************************");
		System.out.println("Elements in the array are as follow :");
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
		System.out.println("********************************");
		System.out.println("Maximum filled cells = " + findMaxConnectedCells(array, rowSize, colSize, 0));
	}

	private static int findMaxConnectedCells(int[][] array, int rowSize, int colSize, int max) {
		// TODO Auto-generated method stub
		boolean[][] visited = new boolean[rowSize][colSize]; // boolean array to keep track of visited cells
		int result = 0; // final result to be returned
		for (int row = 0; row < rowSize; row++) {
			for (int col = 0; col < colSize; col++) {
				if (array[row][col] == 1 && !visited[row][col]) { // if the cell value is 1 and that cell is not visited
					count = 1;
					DFS(array, row, col, visited);
					result = (result > count) ? result : count;
				}
			}
		}
		return result;
	}

	private static void DFS(int[][] array, int row, int col, boolean[][] visited) {
		// TODO Auto-generated method stub
		// These arrays are used to get row and column
		// numbers of 8 neighbours of a given cell
		int[] rowNbr = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] colNbr = { -1, 0, 1, -1, 1, -1, 0, 1 };
		visited[row][col] = true;
		for (int k = 0; k < 8; k++) {
			if (isSafe(array, row + rowNbr[k], col + colNbr[k], visited)) {
				count++;
				DFS(array, row + rowNbr[k], col + colNbr[k], visited);
			}
		}
	}

	private static boolean isSafe(int[][] array, int row, int col, boolean[][] visited) {
		// TODO Auto-generated method stub
		// row number is in range, column number is in
		// range and value is 1 and not yet visited
		return ((row >= 0) && (row < rowSize) && (col >= 0) && (col < colSize)
				&& (array[row][col] == 1 && !visited[row][col]));
	}

}

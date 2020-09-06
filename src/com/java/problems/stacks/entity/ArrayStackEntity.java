/**
 * 
 */
package com.java.problems.stacks.entity;

/**
 * @author PRATAP
 *
 */
public class ArrayStackEntity {

	public int top;

	public int capacity;

	public int[] arr;

	public ArrayStackEntity(int capacity) {
		top = -1;
		this.capacity = capacity;
		arr = new int[this.capacity];
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int[] getArr() {
		return arr;
	}
	
}

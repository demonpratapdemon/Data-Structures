/**
 * 
 */
package com.java.problems.stacks.entity;

/**
 * @author PRATAP
 *
 */
public class StringStack {

	public int top;

	public int capacity;

	public String[] arr;

	public StringStack(int capacity) {
		
		this.capacity = capacity;
		top = -1;
		arr = new String[this.capacity];
	}

}

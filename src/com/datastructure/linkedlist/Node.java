/**
	@author Abhijeet Shankar Shedge
	@version 1.0  September 9, 2015
*/

package com.datastructure.linkedlist;

// This node is utilized for a doubly linked list.
public final class Node {

	private Node previous;
	private Node next;
	private Object data;
		
	// default constructor
	public Node(){
	}
	
	// constructor to create & attach a new node to the linked list.
	public Node(Object data, Node previous, Node next){
		this.data = data;
		this.previous = previous;
		this.next = next;
	}
	
	
	
	
	public Node getPrevious() {
		return previous;
	}
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
	
}

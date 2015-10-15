package com.datastructure.redblacktree;


public class Node {
	
	
	private Node left = null;
	private Node right = null;
	private Node parent = null;
	private char color='b';
	private Integer data;
		
		
			
		
		
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {						
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public char getColor() {
		return color;
	}
	public void setColor(char color) {
		this.color = color;
	}
	public Integer getData() {
		return data;
	}
	public void setData(Integer data) {
		this.data = data;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	
	
	

}

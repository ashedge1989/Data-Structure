/**
	@author Abhijeet Shankar Shedge
	@version 1.0  September 9, 2015
*/


package com.datastructure.linkedlist;

public interface IList {

	public abstract boolean add(Object data);
	public abstract boolean add(long index, Object data);
	
	public abstract boolean remove(Object data);
	public abstract boolean remove(long index);
		
	public abstract Object get(long index);
	
	public abstract long length();
	
	
	
	// only for testing 
	public abstract void print();
	
}

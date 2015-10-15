/**
	@author Abhijeet Shankar Shedge
	@version 1.0  September 10, 2015
*/


package com.datastructure.heap;

import java.util.List;

public interface IHeap {

	

	
	public abstract int add(Integer data);
	
	
	
	
	public abstract List<Integer> builtHeap(boolean heapType);
	
	
	
	
	public abstract Integer peak();
	
	
	
	
	public abstract List<Integer> sort();
	
	
	
}

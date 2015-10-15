/**
	@author Abhijeet Shankar Shedge
	@version 1.0  September 9, 2015
*/

package com.datastructure.binarysearchtree;

import java.util.List;

public interface IBSTree {

	
	public abstract boolean add(Integer data);
	
	
	
	public abstract List<Integer> inorderTraverse(); 
	
	
	
	public abstract long height();
	
	
	
	// Use recursion to print level wise elements.
	public abstract void levelPrint();	
	// Use a Queue to print level wise tree. 
	public abstract void levelPrintUsingQueue();	
	// Print level wise tree but in spiral nature. (left to right and then next level right to left) 
	public abstract void spiralLevelPrint();
	
	
	
	public abstract void rootToLeafPaths();
	
	
		
	public abstract List<Integer> getLeafNodes();
	
	
	
	public abstract boolean isHeightBalanced();	
	// Optimized height balance checking 
	public abstract boolean isTreeHeightBalanced();
	
	
	
	public abstract Integer getLowestCommanAncestor(Integer value1, Integer value2);
	
	
	
	public abstract boolean isSumTree();
	
	
	
	public abstract void printBoundaryNodes();
	
	
	
	public abstract boolean areLeafsAtSameLeve();
	
	
	
	public abstract void printLeftView();
	
	
	
	public abstract boolean isCousin(Integer node1, Integer node2);
	
	
	
	public abstract Node getDeepestLeftNode();
	
}

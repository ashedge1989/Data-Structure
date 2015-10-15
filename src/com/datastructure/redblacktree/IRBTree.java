package com.datastructure.redblacktree;

public interface IRBTree {

	
	public abstract void add(Integer data);
	
	public abstract void remove(Integer data);
	
	public abstract Node search(Integer data);
	
	
	
	
	
	
	// HELPER FUNCTIONS FOR TESTING  RB TREE
	public abstract long height();
	public abstract void levelPrint();
	
}

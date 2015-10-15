package com.datastructure.redblacktree;

public class Test_RedBlackTree {

	public static void main(String[] args) {
				
		RedBlackTree rbt = new RedBlackTree();
		
/*		rbt.add(50);
		rbt.add(30);
		rbt.add(70);
		rbt.add(25);
		rbt.add(40);
		rbt.add(80);
		rbt.add(65);
		rbt.add(62);
		rbt.add(45);
*/	
		
/*
		rbt.add(50);
		rbt.add(40);
		rbt.add(75);
		rbt.add(25);
		rbt.add(47);
		rbt.add(45);
		rbt.add(49);
	
*/	
		
		rbt.add(1);
		rbt.add(2);
		rbt.add(3);
		rbt.add(4);
		rbt.add(5);
		rbt.add(6);	
	
	
/*		for(int i=0; i<20000000; i++){
			rbt.add(i);
		}
*/
		
		//System.out.println("\n\n\nTree Height: "+rbt.height());
		
		System.out.println("\n\nLevel Wise Nodes in RB Tree:\n");
		rbt.levelPrint();  
		
		System.out.println("\n\nSearch for Node '5' ");
		Node discNode = rbt.search(5);
		if(discNode!=null){
			System.out.println("Node found.  Data = "+discNode.getData());
		}else{
			System.out.println("Node not found.");
		}
	}
	
}

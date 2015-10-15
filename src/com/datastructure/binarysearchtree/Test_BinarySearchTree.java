/**
	@author Abhijeet Shankar Shedge
	@version 1.0  September 9, 2015
*/


package com.datastructure.binarysearchtree;

import java.util.List;


public class Test_BinarySearchTree {

	public static void main(String[] args) {
		
		IBSTree bst = new BinarySearchTree();
		
		
		bst.add(4);
		bst.add(2);
		bst.add(1);
		bst.add(3);
		bst.add(6);
		bst.add(8);
		System.out.println(""+bst.add(5));
		System.out.println(""+bst.add(5));	// try adding duplicate element to BST. 
		bst.add(7);
		
		
		// Sample tree for testing of 'Print Boundary Nodes' functionality. 
		/*bst.add(20);
		bst.add(8);
		bst.add(22);
		bst.add(4);
		bst.add(12);
		bst.add(10);
		bst.add(14);
		bst.add(25);
		bst.add(13);
		bst.add(23);
		bst.add(21);*/
		
		
		
		System.out.println("Inorder traversal on the Binary Search Tree: ");		bst.inorderTraverse();
		
		
		
		System.out.println("\n\nHeight of tree is:  "+bst.height());
		
		
		
		System.out.println("\n\nLevel wise Nodes in BST using a recursion: ");		bst.levelPrint();
		
		System.out.println("\n\nLevel wise Nodes in BST using a QUEUE.");			bst.levelPrintUsingQueue();
				
		System.out.println("\n\nLevel wise Nodes in BST in Spiral order.");			bst.spiralLevelPrint();
		
		
		
		System.out.println("\n\n\nPrinting the Root to Leaf Nodes in the Tree. \n");bst.rootToLeafPaths();
		
		
		
		System.out.println("\n\nPrinting all Leaf nodes in the Tree.");
		List<Integer> leafNodes = bst.getLeafNodes();
			for(Integer leafNodeVal : leafNodes){
				System.out.print("  "+leafNodeVal);
			}
		
	
		
		System.out.println("\n\nCheck if tree is balanced:  "+bst.isHeightBalanced());
		
		System.out.println("\n\nOptimised version of tree is balanced or not :   "+bst.isTreeHeightBalanced());
		
		
		
		System.out.println("\n\nLowest Comman Ancestor of nodes:  "+bst.getLowestCommanAncestor(1, 3));
		
		
		
		System.out.println("\n\nIs sum tree: "+bst.isSumTree());
		
		
				
		System.out.println("\n\nPrint boundary Nodes of BST:  ");					bst.printBoundaryNodes();
		
		
				
		System.out.println("\n\nAre leaf nodes at same level ?  "+bst.areLeafsAtSameLeve());
		
		
		
		System.out.println("\n\nLeft view of a BST :");								bst.printLeftView();
		
		
		
		
		System.out.println("\n\nAre nodes siblings ? "+bst.isCousin(1, 5));						
		
		
		
		
		System.out.println("\n\nDeepest left node is: "+bst.getDeepestLeftNode().getData());							
		
		
		
		
		
		
				
	}
	
}




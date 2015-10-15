/**
	@author Abhijeet Shankar Shedge
	@version 1.0  September 9, 2015
*/

package com.datastructure.binarysearchtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/** 
	Binary Search Tree Class. Implements ITree interface.  
 */
public final class BinarySearchTree implements IBSTree{
	
	
	
	
	private Node root = null;
	private Stack<Node> stk = new Stack<Node>();
	   
	
	
	 
	/**   
	 	Inserts a number into a BST.  
	 	
	 	@param data - Integer data to be inserted into the binary search tree. 
	 	@return	true - if Node was added successfully, false - if Node was not added or any error occurs 
	 */
	@Override
	public boolean add(Integer data) {
		
		Node newNode = new Node();
		newNode.setData(data);
				
		if(root==null){
			root = newNode;
			return true;
		}else{
			Node temp = root, connector = null;						
			while(temp != null){
				connector = temp;
											
				if(temp.getData() == data){	// avoids duplicate entries in a BST.  
					return false;
				}
											
				if(data <= temp.getData()){	// if smaller go to left
					temp = temp.getLeft();
				}else{						// else go to right
					temp = temp.getRight();
				}
			}
											
			newNode.setParent(connector);	// connect new Node to its parent   
			if(data <= connector.getData()){
				connector.setLeft(newNode);
			}else{
				connector.setRight(newNode);
			}
											
			return true;
		}
		
	}
	
	
	
	
	/**   
	 	Traverses a BST in an in-order fashion.  
	 	
	 	Time Complexity = O(n)   
	 	@return	a list of data representing the in-order traversal of BST. 
	 */
	@Override
	public List<Integer> inorderTraverse() {
		return( inorder(root) );
	}
	
	private List<Integer> inorder(Node node){
		
		List<Integer> inorderData = new ArrayList<Integer>();
		
		while(!stk.empty() || node !=null){			
			if(node != null){
				stk.add(node);
				//System.out.println("push:  "+node.getData());
				node = node.getLeft();				
			}else{															
				node = (Node) stk.pop();
				System.out.print("  "+node.getData());
				inorderData.add(node.getData());
				node = node.getRight();		
			}
		}
		
		return inorderData;				
	}
	

	
	
	/**   
	 	Compute height/max depth of a BST. Height of tree = 2 means, it has level 0, 1 & 2.   
	 	
	 	Time Complexity = O(n) 
	 	@return	height of Binary Search Tree 
	 */
	@Override
	public long height(){
		return( computeLevels(root) + 1 );	// Height of tree = 2 means, it has level 0, 1 & 2. So add 1 before returning. 
	}
	
	private int computeLevels(Node node){
		
		if(node == null){
			return -1;	// Child of leaf node has height -1 & Leaf node has height 0. 
		}else{
			int lHeight = computeLevels(node.getLeft()); 
			int rHeight = computeLevels(node.getRight()); 		
			
			if(lHeight > rHeight){
				return (lHeight + 1);
			}else{
				return (rHeight + 1);
			}
		}
	}
	

	
	
	/**   
	 	Print Nodes of a BST level wise. Leaf Nodes are supposed to be at level 0 while Root is supposed to be at highest level. 
	 	
	 	Time Complexity = O(n^2) since for every level you go down(through all Nodes) & up to intended level starting from Root, to avoid this use the 'level order traversal with Queues'. 
	 	In this approach no extra space is required but a recursive call consumes more space.      
	 	@return	NA 
	 */
	@Override		
	public void levelPrint(){
		
		long height = height();	//	Height = 3 means tree has 0, 1, 2 levels. 
		int level = (int)(height-1);			//	for printing 
		
		for(int i=0;   i<=(int)(height-1);   i++){					// to start printing from root, reverse the for loop. 
			System.out.print("\nNodes at level:"+(level--)+"	");
			nodeAtLevel(root, i);
		}
				
	}
		
	/** Get Node at a particular level and print it's data / Level Order tree traversal.
	  
	  	@param node - represents rot node
	  	@param level - leaf represents level 0 & root is at highest level 
	 */
	private void nodeAtLevel(Node node, int level){
				
		if(level==0){
			System.out.print("  "+node.getData());
		}else{
			if(node.getLeft()!=null){
				nodeAtLevel(node.getLeft(), level-1);				
			}
			if(node.getRight()!=null){
				nodeAtLevel(node.getRight(), level-1);	
			}			
		}
		
	}
	
	
	
	
	/**
	 Print the tree in leave order fashion using a Queue. It also prints each level Nodes on separate line.  
	 
	 Time Complexity = O(n) & Space Complexity = O(n),	A improvement over recursive approach, however, with a Space complexity of O(n).
	 @param NA 
    */
	@Override
	public void levelPrintUsingQueue(){
		
		Queue<Node> queue = new LinkedBlockingQueue<Node>();
		Stack<Node> stack = new Stack<Node>();
		
		if(root == null){
			return;
		}else{															
			queue.add(root);
			stack.push(root);
			Node recentNode = null;
			
			int levelSize = queue.size(); 							// find size of queue, initially only root is present at top most level.
			
			while(!queue.isEmpty()){
													
					recentNode = queue.remove();
					System.out.print("  "+recentNode.getData());	// print a Node data.
					
					
					/* 4 lines help to print Reverse Level Orders. Also, reverse the below if conditions for queue to print correct order. */
					if(recentNode.getRight() != null){				 
						stack.push((recentNode).getRight());
					}												 
					if(recentNode.getLeft() != null){
						stack.push((recentNode).getLeft());
					}												
					/* End of changes for reverse order.  */
					
										
					if(recentNode.getLeft() != null){
						queue.add(recentNode.getLeft());
					}
					if(recentNode.getRight() != null){
						queue.add(recentNode.getRight());
					}
					

					// Every time one Node is removed, so decrease size by 1. Also, it's left & right children are added.  
					levelSize--;
					if(levelSize==0){
						System.out.println("");
						levelSize = queue.size();
					}
										
			}			
		}
		
		
		System.out.println("\n\nReverse Level Order traversal:  \n");
		while(!stack.isEmpty()){
			System.out.print(stack.pop().getData()+"  ");
		}
		
		
	}
	
	
	
	
	
	/**
	  Reverse level order traversal for BST. 
	  If we do normal level order traversal and instead of printing a node, push the node to a stack 
	  and then print contents of stack, we get reverse order. So to get the correct sequence (left to right at every level), 
	  we process children of a node in reverse order, we first push the right subtree to stack, then left subtree.  
	 
	  Note: Changes are made/suggested in the 'levelPrintUsingQueue' method. 	
	 
	  Time Complexity = O(n) & Space Complexity = O(n) 
	 @param NA 
   */

	
	
	
	/**
	 A fancy way to print nodes in BST. e.g. print Root, next print Nodes from Left to Right then print Nodes from Right to Left and so on...
	 
	 Time Complexity = O(n) & Space Complexity = O(n) as we traverse the Nodes, only once.	 
	 @param NA
	 */
	@Override
	public void spiralLevelPrint(){
		
		Stack<Node> stackA = new Stack<Node>();
		Stack<Node> stackB = new Stack<Node>();
		if(root == null){
			return;												
		}else{	
			Node recentNode = null;
			stackA.add(root);
			
			while(!stackA.isEmpty() || !stackB.isEmpty()){
				while(!stackA.isEmpty()){
					recentNode = stackA.pop();
					System.out.print("  "+recentNode.getData());
					if(recentNode.getLeft() != null){
						stackB.add(recentNode.getLeft());
					}
					if(recentNode.getRight() != null){
						stackB.add(recentNode.getRight());
					}
				}
				while(!stackB.isEmpty()){
					recentNode = stackB.pop();
					System.out.print("  "+recentNode.getData());
					if(recentNode.getRight() != null){
						stackA.add(recentNode.getRight());
					}
					if(recentNode.getLeft() != null){
						stackA.add(recentNode.getLeft());
					}
				}
			}
		}	
		
	}
	
	
	
	
	private List<Integer> dataList = null;
	/** Print all the Root to Leaf node paths in the BST.  
  	
  		Time Complexity = O(n) why not O(n^2) since for each path we already preserve the traversed Nodes and do not start all over again. 
  		Space Complexity = O(log n) since at any time we store at max (log n) number of Nodes.    
  		@param NA
  		@return NA
	 */	
	@Override
	public void rootToLeafPaths(){
		dataList = new ArrayList<Integer>();
		traverseRootToLeafNodes(root);
		dataList = null;
	}
	
	/**  Traverses the nodes and prints the path accordingly */
	private void traverseRootToLeafNodes(Node node){
		
		if(node == null){
			System.out.println("Tree is empty.");	return;
		}
		
		dataList.add(node.getData());
		
		if(node.getLeft()==null || node.getRight()==null){	// reached leaf node. 
			
			for(Integer dat : dataList){					// print the nodes from root to leaf. 
				System.out.print("  "+dat);					// here, we can also compute sum of all the nodes from root to leaf. 
			}
			System.out.println(); 
						
		}else{
			traverseRootToLeafNodes(node.getLeft());
			dataList.remove(dataList.size()-1);				// since left is visited and printed, remove it from list.
			traverseRootToLeafNodes(node.getRight());
			dataList.remove(dataList.size()-1);				// since right is visited and printed, remove it from list.
		}
		
	}
	
	
	
	
	/** Get all Leaf nodes in the BST.
	    
	    Time Complexity = O(n) since we traverse all the Nodes only ones.    
  		@param NA
  		@return List<Integer> - list of all the leaf nodes in the tree. null- if tree is empty. 
	 */	
	@Override	
	public List<Integer> getLeafNodes(){
		List<Integer> leafNodes = new ArrayList<Integer>();
		return (totalLeafNodes(root, leafNodes));
	}
	
	/** parse the tree and add node to the list if it's a leaf  */
	private List<Integer> totalLeafNodes(Node node, List<Integer> leafNodes){
		
		if(node == null){			// if tree is empty. 
			return null;
		}
		
		if(node.getLeft()==null && node.getRight()==null){	// if leaf node, add node to list. 
			leafNodes.add(node.getData());
		}
		
		totalLeafNodes(node.getLeft() , leafNodes);			// got to left sub tree. 
		totalLeafNodes(node.getRight(), leafNodes);
		
		return leafNodes;
		
	}
	
	
	
	
	/** Checks whether the tree is balanced. A tree is balanced if each of its left and right sub tree differ in height by at most 1.    
  	
  		Time Complexity = O(n^2)
  		@param NA
  		@return true- if tree is balanced, false - if tree is not balanced. 
	 */	
	@Override
	public boolean isHeightBalanced(){
		return (checkBalanced(root));
	}
	
	private boolean checkBalanced(Node node){
		
		if(node == null){
			return false;
		}
		
		int lHeight = computeLevels(node.getLeft()) + 1;	// compute levels will traverse at max 'n' Nodes. 
		int rHeight = computeLevels(node.getRight()) + 1;
		
		//System.out.println("L: "+lHeight+"   R: "+rHeight);
		
		checkBalanced(node.getLeft());
		checkBalanced(node.getRight());
		
		if(Math.abs(lHeight-rHeight) > 1){			// in a balanced tree, left and right sub tree differ in height by at most 1.  
			return false;
		}else{
			return true;
		}
					
	}
	
	
	
	
	/** 
	  Optimized version of checking whether tree is balanced. Idea is to check where tree is balanced at each Node. 
	  A tree is said to be balanced if Left and Right subtree at each Node differ in height by at most 1.    
	  
	  Time Complexity = O(n)   
	  @param NA  
	 */
	public boolean isTreeHeightBalanced(){
		if(isBalanced(root) == 0){
			return false;
		}else{
			return true;
		}
	}
	
	/** Check balance property at each Node */
	private int isBalanced(Node node){
		
		if(node == null){
			return 0;
		}
		
		int l = isBalanced(node.getLeft())+1;
		int r = isBalanced(node.getRight())+1;
		
		//System.out.println("Data:"+node.getData()+"   L: "+l+"   R: "+r);
		
		if(Math.abs(l-r) > 1){	// At any node, left sub tree and right sub tree should not differ in height by more than 1.
			return 0;
		}else{
			return l;
		}
		
	}
	
	
	
	
	/**
	  Find Least Common Ancestor of two given nodes in a Binary Search Tree. 
	  
	  Time Complexity = O(n)   
	  @param NA 
	 */
	@Override
	public Integer getLowestCommanAncestor(Integer value1, Integer value2){		
		return (findLowestCommanAncestor(root, value1, value2));
	}
	
	private Integer findLowestCommanAncestor(Node node, Integer findVal1, Integer findVal2){
		
		if(node==null){
			return null;
		}
						
		if((node.getData() > findVal1)  &&  (node.getData() > findVal2)){
			return findLowestCommanAncestor(node.getLeft(), findVal1, findVal2);
		}else if((node.getData() < findVal1)  &&  (node.getData() < findVal2)){
			return findLowestCommanAncestor(node.getRight(), findVal1, findVal2);
		} 
		
		return node.getData();
	}
	
	
	
	
	/**
	 *  To print all ancestors of a given node in a Binary Search Tree.
	 *  	1) Start traversing from Root. Add Root to array. 
	 *  	2) If currNode.data < findValue go left & add currNode.data to array.
	 *  	3) If currNode.data > findValue go right & add currNode.data to array. 
	 *  	4) If currNode.data == findValue. Print all array elements and currentNode.data    
	 *  
	 *  Time Complexity = O(log n) for balanced BST otherwise, O(n) for normal BST.
	 *    	
	 */
		
	
	
		
	/**
	  Check if Binary Tree satisfy a 'Sum Tree' property. A BST cannot satisfy this property. A normal Binary Tree might.
	  Sum Tree property := Each node in this tree is a sum of it's Left and Right sub tree.  
	  
	  @param NA
	  @return NA
	 */		
	@Override
	public boolean isSumTree(){
		if((root != null)  &&  (checkSumTree(root , 0) == root.getData())){
			return true;
		}else{
			return false;
		}	
	}
	
	private int checkSumTree(Node node, int sum){
		
		if(node == null){
			return 0;
		}
				
		int a = checkSumTree(node.getLeft(), 0);
		int b = checkSumTree(node.getRight(), 0);
		
		/*if(node != null && node.getLeft() != null && node.getRight() != null){
			System.out.println("Root - Left - Right    :    "+node.getData() +" "+ node.getLeft().getData() +" "+ node.getRight().getData());
		}*/		
		if(node.getData() == a + b){
			return node.getData();
		}else{
			return 0;
		}
							
	}
	
	
	
	
	private Stack<Node> s = new Stack<Node>();			// boundary printing, additional memory is required to store elements into Stack.
	/**
	 	This function prints the boundary Nodes of the tree. It follows 3 important steps.
	 		1. Printing all left most nodes in the tree.
	 		2. Printing all leaf nodes from inner sub trees.  
	 		3. Printing all right most nodes in the tree in reverse order.
	 	
	 	@param NA
	   	@return NA 
	 */
	public void printBoundaryNodes(){
		
		printLeftSideNodes(root);
		
		printLeafNodesFromSubTrees();
		
		printRightSideNodes(root);
		
	}
			
	private void printLeftSideNodes(Node node){
		
		while(node.getLeft()!=null){					
		
			System.out.print("\t"+node.getData());									
			
			if(node.getRight() != null){					
				s.add(node.getRight());
			}
			node = node.getLeft();
		}
		
		System.out.print("\t"+node.getData());
		
	}

	private void printLeafNodesFromSubTrees(){
		
		while(!s.isEmpty()){	
			
			Node currNode = s.pop();	
		
			while(currNode!=null){
			
				if(currNode.getRight()!=null){
					s.add(currNode.getRight());
				}else if(currNode.getLeft()==null && currNode.getRight()==null){
					System.out.print("\t"+currNode.getData());
				}
				currNode = currNode.getLeft();
			
			}			
		}
		
	}

	private void printRightSideNodes(Node node){
		
		while(node.getRight()!=null){									
			
			if(node.getRight() != null){
				s.add(node.getRight());				
			}			
			node = node.getRight();
		}
				
		Node prevNode = s.pop();
		if(prevNode.getLeft()!=null || prevNode.getRight()!=null){		// imp condition to take care of... 
			System.out.print("\t"+prevNode.getData());
		}
		
		while(!s.isEmpty()){
			System.out.print("\t"+s.pop().getData());
		}		
		
	}

	
	
	
	/**	
		Check if all Leaf nodes in the tree at same level. 
		
		@param NA 
		@return boolean - true if leaf nodes are at same level, else false. 
	
	*/
	public boolean areLeafsAtSameLeve(){
		
		if(checkLeafNodesLevel(root,0) == 0 ){
			return true;
		}else{
			return false;
		}
	}
	
	private int checkLeafNodesLevel(Node node, int level){
		
		if(node == null){
			return -1;
		}
		
		if(node.getLeft()==null  &&  node.getRight()==null){
			return level;
		}else{
			
			int lLevel = checkLeafNodesLevel(node.getLeft(), level+1);
			int rLevel = checkLeafNodesLevel(node.getRight(), level+1);
			
			//System.out.println("\nRNode: "+node.getRight().getData()+"\tL:"+rLevel+"\tLNode: "+node.getLeft().getData()+"\tL:"+lLevel);	}
			if(lLevel == rLevel){
				return 0;
			}
			
		}
	
		return -1;
	}
	
	
	
	
	private int currentLevel = -1;				// Predefined variable, needed
	/**	
		Left View of a BST. Print only those nodes which are in LEFT MOST POS of EACH LEVEL. 
		
		@param NA
		@return NA
	*/
	@Override
	public void printLeftView(){
		getLeftView(root, 0);
	}
	
	private Integer getLeftView(Node node, int level){
		
		if(node==null){
			return -1;
		}else{
			
			if(currentLevel!=level && level>currentLevel){		// note the conditions here. 
				currentLevel=level;
				System.out.print("\t"+node.getData());
			}
			
			getLeftView(node.getLeft(), level+1);
			getLeftView(node.getRight(), level+1);
			
		}
			
		return -1;
	}
	
	
	
		
	/**
	 A node is a sibling of other if, both are 'at Same Level' and they do not have same 'Parent'.  
	 
	 @param node1Data - a node whose cousin is to be determined.
	   		node2Data - a possible cousin of node1. 
	 @return true - if both nodes are cousins otherwise false. 
	  			
	 */
	@Override
	public boolean isCousin(Integer node1Data, Integer node2Data){
				
		//System.out.println("\n\n"+getLevel(root, node1Data, 0)+"   "+getLevel(root, node2Data, 0));		
		if( (getLevel(root, node1Data, 0)==getLevel(root, node2Data, 0))  &&  (areSiblings(root, node1Data, node2Data)) ){
			return true;			
		}
				
		return false;
	}
	
	private int getLevel(Node node, Integer data, int level){
		
		if(node==null){
			return -1; // node not found or tree has no data
		}
				
		if(data < node.getData()){
			return getLevel(node.getLeft(), data, level+1);
		}else if(data > node.getData()){
			return getLevel(node.getRight(), data, level+1);
		}else{
			return level;
		}
		
	}
	
	private boolean areSiblings(Node node, Integer node1Data, Integer node2Data){
		
		Node parent = null;
		while(node!=null){
						
			if(node1Data < node.getData()){
				parent = node;
				node = node.getLeft();
			}else if(node1Data > node.getData()){
				parent = node;
				node = node.getRight();
			}else{						// if equal i.e. node is found. 
				if( (parent.getLeft().getData()==node2Data)  ||  (parent.getRight().getData()==node2Data) ){
					return false;
				}else{
					return true;
				}
			}
			
		}
				
		return false;		// node1Data not found 
	}
	
	
	
	
	private Node currentDeepest = null;
	private Node parentNode = root;
	private int currentDepth = 0;
	/**
		It gives you the 'deepest left node' present in the BST. 
		
		@param NA
		@return NA
	*/
	@Override
	public Node getDeepestLeftNode(){
		findDeepestLeftNode(root, 0);
		return currentDeepest;	
	}
	
	private Node findDeepestLeftNode(Node node, int level){
		
		if(node==null){
			return null;
		}
		
		if(level > currentDepth  &&  parentNode.getLeft().getData() == node.getData() ){
			currentDepth = level;
			currentDeepest = node;
			//System.out.println("current deepest:  "+currentDeepest.getData());	// testing
		}
		
		if(node.getLeft() != null){
			parentNode = node;
			findDeepestLeftNode(node.getLeft(), level+1);
		}
		
		if(node.getRight() != null){
			parentNode = node;
			findDeepestLeftNode(node.getRight(), level+1);
		}
				
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	/*
 		current going on -  
	*/
		
	/*
	 	Left behind :- 	 
	  						  					
	  						  	---	PENDING ---			
	  						  					
	  					Bottom View of a Binary Tree
	  					
	  					Print Nodes in Top View of Binary Tree
	  
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}	// end of class    









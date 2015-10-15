/**
	@author Abhijeet Shankar Shedge
	@version 1.0  September 9, 2015
*/

package com.datastructure.linkedlist;

public final class DoublyLinkedList implements IList{

	// member variables of DLL
	private Node head = null;
	private Node tail = null;
	private long length = 0;
	
		
	/*
	 * Method:	add
	 * Return:	true - if Node was added successfully, false - if Node addition failed
	 * Description: this method adds a single Node to linked list or creates a head node if nothing exists. 
	 * 				it also maintains length of the list. 	 
	 */
	@Override
	public boolean add(Object data){
		
		Node newNode = new  Node();
		
		try{
			if(head == null){	// if no node exists, new Node is head Node.
				head = newNode;
				tail = head;
				newNode.setPrevious(null);
				newNode.setData(data);
				newNode.setNext(null);
				length++;
				return true;
			}else{
				tail.setNext(newNode);
				newNode.setPrevious(tail);
				tail = newNode;
				newNode.setData(data);
				newNode.setNext(null);				
				length++;
				return true;
			}
		}catch(NullPointerException e){	 
			return false;
		}
		
	}
	
	/*
	 * Method:	add
	 * Return: 	true - if Node was added successfully, false - if Node addition failed
	 * Description:	this is a zero indexed list. argument 'index' must be within 0 to length_of_list range. 
	 * 				data cannot be added to a location beyond the length of list.     
	 */
	public boolean add(long index, Object data){
		
		if(index  < 0 || index > length){	// out of bound
			return false;
		}else{
			int tempIndex = 0;
			Node tempNode = head;
			while(tempIndex != index){
				if(tempIndex != (length-1)){
					tempNode = tempNode.getNext();
				}
				tempIndex++;
			}

			
			Node newNode = new Node();
			newNode.setData(data);
			newNode.setNext(tempNode);
			
			if(index == length){							// insert after last node 
				newNode.setNext(null);
				newNode.setPrevious(tempNode);
				tempNode.setNext(newNode);
				tail = newNode;
			}else if(tempNode.getPrevious() != null){		// insert at middle
				newNode.setPrevious(tempNode.getPrevious());
				(tempNode.getPrevious()).setNext(newNode);
				newNode.setNext(tempNode);
			}else if(tempNode.getPrevious() == null){		// insert before head node
				newNode.setPrevious(null);
				tempNode.setPrevious(newNode);
				head = newNode;				
			}
											
			length++;										// length of list increases by 1.  
			return true;
		}
		
	}
	
	
	/*
	 * Method:	remove
	 * Return: 	true - if Object was successfully removed, false - if Object was not present or any error
	 * Description: removes a Object from List if present and updates the list length. Handles all cases such as 
	 * 				removing head node, last node or any middle node.  	 
	 */
	@Override
	public boolean remove(Object data){
		
		Node temp = head;
		
		try{
			while(temp != null){
				
				if(temp.getData().equals(data)){	// can compare objects and primitives. 
					
					if(temp.getPrevious() != null && temp.getNext() != null){	// a middle Node
						
						(temp.getPrevious()).setNext(temp.getNext());
						(temp.getNext()).setPrevious(temp.getPrevious());
						temp = null;
						length--;
						return true;
						
					}else if(temp.getPrevious() == null){	// a head Node
						
						if(temp.getNext() == null){			// a head Node alone
							head = null;
							tail = null;
						}else{								// a head Node succeeded by a Node
							head = temp.getNext();
							(temp.getNext()).setPrevious(null);
						}
						temp = null;
						length--;
						return true;
						
					}else if(temp.getNext() == null){		// a last Node
						
						(temp.getPrevious()).setNext(null);
						tail = temp.getPrevious();
						temp = null;
						length--;
						return true;
						
					}

				}
				temp = temp.getNext();	// if data doesn't match then move to next Node. 
			}
		}catch(NullPointerException e){
			return false;
		}
		
		return false;
	}

	/*
	 * Method:	remove
	 * Return: 	true - if Object was successfully removed, false - if Object was not present or any error
	 * Description: removes a Object  from List specified at a particular index and updates the list length. Handles all cases such as 
	 * 				removing head node, last node or any middle node.  	 
	 */
	@Override	
	public boolean remove(long index){

		if(index  < 0 || index >= length){	// out of bound
			return false;
		}else{
			int tempIndex = 0;
			Node tempNode = head;
			while(tempIndex != index){
				tempNode = tempNode.getNext();
				tempIndex++;
			}			

			if(tempNode.getPrevious() != null && tempNode.getNext() != null){	// remove form middle of list			 
				(tempNode.getPrevious()).setNext(tempNode.getNext());
				(tempNode.getNext()).setPrevious(tempNode.getPrevious());				
				tempNode = null;
			}else if(tempNode.getPrevious() == null){							// remove the head of list
				
				if(tempNode.getNext() == null){			// a head Node alone
					head = null;
					tail = null;
				}else{									// a head Node succeeded by a Node
					head = tempNode.getNext();
					(tempNode.getNext()).setPrevious(null);
					tempNode = null;
				}
				
			}else if(tempNode.getNext() == null){								// remove the last node				
				(tempNode.getPrevious()).setNext(null);
				tail = tempNode.getPrevious();		
				tempNode = null;
			}
											
			length--;															// length of list decreases by 1.  
			return true;
		}

	}
	
	
	/*
	 * Method:	get
	 * Return: 	data if index is within bound otherwise return null 
	 * Description:	iterates through the doubly linked list to get to the desired index.   
	 */
	public Object get(long index){
				
		if(index  < 0 || index > (length-1)){	// out of bound
			return null;
		}else{
			int tempIndex = 0;
			Node tempNode = head;
			while(tempIndex != index){
				tempNode = tempNode.getNext();
				tempIndex++;
			}
			return tempNode.getData();
		}
		
	}
	
	
	/*
	 * Method:	length
	 * Return: 	length/size of the present list. 
	 */
	@Override
	public long length() {
		return length;
	}
	

	
	
	
	
	/*
	 * Method: print - this method is used only for testing
	 */
	public void print(){
		
		Node temp = head;
		
		System.out.println("Length of list is: "+length);
		
		while(temp != null){
			System.out.println("Data in Doubly Linked List is: "+temp.getData());
			temp = temp.getNext();
		}
	}
	
	
	
	
	
	
	// Getter and Setter methods
	
	public Node getHead() {
		return head;
	}
	public void setHead(Node head) {
		this.head = head;
	}
	public Node getTail() {
		return tail;
	}
	public void setTail(Node tail) {
		this.tail = tail;
	}
	
	
	
}

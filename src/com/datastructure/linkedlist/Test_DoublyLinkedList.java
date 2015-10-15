/**
	@author Abhijeet Shankar Shedge
	@version 1.0  September 9, 2015
*/

package com.datastructure.linkedlist;



public class Test_DoublyLinkedList {
	
	public static void main(String[] args) {
			
		IList dll = new DoublyLinkedList();
		dll.add("A");
		dll.add("B");
		dll.add("C");
		dll.add("D");
		dll.add("E");
		dll.add("F");
		
		System.out.println("----------------------------------");	
		dll.print();
		
		dll.remove("A");		
		System.out.println("----------------------------------");
		dll.print();
		
		dll.remove("B");		
		System.out.println("----------------------------------");
		dll.print();
				
		dll.remove("F");		
		System.out.println("----------------------------------");
		dll.print();
		
		System.out.println("----------------------------------");
		System.out.println("size of list is:  "+dll.length());
		System.out.println("----------------------------------");
		
		System.out.println("Get element at 0: "+dll.get(0));		
		System.out.println("Get element at 1: "+dll.get(1));
		System.out.println("Get element at 2: "+dll.get(2));
		
		System.out.println("Get element at 3: "+dll.get(3));
		System.out.println("Get element at 3: "+dll.get(-1));
		System.out.println("Get element at 3: "+dll.get(0));
		
		System.out.println("----------------------------------");
		
		System.out.println("insert new element at end of list.");
		dll.add(dll.length(), "Z");
		
		dll.print();
		System.out.println("----------------------------------");
		
		System.out.println("insert new element. ");
		dll.add(4, "X");	// try -1 , 0 , dll.length()+1 , 20   
		
		dll.print();
		System.out.println("----------------------------------");
		
		System.out.println("Remove element at index 0");
		dll.remove(0);
		dll.print();
		System.out.println("----------------------------------");
		
		System.out.println("Remove element at index = (length-1)");
		dll.remove(dll.length()-1);
		dll.print();
		System.out.println("----------------------------------");
		
		
		System.out.println("Remove element at index 2");
		dll.remove(2);
		dll.print();
		System.out.println("----------------------------------");
		
		//List abc = new LinkedList();
		
	}
	
}

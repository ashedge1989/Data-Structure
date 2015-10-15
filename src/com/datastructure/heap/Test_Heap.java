/**
	@author Abhijeet Shankar Shedge
	@version 1.0  September 10, 2015
*/

package com.datastructure.heap;

import java.util.List;

public class Test_Heap {

	public static void main(String[] args) {
		
		Heap heapData = new Heap();
		heapData.add(2);
		heapData.add(60);
		heapData.add(50);
		heapData.add(1);
		heapData.add(89);
		heapData.add(10);
		
		Heap heapData1 = new Heap();
		heapData1.add(2);
		heapData1.add(60);
		heapData1.add(50);
		heapData1.add(1);
		heapData1.add(89);
		heapData1.add(10);
		
		
		System.out.println("Built a MAX Heap:");
		heapData.builtHeap(true);
		
		System.out.println("\n\nHeap after picking largest element:");
		System.out.println("\nLargest element picked is: "+heapData.peak());
		
		System.out.println("\n Heap Sort result:");
		List<Integer> sort = heapData.sort();
		for(int i=0; i<sort.size(); i++){
			System.out.print("  "+sort.get(i));
		}
		
		
		System.out.println("\n_________________________________________");
		
		
		
		System.out.println("\n\nBuilt a MIN Heap:");
		heapData1.builtHeap(false);
		
		System.out.println("\n\nHeap after picking smallest element:");
		System.out.println("\nSmallest element picked is: "+heapData1.peak());
		
		System.out.println("\n Heap Sort result:");
		List<Integer> sort1 = heapData1.sort();
		for(int i=0; i<sort1.size(); i++){
			System.out.print("  "+sort1.get(i));
		}
		
		
		
	}
	
	
	
}

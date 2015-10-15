/**
	@author Abhijeet Shankar Shedge
	@version 1.0  September 10, 2015
*/

package com.datastructure.heap;

import java.util.ArrayList;
import java.util.List;


/** Heap class to built MAX/MIN Heap, get largest/smallest element, sort Heap. */
public final class Heap implements IHeap{

	/** A dynamic array to store data for heap */
	private List<Integer> heapData = new ArrayList<Integer>();
	private boolean heapType = false;
	
	
	 
	/**   
	 	Inserts data into Heap.  
	 	@param data - Integer data to be inserted into Heap. 
	 	@return	Size of existing Heap. 
	 */
	@Override
	public int add(Integer data){
		heapData.add(heapData.size(), data);
		return (heapData.size());
	}
	
	
	 
	/**   
	 	Built a heap using values in the current list.   
	 	@param heapType - true if a MAX heap is to be built, false to built a MIN Heap.    
	 	@return	A list which represents the elements of the heap.    
	 */
	@Override
	public List<Integer> builtHeap(boolean heapType){
		
		this.heapType = heapType;
		
		for(int i=(int)(Math.floor(heapData.size()/2)); i>=0; i--){
			Heapify(heapData, i, heapType);	
		}		
		print();
		return heapData;
	}
	


	 
	/**   
	 	A routine to rearrange the array elements to form a MAX/MIN Heap.  
	 	@param  heapValues - a list of elements
	 	@param	index - position where this routine will be applied
	 	@param	heapType - true if MAX Heap, false if MIN Heap. 
	 	@return	NA 
	 */		
	private void Heapify(List<Integer> heapValues, int index, boolean heapType){
		
		int lChild = 2*index;
		int rChild = (2*index + 1);
		lChild += 1;	rChild += 1;	// since list is 0 indexed, compensate for child index.
		
		if(heapType == true){	// a MAX HEAP 
			int largest = index;
							
			if( (lChild < heapValues.size())  &&  (heapValues.get(index) > heapValues.get(lChild)) ){	// handle boundary conditions
				largest = index;
			}else{
				largest = lChild;
			}
			
			if( (rChild < heapValues.size())  &&  (heapValues.get(largest) < heapValues.get(rChild)) ){	// handle boundary conditions
				largest = rChild;
			}
			
			if((largest < heapValues.size())  &&  largest != index){				// swap largest and index
				heapValues.set(largest, heapValues.get(largest) + heapValues.get(index));
				heapValues.set(index, heapValues.get(largest) - heapValues.get(index));
				heapValues.set(largest, heapValues.get(largest) - heapValues.get(index));
				
				Heapify(heapValues, largest, true);
				
			}
		}else{					// a MIN HEAP
			int smallest = index;
			//System.out.println("L: "+lChild+"  R: "+rChild+"  index: "+index);
			
			if( (lChild < heapValues.size())  &&  (heapValues.get(index) < heapValues.get(lChild)) ){	// handle boundary conditions
				smallest = index;
			}else{
				smallest = lChild;
			}
			
			if( (rChild < heapValues.size())  &&  (heapValues.get(smallest) > heapValues.get(rChild)) ){	// handle boundary conditions
				smallest = rChild;
			}
			
			if((smallest < heapValues.size())  &&  smallest != index){				// swap smallest and index
				//System.out.println("Swap: "+heapValues.get(index)+"  "+heapValues.get(smallest));
				heapValues.set(smallest, heapValues.get(smallest) + heapValues.get(index));
				heapValues.set(index, heapValues.get(smallest) - heapValues.get(index));
				heapValues.set(smallest, heapValues.get(smallest) - heapValues.get(index));
			}			
		}
		
	}

	
	 
	/**   
	 	Gives the smallest/largest element in the Heap depending on it's type.    
	 	@param NA    
	 	@return	Largest/Smallest element in Heap, depending on it's type.     
	 */
	@Override
	public Integer peak(){
		
		int peakValue = heapData.get(0);
		
		heapData.set(0, heapData.get(heapData.size()-1));
		heapData.remove(heapData.size()-1);		// delete the first element & replace with last element. 
		
		Heapify(heapData, 0, this.heapType);	// to rearrange the Heap as MAX/MIN heap. 
		
		print();	// for testing 
		
		return peakValue;
	}
	
	

	/**   
 		Sorts the existing Heap.    
 		@param NA    
 		@return	A list of sorted elements from existing Heap.      
	 */
	@Override
	public List<Integer> sort() {
		// Can perform in place sort. This implementation replicates data to avoid changing the original heap data for users reuse.
		List<Integer> sortedList = new ArrayList<Integer>();	 
		List<Integer> tempList   = new ArrayList<Integer>();
		tempList.addAll(heapData);
		
		int size = tempList.size();
		for(int i=0; i<size; i++){
			sortedList.add(tempList.remove(0)); 
			Heapify(tempList, 0, heapType);
		}
		tempList = null;	
		
		return sortedList;
	}

	
	
	
	
	// to test the program
	private void print(){
		for(int i=0; i<heapData.size(); i++){
			System.out.print("  "+heapData.get(i));
		}
	}


	

}

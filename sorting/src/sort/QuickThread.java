package sort;

import java.util.Random;
import java.util.concurrent.RecursiveAction;

public class QuickThread extends RecursiveAction {
	  private int[] arr;
	  private int leftIndex;
	  private int rightIndex;
	  
	  /**
	   * constructor in case one element is passed in
	   * @param a - passed in int array
	   */
	  public QuickThread(int[] a) {
		  
		//sets the passed in int array to the int array for the class  
	    this.arr = a;
	    
	    //sets leftIndex to 0
	    leftIndex = 0;
	    
	    //sets rightIndex to the length of the passed in array-1
	    rightIndex = a.length - 1;
	  }
	  
	  /**
	   * constructor in case three elements are passed in
	   * @param a - passed in int array
	   * @param left - passed in value for left index
	   * @param right - passed in value for right index
	   */
	  public QuickThread(int[] a, int left, int right) {
		  
		//sets the passed in int array to the int array for the class  
	    this.arr = a;
	    
	    //sets the passed in right to the rightIndex of the class
	    this.leftIndex = left;
	    
	    //sets the passed in left to the leftIndex of the class
	    this.rightIndex = right;
	  }
	  
	  /**
	   * compute function for RecursiveAction that performs QuickSort using two threads
	   */
	  @Override
	  protected void compute() {
		  
		 //checks if the array length is greater than 100 
		 if(arr.length > 100) {
			 
			 //checks if the leftIndex is less than the rightIndex
			 if(leftIndex < rightIndex){
				 
				 //gets partIndex using the getPartitionIndex method
				 int partIndex = getPartitionIndex(arr, leftIndex, rightIndex);
				 
				 //creates an instance of QuickThread for leftThread that passes in the part of the array to the left of the partIndex
				 QuickThread leftThread = new QuickThread(arr,leftIndex, partIndex);
				 
				 //creates an instance of QuickThread for rightThread that passes in the part of the array to the right of the partIndex
				 QuickThread rightThread = new QuickThread(arr, partIndex + 1, rightIndex);
				 
				 //forks the leftThread
				 leftThread.fork();
				 
				 //forks the rightThread
				 rightThread.fork();
				 
				 //joins the leftThread
				 leftThread.join();
				 
				 //joins the rightThread
				 rightThread.join();
				 
			 } else {
				 //if rightIndex is greater than or equal to leftIndex then sorting is done
				 return;
			 }
		 } else {
			 //if the array legnth is less than 100 then selection sort is run on the array
			 SelectionSort.sort(arr);
		 }
	  }
	  
	  /**
	   * function that returns the partition index and sorts the passed in array
	   * @param a - passed in int array
	   * @param low - low index value
	   * @param high - high index value
	   * @return - the index for partitioning the array
	   */
	  int getPartitionIndex(int[] a, int low, int high) {
		
		//define pivot value, lowIndex and highIndex
	    int pivot = a[low];
	    int lowIndex = low - 1;
	    int highIndex  = high + 1;
	    
	    //loop forever
	    while (true){
	      
	      //keep incrementing lowIndex until the element in the array at index lowIndex
	      //is less than pivot
	      do {
	    	  lowIndex++;
	      }
	      while (a[lowIndex] < pivot);
	      
	      //keep decrementing highIndex until the element in the array at index highIndex
	      //is greater than pivot
	      do {
	    	  highIndex--;
	      }
	      while (a[highIndex] > pivot); 
	      
	      //if lowIndex becomes greater than or equal to highIndex then the loop breaks and
	      //highIndex is returned
	      if (lowIndex >= highIndex) {
	    	  return highIndex;
	      }
	      
	      //the elements at lowIndex and highIndex of the array are swapped
	      int temp = a[lowIndex];
	      a[lowIndex] = a[highIndex];
	      a[highIndex] = temp;
	    }
	  }
}

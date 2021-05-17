package sort;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;


public class MergeThread extends RecursiveAction {
	
    int arr[];
    int leftIndex;
    int rightIndex;
    
    /**
     * constructor for one passed in element
     * @param a - passed in array
     */
    MergeThread(int[] a) {
    	
    	//sets the array of the class equal to the passed in array
    	this.arr = a;
    	
    	//sets leftIndex to 0
    	this.leftIndex = 0;
    	
    	//sets rightIndex to the length of the array-1
    	this.rightIndex = a.length - 1;
    }
    
    /**
     * constructor for three passed in elements
     * @param arr - passed in array
     * @param leftIndex - index for the left most range for sorting desired with the array
     * @param rightIndex - index for the right most range for sorting desired with the array
     */
    MergeThread(int[] arr, int leftIndex, int rightIndex) {
    	
    	//sets the array of the class equal to the passed in array
    	this.arr = arr;
    	
    	//sets leftIndex of the class to the passed in leftIndex
    	this.leftIndex = leftIndex;
    	
    	//sets the rightIndex of the class to the passed in rightIndex
        this.rightIndex = rightIndex;
    }
    
    /**
     * compute function for RecursiveAction that performs MergeSort using two threads
     */
    protected void compute() {
    	
    	//variable for sorting range that is rightIndex-leftIndex
    	int sortRange = rightIndex - leftIndex; 
    	
    	//checks if the length of the array is greater than 100
    	if(arr.length > 100) {
    		
    		//checks that the leftIndex is less than the rightIndex
    		if (leftIndex < rightIndex) {
                
    			//finds the middle of the array
                int middle = leftIndex + sortRange/2;
                
                //creates an instance of MergeThread for the leftThread that only passes in the left half of the array
                MergeThread leftThread = new MergeThread(arr,leftIndex,middle);
                 
                //creates an instance of the MergeThread for the rightThread that only passes in the right half of the array
                MergeThread rightThread = new MergeThread(arr,middle+1,rightIndex);
                
                //forks the leftThread
                leftThread.fork();
                
                //forks the rightThread
                rightThread.fork();
                
                //joins the leftThread
                leftThread.join();
                
                //joins the rightThread
                rightThread.join();
                
                //runs mergeSort for the whole array
                mergeSort(arr, leftIndex, middle, rightIndex);
                     
            } else {
            	//if rightIndex is greater than or equal to leftIndex then sorting is done
            	return;
            }
    	} else {
    		//if the legnth of the array is less than 100 then selection sort is run
    		SelectionSort.sort(arr);
        }
    }
    
    /**
     * algorithm for merge sorting
     * @param array - passed in array
     * @param leftI - left index
     * @param middleI - middle index
     * @param rightI - right index
     */
    void mergeSort(int[] array, int leftI, int middleI, int rightI) {
    	
    	//defines array sizes of the left and right array
        int leftSize = middleI - leftI + 1;
        int rightSize = rightI - middleI;

        //create the left and right array with the previously defined sizes
        int leftArray[] = new int [leftSize];
        int rightArray[] = new int [rightSize];
          
        //loop through the left half of the main array to initialize the leftArray
        for (int i=0; i<leftSize; i++) {
        	leftArray[i] = array[leftI + i];
        }
        
        //loop through the right half of the main array to initialize the rightArray
        for (int i=0; i<rightSize; ++i) {
        	rightArray[i] = array[middleI + 1 + i];
        }
          
        //the three indices for the left, right and main array
        int leftIndex = 0;
        int rightIndex = 0;
        int mainIndex = leftI;
        
        //while loop to loop through the right and left array as long as the
        //left and right indices are both less than the array size for the left and right array
        while (leftIndex < leftSize && rightIndex < rightSize) {
        	
        	//checks if the element at the leftIndex of the leftArray is 
        	//less than or equal to the rightIndex of the rightArray
        	if (leftArray[leftIndex] <= rightArray[rightIndex]) {
        		
        		//if it is then the mainIndex of the array is made equal to the leftIndex of the leftArray
        		array[mainIndex] = leftArray[leftIndex];
        		
        		//increments the leftIndex
        		leftIndex++;
            } else {
            	
            	//otherwise the mainIndedx of the array is made equal to the rightIndex of the rightArray
            	array[mainIndex] = rightArray[rightIndex];
            	
            	//increments the rightIndex
            	rightIndex++;
            }
        	
        	//increments the mainIndex
            mainIndex++;
        }
          
        //while loop to go through the leftArray if leftIndex is still less than the size of the leftArray
        while (leftIndex < leftSize) {
        	
        	//sets the mainIndex of the main array equal to the leftIndex of the leftArray
        	array[mainIndex] = leftArray[leftIndex];
        	
        	//increments the leftIndex
        	leftIndex++;
        	
        	//increments the mainIndex
            mainIndex++;
        }
        
        //while loop to go through the rightArray if rightIndex is still less than the size of the rightArray
        while (rightIndex < rightSize) {
        	
        	//sets the mainIndex of the main array equal to the rightIndex of the rightArray
        	array[mainIndex] = rightArray[rightIndex];
        	
        	//increments the rightIndex
        	rightIndex++;
        	
        	//increments the mainIndex
            mainIndex++;
        }
                            
    }
          
}

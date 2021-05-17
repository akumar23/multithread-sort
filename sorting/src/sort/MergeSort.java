package sort;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;


public class MergeSort {

	  	static int[] arr;
	  
	  	/**
		 * generates a random array by passing in random integers to each index of the array
		 * @param a - passed in array
		 */
		static void genRandomArray(int[] a) {
			for(int i=0; i<a.length; i++) {
				a[i] = (int) (Math.random() * 50);
			}
		}
		
		/**
		 * checks if the passed in array is sorted
		 * @param a - the passed in array
		 * @return - true if it is sorted, false otherwise
		 */
		static boolean isSorted(int[] a) {
			for(int i=0; i<a.length-1; i++) {
				if(a[i] > a[i+1]) {
					return false;
				}
			}
			return true;
		}
		
		/**
		 * prints the passed in array
		 * @param a - the passed in array
		 */
		static void printArr(int[] a) {
			for(int i=0; i<a.length; i++) {
				System.out.print(a[i] + ",");
			}
			System.out.println();
		}
		
		/**
		 * copies on array into another
		 * @param a - the array from which the elements are copied
		 * @param b - the array that gets copied into
		 */
		static void copyArr(int[] a, int[] b) {
			if(a.length == b.length) {
				for(int i=0; i<a.length; i++) {
					b[i] = a[i];
				}
			} else {
				System.out.println("Arrays should be of equal length for this array");
			}
		}
		
		/**
		 * creates an instance of the MergeThread class and runs it
		 * @param arr
		 */
		static void runMergeThread(int[] arr) {
			MergeThread mergeSort = new MergeThread(arr);
			
		    ForkJoinPool pool = new ForkJoinPool();
		    pool.invoke(mergeSort);

		    pool.shutdown();
				
		}
		
	  public static void main(String[] args) {
			
		  	//declares the size of the array
		  	int size = 1000;
			
		  	//Initializes the array of the class with that size
			arr = new int[size];
			
			//generates a random array into the array of the class
			genRandomArray(arr);
			
			//creates an array for normal sort and merge sort with the previously declared size
			int[] normalSortArr = new int[size];
			int[] mergeArr = new int[size];
			
			//copies the array of the class into the array for normal sort and merge sort
			copyArr(arr, normalSortArr);
			copyArr(arr, mergeArr);
			
			//prints the array for normal sort before sorting
			System.out.println("Array before sorting: ");
			printArr(normalSortArr);
			
			//start time for normal sorting
			long start = System.nanoTime();
			
			//sorts the array for normal sorting with Arrays.sort
			Arrays.sort(normalSortArr, 0, size);
			
			//end time for normal sorting
			long end = System.nanoTime();
			
			//checks if the normal array is sorted then prints it
			if(isSorted(normalSortArr)) {
				System.out.println("Array after sorting: ");
				printArr(normalSortArr);
			}
			
			//calculating total time taken to run program
			long tot = end - start;
			
			//converting nanoseconds to seconds
			double programTimeSeconds = (double) tot/1000000000;
			
			//printing total time taken to run the program
			System.out.println();
			System.out.println("Total run time for normal sorting: " + programTimeSeconds + " seconds");
			
			//prints the merge sort array before sorting
			System.out.println();
			System.out.println("Array before merge sorting: ");
			printArr(mergeArr);
			
			//start time for merge sort
			start = System.nanoTime();
			
			//creates an instance of the MergeThread class
			MergeThread mergeSort = new MergeThread(mergeArr);
			
			//creates a ForkJoinPool
		    ForkJoinPool pool = new ForkJoinPool();
		    
		    //invokes the pool with the instances of the MergeThread class
		    pool.invoke(mergeSort);

		    //shuts down the pool
		    pool.shutdown();
				
		    
		    //end time for merge sort
			end = System.nanoTime();
			
			//calculating total time taken to run program
			tot = end - start;
			
			//checks if the merge array is sorted and prints it
			if(isSorted(mergeArr)) {
				System.out.println("Array after merge sorting: ");
				printArr(mergeArr);
			}
			
			//converting nanoseconds to seconds
			programTimeSeconds = (double) tot/1000000000;
			
			//printing total time taken to run the program
			System.out.println();
			System.out.println("Total run time for parallel merge sorting: " + programTimeSeconds + " seconds");
			
			//checks if both arrays were sorted and prints ARRAY SORTED if they are
			//other wise prints ARRAY ISN'T SORTED
			if(isSorted(mergeArr) && isSorted(normalSortArr)) {
				System.out.println("ARRAY SORTED");
			} else {
				System.out.println("ARRAY ISN'T SORTED");
			}
		}
}

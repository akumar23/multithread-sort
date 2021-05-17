package sort;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class QuickSort {
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
		 * creates an instance of the QuickThread class and runs it
		 * @param arr - the array that gets passed in
		 */
		static void runQuickThread(int[] arr) {
			QuickThread quickSort = new QuickThread(arr);
			
		    ForkJoinPool pool = new ForkJoinPool();
		    pool.invoke(quickSort);

		    pool.shutdown();
		}
		
	  public static void main(String[] args) {
		  	
		    //declares the size of the array
			int size = 1000;
			
			//Initializes the array of the class with that size
			arr = new int[size];
			
			//generates a random array into the array of the class
			genRandomArray(arr);
			
			//creates an array for normal sorting and quick sorting
			int[] normalSortArr = new int[size];
			int[] quickSortArr = new int[size];
			
			//copies the array of the class into both of the previous arrays
			copyArr(arr, normalSortArr);
			copyArr(arr, quickSortArr);
			
			//prints the normalSortArr
			System.out.println("Array before normal sorting: ");
			printArr(normalSortArr);
			
			//start time for normal sorting
			long start = System.nanoTime();
			
			//uses Arrays.sort to sort the normalSortArr
			Arrays.sort(normalSortArr, 0, size);
			
			//end time for normal sorting
			long end = System.nanoTime();
			
			//checks if the array is sorted then prints it
			if(isSorted(normalSortArr)) {
				System.out.println("Array after normal sorting: ");
				printArr(normalSortArr);
			}
			
			//calculating total time taken to run program
			long tot = end - start;
			
			//converting nanoseconds to seconds
			double totTimeSec = (double) tot/1000000000;
			
			//printing total time taken to run the program
			System.out.println();
			System.out.println("Total run time for normal sorting: " + totTimeSec + " seconds");
			
			//prints the quick sort array before sorting
			System.out.println("Array before quick sorting: ");
			printArr(quickSortArr);
			
			//start time for quick sort
			start = System.nanoTime();
			
			//creates an instance of the QuickThread class, passing in the quick sort array
			QuickThread quickSort = new QuickThread(quickSortArr);
			
			//creates a ForkJoin pool
		    ForkJoinPool pool = new ForkJoinPool();
		    
		    //invokes the pool with the instance of the QuickThread class
		    pool.invoke(quickSort);
		    
		    //shuts down the pool
		    pool.shutdown();
		    
		    //end time for quick sort
			end = System.nanoTime();
			
			//calculating total time taken to run program
			tot = end - start;
			
			//converting nanoseconds to seconds
			totTimeSec = (double) tot / 1000000000;
			
			//checks of the quick sort array is sorted and prints it
			if(isSorted(quickSortArr)){
				System.out.println("Array after quick sorting: ");
				printArr(quickSortArr);
			}
			
			//printing total time taken to run the program
			System.out.println();
			System.out.println("Total run time for parallel quick sorting: " + totTimeSec + " seconds");
			
			//checks if both arrays were sorted and prints ARRAY SORTED if they are
			//other wise prints ARRAY ISN'T SORTED
			if(isSorted(quickSortArr) && isSorted(normalSortArr)) {
				System.out.println("ARRAY SORTED");
			} else {
				System.out.println("ARRAY ISN'T SORTED");
			}
		}
}




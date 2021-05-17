package sort;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class QuickSort {
	  static int[] arr;
	  
		/**
		 * 
		 * @param a
		 */
		static void genRandomArray(int[] a) {
			for(int i=0; i<a.length; i++) {
				a[i] = (int) (Math.random() * 50);
			}
		}
		
		/**
		 * 
		 * @param a
		 * @return
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
		 * 
		 * @param a
		 */
		static void printArr(int[] a) {
			for(int i=0; i<a.length; i++) {
				System.out.print(a[i] + ",");
			}
			System.out.println();
		}
		
		/**
		 * 
		 * @param a
		 * @param b
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
		 * 
		 * @param arr
		 */
		static void runQuickThread(int[] arr) {
			QuickThread quickSort = new QuickThread(arr);
			
		    ForkJoinPool pool = new ForkJoinPool();
		    pool.invoke(quickSort);

		    pool.shutdown();
		}
		
	  public static void main(String[] args) {
			int size = 1000;
			
			arr = new int[size];
			
			genRandomArray(arr);
			
			int[] normalSortArr = new int[size];
			int[] quickSortArr = new int[size];
			
			copyArr(arr, normalSortArr);
			copyArr(arr, quickSortArr);
			
			
			System.out.println("Array before normal sorting: ");
			printArr(normalSortArr);
			long start = System.nanoTime();
			Arrays.sort(normalSortArr, 0, size);
			long end = System.nanoTime();
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
			
			
			System.out.println("Array before quick sorting: ");
			printArr(quickSortArr);
			
			start = System.nanoTime();
			QuickThread quickSort = new QuickThread(quickSortArr);
			
		    ForkJoinPool pool = new ForkJoinPool();
		    pool.invoke(quickSort);

		    pool.shutdown();
			end = System.nanoTime();
			
			//calculating total time taken to run program
			tot = end - start;
			
			//converting nanoseconds to seconds
			totTimeSec = (double) tot / 1000000000;
			
			if(isSorted(quickSortArr)){
				System.out.println("Array after quick sorting: ");
				printArr(quickSortArr);
			}
			
			//printing total time taken to run the program
			System.out.println();
			System.out.println("Total run time for parallel quick sorting: " + totTimeSec + " seconds");
			
			if(isSorted(quickSortArr) && isSorted(normalSortArr)) {
				System.out.println("ARRAY SORTED");
			} else {
				System.out.println("ARRAY ISN'T SORTED");
			}
		}
}


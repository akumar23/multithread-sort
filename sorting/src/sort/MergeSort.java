package sort;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;


public class MergeSort {

	  static int[] arr;
	  
		/**
		 * 
		 * @param a
		 */
		static void genRandomArray(int[] a) {
			for(int i=0; i<a.length; i++) {
				a[i] = (int) (Math.random() * a.length);
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
		static void runMergeThread(int[] arr) {
			MergeThread mergeSort = new MergeThread(arr);
			//mergeSort.sort(mergeArr);
			
		    ForkJoinPool pool = new ForkJoinPool();
		    pool.invoke(mergeSort);

		    pool.shutdown();
				
		}
		
	  public static void main(String[] args) {
			int size = 1000;
			
			arr = new int[size];
			
			genRandomArray(arr);
			
			int[] normalSortArr = new int[size];
			int[] mergeArr = new int[size];
			
			copyArr(arr, normalSortArr);
			copyArr(arr, mergeArr);
			
			
			System.out.println("Array before sorting: ");
			printArr(normalSortArr);
			long start = System.nanoTime();
			Arrays.sort(normalSortArr, 0, size);
			long end = System.nanoTime();
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
			
			System.out.println();
			System.out.println("Array before merge sorting: ");
			printArr(mergeArr);
			
			start = System.nanoTime();
			
			MergeThread mergeSort = new MergeThread(mergeArr);
			//mergeSort.sort(mergeArr);
			
		    ForkJoinPool pool = new ForkJoinPool();
		    pool.invoke(mergeSort);

		    pool.shutdown();
				
			end = System.nanoTime();
			
			//calculating total time taken to run program
			tot = end - start;
			
			if(isSorted(mergeArr)) {
				System.out.println("Array after merge sorting: ");
				printArr(mergeArr);
			}
			
			//converting nanoseconds to seconds
			programTimeSeconds = (double) tot/1000000000;
			
			//printing total time taken to run the program
			System.out.println();
			System.out.println("Total run time for parallel merge sorting: " + programTimeSeconds + " seconds");
			
			if(isSorted(mergeArr) && isSorted(normalSortArr)) {
				System.out.println("ARRAY SORTED");
			} else {
				System.out.println("ARRAY ISN'T SORTED");
			}
		}
}
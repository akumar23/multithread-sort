package sort;


public class sort extends Thread {
	
	static int[] arr = new int[50];
	static int[] mergeArray = new int[arr.length/2];
	static int[] quickArray = new int[arr.length/2];
	
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
	 */
	static void splitArray(int[] a) {
		for(int i=0; i<arr.length/2; i++) {
			mergeArray[i] = a[i];
		}
		
		int index = 0;
		for(int i = arr.length/2; i<arr.length; i++) {
			quickArray[index] = a[i];
			index++;
		}
	}
	
	
	/**
	 * 
	 * @param a
	 * @param array1
	 * @param array2
	 * @param size1
	 * @param size2
	 */
	static void sortTwoArrays(int a[], int array1[], int array2[], int size1,int size2) {
		int arrayOneI = 0;
		int arrayTwoI = 0;
		int mergedArrayI = 0;
		
		while(arrayOneI < size1 && arrayTwoI < size2) {
			if(array1[arrayOneI] <= array2[arrayTwoI]) {
				a[mergedArrayI] = array1[arrayOneI];
				arrayOneI++;
			} else {
				a[mergedArrayI] = array2[arrayTwoI];
				arrayTwoI++;
			}
			mergedArrayI++;
		}
		
		while(arrayOneI < size1) {
			a[mergedArrayI] = array1[arrayOneI];
			arrayOneI++;
			mergedArrayI++;
		}
		
		while(arrayTwoI < size2) {
			a[mergedArrayI] = array2[arrayTwoI];
			arrayTwoI++;
			mergedArrayI++;
		}
		
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		
		genRandomArray(arr);
		System.out.println("Unsorted array: ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println();
		
		splitArray(arr);
		
		System.out.println();
		System.out.println("Unsorted array for quick sort: ");
		for(int i=0; i<quickArray.length; i++) {
			System.out.print(quickArray[i] + ",");
		}
		System.out.println();

		System.out.println("Unsorted array for merge sort: ");
		for(int i=0; i<mergeArray.length; i++) {
			System.out.print(mergeArray[i] + ",");
		}
		System.out.println();
		
		//variable to hold system time when sorting starts
		long start = System.nanoTime();
		
		//creates MergeSort class called merge and passes in mergeArray
		MergeSort merge = new MergeSort(mergeArray);
		
		//creates QuickSort class called quick and passes in quickArray
		QuickSort quick = new QuickSort(quickArray);
		
		System.out.println("\ncreating threads: ");
		//starts merge thread
		merge.start();
		System.out.println("merge sort thread ID: " + merge.getId());
		
		//starts quick thread
		quick.start();
		System.out.println("quick sort thread ID: " + quick.getId());
		
		//tries to join the threads
		try {
			merge.join();
			quick.join();
		} catch (InterruptedException e) {
			System.out.print(e.getMessage());
		}
		
		//combines the part of the array sorted by merge sort and part of array sorted by quick sort and merges them
		sortTwoArrays(arr, mergeArray, quickArray, mergeArray.length, quickArray.length);
		QuickSort finalMerge = new QuickSort(arr);
		finalMerge.start();
		try {
			finalMerge.join();
		} catch (InterruptedException e) {
			System.out.print(e.getMessage());
		}
		
		//variable to hold system time when sorting ends
		long end   = System.nanoTime();
		
		//prints part of the array sorted with merge sort
		System.out.println();
		System.out.println("Sorted array for merge sort: ");
		for(int i=0; i<mergeArray.length; i++) {
			System.out.print(mergeArray[i] + ",");
		}
		System.out.println();
		
		//prints part of the array sorted with quick sort
		System.out.println("Sorted array for quick sort: ");
		for(int i=0; i<quickArray.length; i++) {
			System.out.print(quickArray[i] + ",");
		}
		System.out.println();
		
		//prints overall sorted array
		System.out.println();
		System.out.println("Sorted overall array: ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println();
		
		//calculating total time taken to run program
		long tot = end - start;
		
		//converting nanoseconds to seconds
		double programTimeSeconds = (double) tot / 1_000_000_000.0;
		
		//printing total time taken to run the program
		System.out.println();
		System.out.println("Total run time: " + programTimeSeconds + " seconds");
		
	}
	
}

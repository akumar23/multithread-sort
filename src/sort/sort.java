package sort;

public class sort extends Thread {
	static final int N = 2;
	static int[] arr = new int[]{7,12,19,3,18,4,2,6,15,8};
	static int[] mergeArray = new int[arr.length/2];
	static int[] quickArray = new int[arr.length/2];
	
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
	static void generalSort(int a[], int array1[], int array2[], int size1,int size2) {
		int rightArrayI = 0;
		int leftArrayI = 0;
		int mergedArrayI = 0;
		
		while(leftArrayI < size1 && rightArrayI < size2) {
			if(array1[leftArrayI] <= array2[rightArrayI]) {
				a[mergedArrayI] = array1[leftArrayI];
				leftArrayI++;
			} else {
				a[mergedArrayI] = array2[rightArrayI];
				rightArrayI++;
			}
			mergedArrayI++;
		}
		
		while(leftArrayI < size1) {
			a[mergedArrayI] = array1[leftArrayI];
			leftArrayI++;
			mergedArrayI++;
		}
		
		while(rightArrayI < size2) {
			a[mergedArrayI] = array2[rightArrayI];
			rightArrayI++;
			mergedArrayI++;
		}
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		
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
		
		//starts merge thread
		merge.start();
		
		//starts quick thread
		quick.start();
		
		//tries to join the threads
		try {
			merge.join();
			quick.join();
		} catch (InterruptedException e) {
			System.out.print(e.getMessage());
		}
		
		//combines the part of the array sorted by merge sort and part of array sorted by quick sort and merges them
		generalSort(arr, mergeArray, quickArray, mergeArray.length, quickArray.length);
		
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

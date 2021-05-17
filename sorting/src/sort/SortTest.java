package sort;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class SortTest {
	
	//creating 5 arrays for merge sort testing
	int[] mergeArr1;
	int[] mergeArr2;
	int[] mergeArr3;
	int[] mergeArr4;
	int[] mergeArr5;
	
	//creating 5 arrays for quick sort testing
	int[] quickArr1;
	int[] quickArr2;
	int[] quickArr3;
	int[] quickArr4;
	int[] quickArr5;
	
	/*
	 * steps taken before testing starts
	 */
	@BeforeEach
	public void callSort() {
		
		//creates a new instance of MergeSort to have access to the genRandomArray method
		MergeSort m = new MergeSort();
		
		//initalizes each array with different values from 50 to 1000000
		mergeArr1 = new int[(int) (Math.random() * 50)];
		mergeArr2 = new int[(int) (Math.random() * 500)];
		mergeArr3 = new int[(int) (Math.random() * 10000)];
		mergeArr4 = new int[(int) (Math.random() * 100000)];
		mergeArr5 = new int[(int) (Math.random() * 1000000)];
		
		//calls genRaomdArray to fill all 5 arrays for merge sort testing
		m.genRandomArray(mergeArr1);
		m.genRandomArray(mergeArr2);
		m.genRandomArray(mergeArr3);
		m.genRandomArray(mergeArr4);
		m.genRandomArray(mergeArr5);
		
		//initalizes each array with different values from 50 to 1000000
		quickArr1 = new int[(int) (Math.random() * 50)];
		quickArr2 = new int[(int) (Math.random() * 500)];
		quickArr3 = new int[(int) (Math.random() * 10000)];
		quickArr4 = new int[(int) (Math.random() * 100000)];
		quickArr5 = new int[(int) (Math.random() * 1000000)];
		
		//calls genRandomArray to fill all 5 arrays for quick sort testing
		m.genRandomArray(quickArr1);
		m.genRandomArray(quickArr2);
		m.genRandomArray(quickArr3);
		m.genRandomArray(quickArr4);
		m.genRandomArray(quickArr5);
		
	}
	
	/*
	 * method for merge sort testing
	 */
	@Test
	@DisplayName("Check That MergeSort Works")
	void testMerge() {
		
		//runs the MergeThread for mergeArr1
		MergeSort.runMergeThread(mergeArr1);
		boolean mergeTest1;
		
		//checks if mergeArr1 is sorted
		mergeTest1 = MergeSort.isSorted(mergeArr1);
		
		//asserts if mergeArr1 is sorted
		assert(mergeTest1);
		
		//if mergeTest1 is sorted then passed is printed otherwise fail is printed
		if(mergeTest1) {
			System.out.println("Merge Test 1: passed");
		} else {
			System.out.println("Merge Test 1: failed");
		}
		
		//runs the MergeThread for mergeArr2
		MergeSort.runMergeThread(mergeArr2);
		boolean mergeTest2;
		
		//checks if mergeArr2 is sorted
		mergeTest2 = MergeSort.isSorted(mergeArr2);
		
		//asserts if mergeArr2 is sorted
		assert(mergeTest2);
		
		//if mergeArr2 is sorted then passed is printed otherwise fail is printed
		if(mergeTest2) {
			System.out.println("Merge Test 2: passed");
		} else {
			System.out.println("Merge Test 2: failed");
		}
		
		//runs the MergeThread for mergeArr3
		MergeSort.runMergeThread(mergeArr3);
		boolean mergeTest3;
		
		//checks if mergeArr3 is sorted
		mergeTest3 = MergeSort.isSorted(mergeArr3);
		
		//asserts if mergeArr3 is sorted
		assert(mergeTest3);
		
		//if mergeArr3 is sorted then passed is printed otherwise fail is printed
		if(mergeTest3) {
			System.out.println("Merge Test 3: passed");
		} else {
			System.out.println("Merge Test 3: failed");
		}
		
		//runs the MergeThread for mergeArr4
		MergeSort.runMergeThread(mergeArr4);
		boolean mergeTest4;
		
		//checks if mergeArr4 is sorted
		mergeTest4 = MergeSort.isSorted(mergeArr4);
		
		//asserts if mergeArr4 is sorted
		assert(mergeTest4);
		
		//if mergeArr4 is sorted then passed is printed otherwise fail is printed
		if(mergeTest4) {
			System.out.println("Merge Test 4: passed");
		} else {
			System.out.println("Merge Test 4: failed");
		}
		
		//runs the MergeThread for mergeArr5
		MergeSort.runMergeThread(mergeArr5);
		boolean mergeTest5;
		
		//checks if mergeArr5 is sorted
		mergeTest5 = MergeSort.isSorted(mergeArr5);
		
		//asserts if mergeArr5 is sorted
		assert(mergeTest5);
		
		//if mergeArr5 is sorted then passed is printed otherwise fail is printed
		if(mergeTest5) {
			System.out.println("Merge Test 5: passed");
		} else {
			System.out.println("Merge Test 5: failed");
		}
	}
	
	/*
	 * 
	 */
	@Test
	@DisplayName("Check That QuickSort Works")
	void testQuick() {
		
		//runs QuickThread for quickArr1
		QuickSort.runQuickThread(quickArr1);
		boolean quickTest1;
		
		//checks if quickArr1 is sorted
		quickTest1 = MergeSort.isSorted(quickArr1);
		
		//asserts if quickArr1 is sorted
		assert(quickTest1);
		
		//if quickArr1 is sorted then passed is printed otherwise fail is printed
		if(quickTest1) {
			System.out.println("Quick Test 1: passed");
		} else {
			System.out.println("Quick Test 1: failed");
		}
		
		//runs QuickThread for quickArr2
		QuickSort.runQuickThread(quickArr2);
		boolean quickTest2;
		
		//checks if quickArr2 is sorted
		quickTest2 = MergeSort.isSorted(quickArr2);
		
		//asserts if quickArr2 is sorted
		assert(quickTest2);
		
		//if quickArr2 is sorted then passed is printed otherwise fail is printed
		if(quickTest2) {
			System.out.println("Quick Test 2: passed");
		} else {
			System.out.println("Quick Test 2: failed");
		}
		
		//runs QuickThread for quickArr3
		QuickSort.runQuickThread(quickArr3);
		boolean quickTest3;
		
		//checks if quickArr3 is sorted
		quickTest3 = MergeSort.isSorted(quickArr3);
		
		//asserts if quickArr3 is sorted
		assert(quickTest3);
		
		//if quickArr3 is sorted then passed is printed otherwise fail is printed
		if(quickTest3) {
			System.out.println("Quick Test 3: passed");
		} else {
			System.out.println("Quick Test 3: failed");
		}
		
		//runs QuickThread for quickArr4
		QuickSort.runQuickThread(quickArr4);
		boolean quickTest4;
		
		//checks if quickArr4 is sorted
		quickTest4 = MergeSort.isSorted(quickArr4);
		
		//asserts if quickArr4 is sorted
		assert(quickTest4);
		
		//if quickArr4 is sorted then passed is printed otherwise fail is printed
		if(quickTest4) {
			System.out.println("Quick Test 4: passed");
		} else {
			System.out.println("Quick Test 4: failed");
		}
		
		//runs QuickThread for quickArr5
		QuickSort.runQuickThread(quickArr5);
		boolean quickTest5;
		
		//checks if quickArr5 is sorted
		quickTest5 = MergeSort.isSorted(quickArr5);
		
		//asserts if quickArr5 is sorted
		assert(quickTest5);
		
		//if quickArr5 is sorted then passed is printed otherwise fail is printed
		if(quickTest5) {
			System.out.println("Quick Test 5: passed");
		} else {
			System.out.println("Quick Test 5: failed");
		}
		
	}
	
}

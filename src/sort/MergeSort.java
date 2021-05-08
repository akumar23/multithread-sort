package sort;

public class MergeSort extends Thread {
	private int[] list;
	
	public MergeSort(int[] list) {
		this.list = list;
	}
	
	public void run() {
		mergesort(list,0, 0+(list.length -1)/2, list.length-1);
	}

	public int[] getList() {
		return list;
	}
	
	/**
	 * 
	 * @param array
	 * @param left
	 * @param middle
	 * @param right
	 */
	static void mergesort(int array[], int left, int middle, int right){
		int size1 = middle - left + 1;
		int size2 = right - middle;
		
		int leftArray[] = new int[size1];
		int rightArray[] = new int[size2];
		
		for(int i=0; i<size1; ++i) {
			leftArray[i] = array[left + i];
		}
		for(int i=0; i<size2; ++i) {
			rightArray[i] = array[middle + 1 + i];
		}
		
		generalSort(array, leftArray, rightArray, size1, size2);
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
	
}

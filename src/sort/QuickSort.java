package sort;

public class QuickSort extends Thread {

	private int[] list;
	
	public QuickSort(int[] list) {
		this.list = list;
	}
	
	public void run() {
		quicksort(list,0, list.length-1);
	}

	public int[] getList() {
		return list;
	}
	
	/**
	 * 
	 * @param a
	 * @param low
	 * @param high
	 * @return
	 */
	static int part(int[] a, int low, int high) {
		int p = a[high];
		int smallI = low-1;
		
		for(int i=low; i<high; i++) {
			if(a[i] < p) {
				smallI++;
				int temp = a[smallI];
				a[smallI] = a[i];
				a[i] = temp;
			}
		}
		int temp = a[smallI+1];
		a[smallI+1] = a[high];
		a[high] = temp;
		
		return smallI+1;
	}
	
	
	/**
	 * 
	 * @param a
	 * @param low
	 * @param high
	 */
	static void quicksort(int[] a, int low, int high) {
		if(low < high) {
			
			int index = part(a, low, high);
			quicksort(a, low, index-1);
			quicksort(a, index+1, high);
		}
	}
}

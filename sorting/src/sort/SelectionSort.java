package sort;

public class SelectionSort {

	 static void sort(int[] a) {
		for(int i=0; i<a.length-1; i++) {
			int minI = i;
			for(int j=i+1; j<a.length; j++) {
				if(a[j] < a[minI]) {
					minI = j;
				}
			}
			
			int temp = a[minI];
			a[minI] = a[i];
			a[i] = temp;
		}
	}
}

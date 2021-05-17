package sort;

public class SelectionSort {
	
	/**
	 * sort function to run selection sort
	 * @param a - passed in array
	 */
	 static void sort(int[] a) {
		 
		//loops through the array
		for(int i=0; i<a.length-1; i++) {
			
			//sets the minimum index to i
			int minI = i;
			
			//loops through the array again
			for(int j=i+1; j<a.length; j++) {
				
				//checks if any element is less than the minimum index
				if(a[j] < a[minI]) {
					
					//if an element is less than the one at minimum index 
					//then minimum index becomes j
					minI = j;
				}
			}
			
			//swaps the element at the minimum index with the element at i
			int temp = a[minI];
			a[minI] = a[i];
			a[i] = temp;
		}
	}
}

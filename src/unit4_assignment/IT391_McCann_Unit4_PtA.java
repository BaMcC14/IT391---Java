package unit4_assignment;

public class IT391_McCann_Unit4_PtA {

	public static void main(String[] args) {
		
		//*********************************************************

		//****Assignment 4, Part A, Section 1

		//*********************************************************
		System.out.println( "********** Section 1 – Quick Sort **********");
		System.out.println();
		
		int[] myNumbers = { 6501, 9503, 7557, 5535, 5601, 9001, 9888, 8801, 9767, 7815 };
		
		System.out.print("The array unsorted is: [" );
		for(int i = 0; i < myNumbers.length; i++) {
				System.out.print(myNumbers[i]);
			if(i != myNumbers.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
		
		quickSort(myNumbers, 0, 9);
		System.out.print("The array sorted is: [" );
		for(int i = 0; i < myNumbers.length; i++) {
			System.out.print(myNumbers[i]);
			if(i != myNumbers.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
		System.out.println();
		
		//*********************************************************

		//****Assignment 4, Part A, Section 2

		//*********************************************************
		System.out.println( "********** Section 2 – Bubble Sort **********");
		System.out.println();
		
		int[]myArray={5,90,35,45,150,3};
		
		System.out.print("The arry unsorted is: [");
		for(int i = 0; i < myArray.length; i++) {
			System.out.print(myArray[i]);
			if(i != myArray.length - 1) {
				System.out.print(", ");
			}
		}	
		System.out.println("]");
		
		bubbleSort(myArray);
		
		System.out.print("The array sorted is: [");
		for(int i = 0; i < myArray.length; i++) {
			System.out.print(myArray[i]);
			if(i != myArray.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("] ");
		System.out.println();
		
		//*********************************************************

		//****Assignment 4, Part A, Section 3

		//*********************************************************
		System.out.println( "********** Section 3 – Binary Search **********");
		System.out.println();
		
		System.out.println(binarySearch(myNumbers, 8801));
		System.out.println(binarySearch(myNumbers, 7777));

	}
	
	public static void quickSort(int[] arr, int low, int high) {
		if(arr == null || arr.length == 0) {
			return;
		}
		if(low >= high) {
			return;
		}
		
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
		int i = low;
		int j = high;
		
		while(i <= j) {
			while(arr[i] < pivot) {
				i++;
			}
			while(arr[j] > pivot) {
				j--;
			}
		
			if(i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		
			if(low < i) {
				quickSort(arr, low, j);
			}
			if(high > i) {
				quickSort(arr, i ,high);
			}
		
		}
	}
	
	public static void bubbleSort(int[] arr) {
		int t;
		for(int j = 0; j <= arr.length - 2; j++) {
			for(int i = 0; i <= arr.length - 2; i++) {
				if(arr[i] > arr[i + 1]) {
					t = arr[i + 1];
					arr[i + 1] = arr[i];
					arr[i] = t;	
				}
			}
		}
	}
	
	static String binarySearch(int[] sortArr, int target) {
		String answer = "";
		int first = 0;
		int last = sortArr.length - 1;
		int middle = (first + last) / 2;
		
		while(first <= last) {
			if(sortArr[middle] < target)
				first = middle + 1;
			else if(sortArr[middle] == target) {
				answer = target + " Found at location " + (middle + 1) + ".";
				break;
			}
			else
				last = middle - 1;
				middle = (first + last) / 2; 
		} 
		if(first > last) 
			answer = target + " is not present in the list.\n";
		
		return answer;
	}
}
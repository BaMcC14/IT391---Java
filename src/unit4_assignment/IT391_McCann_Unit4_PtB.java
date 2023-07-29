package unit4_assignment;

public class IT391_McCann_Unit4_PtB {

	public static void main(String[] args) {
		
		
		//*********************************************************

		//****Assignment 4, Part B, Section 1

		//*********************************************************
		System.out.println( "********** Section 1 – Bubble Sort **********");
		System.out.println();
		
		int[] studentGrades = {65, 95, 75, 55, 56, 90, 98, 88, 97, 78};
		int[] studentGrades2 = studentGrades; //Created a copy of sutdentGrades for Section 2
		
		System.out.print("The unsorted list of grades is: "); 
		printArray(studentGrades);
		
		
		sortArrayDescBS(studentGrades);
		System.out.print("The grades in descending order are: ");
		printArray(studentGrades);
		
		
		sortArrayAscBS(studentGrades);
		System.out.print("The grades in ascending order are: ");
		printArray(studentGrades);
		
		//*********************************************************

		//****Assignment 4, Part B, Section 2

		//*********************************************************
		System.out.println();
		System.out.println( "********** Section 2 – Quick Sort **********");
		System.out.println();
		
		System.out.print("The unsorted list of grades is: "); 
		printArray(studentGrades2);
		
		
		System.out.print("The grades in decending order are: "); 
		sortArrayDescQS(studentGrades2, 0, 9);
		printArray(studentGrades2);
		
		
		System.out.print("The grades in ascending order are: "); 
		sortArrayAscQS(studentGrades2, 0, 9);
		printArray(studentGrades2);
		
		//*********************************************************

		//****Assignment 4, Part B, Section 3

		//*********************************************************
		System.out.println();
		System.out.println( "********** Section 3 – Sequential Search **********");
		System.out.println();
		
		sortArrayAscBS(studentGrades);
		
		
		System.out.print("The content of the array are: ");
		printArray(studentGrades);
		System.out.println();
		System.out.println(seqSearch(studentGrades, 75));
		System.out.println(seqSearch(studentGrades, 60));
		
		//*********************************************************

		//****Assignment 4, Part B, Section 4

		//*********************************************************
		System.out.println();
		System.out.println( "********** Section 4 – Binary Search **********");
		System.out.println();
		
		
		System.out.print("The content of the array are: ");
		printArray(studentGrades);
		System.out.println();
		System.out.println(binarySearch(studentGrades, 56));
		System.out.println(binarySearch(studentGrades, 50));
	
	}
	
	public static void sortArrayDescBS(int[] arr) {
		int t;
		for(int i = 0; i <= arr.length - 2; i++) {
			for(int j = 0; j <= arr.length - 2; j++) {
				if(arr[j] < arr[j + 1]) {
					t = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = t;
				}
			}
		}
	}
	
	public static void sortArrayAscBS(int[] arr) {
		int t;
		for(int i = 0; i <= arr.length - 2; i++) {
			for(int j = 0; j <= arr.length - 2; j++) {
				if(arr[j] > arr[j + 1]) {
					t = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = t;
				}
			}
		}
	}

	public static void printArray(int[] arr) {
		System.out.print("[");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if(i != arr.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
	
	public static void sortArrayDescQS(int[] arr, int low, int high) {
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
			while(arr[i] > pivot) {
				i++;
			}
			while(arr[j] < pivot) {
				j--;
			}
			
			if(i <= j) {
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				i++;
				j--;
			}
			if(low < i) {
				sortArrayDescQS(arr, low, j);
			}
			if(high > i) {
				sortArrayDescQS(arr, i , high);
			}
		}
		
	}
	
	public static void sortArrayAscQS(int[] arr, int low, int high) {
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
				sortArrayAscQS(arr, low, j);
			}
			if(high > i) {
				sortArrayAscQS(arr, i , high);
			}
		}
		
	}
	
	public static String seqSearch(int[] arr, int target) {
		String answer = "";
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == target) {
				answer = target + " Found at index " + i + ".";
				break;	
			} else {
				answer = target + " Was not found in the array.";
			}
		}
		return answer;

	}
		
	public static String binarySearch(int[] arr, int target) {
		String answer = "";
		int first = 0;
		int last = arr.length - 1;
		int middle = (first + last) / 2;
		
		while(first <= last) {
			if(arr[middle] < target)
				first = middle + 1;
			else if(arr[middle] == target) {
				answer = target + " Found at index: " + middle + ".";
				break;
			} else 
				last = middle - 1;
				middle = (first + last) / 2;
		}
		if(first > last) 
			answer = target + " Was not found in the array.";
		
		return answer;
	}
}
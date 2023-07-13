package unit1_assignment;

public class IT391_McCann_Unit1 {
	
	//*********************************************************

	//****Assignment 1, Section 1

	//*********************************************************
	
	static int fibonacci(int n) {
		if(n == 1 || n == 2) {
			return 1;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	
	//*********************************************************

	//****Assignment 1, Section 2

	//*********************************************************	
	
	
	static int factorial(int n) {
		if(n == 0) {
			return 1;
		}
		return n * factorial(n-1);
	}
	
	
	public static void main(String[] args) {
		
		System.out.println();
		System.out.println("************Section 1***************");
		System.out.println();
		System.out.println("The Fibonacci value of 10 is: " + fibonacci(10));
		
		System.out.println();
		System.out.println("************Section 2***************");
		System.out.println();
		for(int i = 1; i <= 4; i++) {
		System.out.println(i+"! is: "+factorial(i));
		}
		
		
		
		
	}

}

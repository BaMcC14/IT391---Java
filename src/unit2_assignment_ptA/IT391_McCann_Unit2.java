package unit2_assignment_ptA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class IT391_McCann_Unit2 {
//*********************************************************

//****Assignment 2, Part A, Section 1

//*********************************************************
	private static void revString(String input) {		//create a new method that takes in one string argument
		Stack<String> wordstack = new Stack<String>();	//create a new stack data structure
		
		for(int i = 0; i < input.length(); i++) {		//loop over the string argument and push each character to the stack
			wordstack.push(input.substring(i, i+1));
		}
		String reversed = "";							//create a new variable to store the reversed string
		for(int i = 0; i < input.length(); i++) {		//loop over the string argument and pop each character to the new reversed variable
			reversed += wordstack.pop();
		}
		System.out.println("Your word reversed is " + reversed);
	}
	
	
	public static void main(String[] args) {
		
//*********************************************************

//****Assignment 2, Part A, Section 1

//*********************************************************	
	System.out.println();
	System.out.println("********** Section 1 **********");
	System.out.println();
	
	Scanner scanner = new Scanner(System.in); 	//Scanner to take user input
	System.out.println("Please enter a word to reverse: ");
	String userInput = ""; 		//Create a variable to store the user input
	userInput = scanner.next(); //Stores the next input from the user to the userInput variable
	scanner.close(); 			//closing scanner
	revString(userInput);

	
//*********************************************************

//****Assignment 2, Part A, Section 2

//*********************************************************
	System.out.println();
	System.out.println("********** Section 2 **********");
	System.out.println();
	
	Queue<String> shoppers = new LinkedList<String>(); //create a new queue data structure
	
	shoppers.add("Jane"); //adding first initial shoppers
	shoppers.add("Bob");
	shoppers.add("Liza");
	shoppers.add("Tom");
	shoppers.add("Mary");
	
	System.out.println("The number of shoppers at the grocery store is " + shoppers.size()); //displaying the length of the queue
	System.out.println("The first shopper in line is " + shoppers.peek()); //viewing the first shopper with the peek method
	
	shoppers.add("Stephen"); //adding two additional shoppers
	shoppers.add("Ellen");
	
	shoppers.remove(); //removing three shoppers
	shoppers.remove();
	shoppers.remove();
	
	System.out.println("The number of shoppers now in line is " + shoppers.size()); //displaying the length of the queue
	System.out.println("The shopper currently first in line is " + shoppers.peek()); //viewing the first shopper with the peek method
	}

}

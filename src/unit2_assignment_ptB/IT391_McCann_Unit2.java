package unit2_assignment_ptB;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class IT391_McCann_Unit2 {
//*********************************************************

//****Assignment 2, Part B, Section 2

//*********************************************************
	private static String revSentence(String str) { //create a method to return the reverse of a sentence
		
		Stack<String> stack = new Stack<String>(); //create a new stack object
		
		for(String word : str.split(" ")) { //loop over each word and push it to the stack.
			stack.push(word);
		}
		String revSentence = "";	//create a new empty variable for the reverse sentence 
		
		while(!stack.isEmpty()){	//loop over the stack until it is empty and pop the elements to the revSentence variable
			revSentence += stack.pop() + " ";
		}
		System.out.println("Your sentence in revers is: " + revSentence);
		return revSentence;
	}
	
	
	public static void main(String[] args) {
		
//*********************************************************

//****Assignment 2, Part B, Section 1

//*********************************************************	
	System.out.println();
	System.out.println("********** Section 1 **********");
	System.out.println();	
	
	Queue<String> shoppers = new LinkedList<String>();	//create a new queue object
	
	shoppers.add("Jim");	//add initial shoppers to the queue
	shoppers.add("Bob");
	shoppers.add("Susan");
	shoppers.add("Liz");
	shoppers.add("Alex");
	
	System.out.println("The number of people in line at the bank is " + shoppers.size()); //print the size of the queue
	System.out.println("The names of those in line at the bank are ");
	for(String shopper : shoppers) { //loop over the queue to print out the names in queue
		System.out.println(shopper);
	}
	
	System.out.println("The first customer in line is " + shoppers.remove()); //remove the first customer in queue
	
	shoppers.add("Andy"); //add two additional shoppers 
	shoppers.add("Rhonda");
	
	shoppers.remove(); //remove three shoppers
	shoppers.remove();
	shoppers.remove();
	
	System.out.println("The number of customers in line now is " + shoppers.size()); //print the size of the queue. 
	
//*********************************************************

//****Assignment 2, Part B, Section 2

//*********************************************************		
	System.out.println();
	System.out.println("********** Section 2 **********");
	System.out.println();	
	
	Scanner scanner = new Scanner(System.in);
	System.out.println("Please enter a sentence:");
	String userInput = scanner.nextLine();
	scanner.close();
	
	revSentence(userInput);
	}

}

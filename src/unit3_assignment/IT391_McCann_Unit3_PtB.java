package unit3_assignment;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class IT391_McCann_Unit3_PtB {

	public static void main(String[] args) {
		
		
		//*********************************************************

		//****Assignment 3, Part (B), Section 1

		//*********************************************************
		
		String[] mammals = new String[] {
			"Bear",
			"Gorilla",
			"Tiger",
			"Polar Bear",
			"Lion",
			"Monkey"
		};
		
		HashSet<String> setMammals = new HashSet<String>();
		
		try {
			
			for(int i = 0; i < mammals.length; i++) {
				setMammals.add(mammals[i]);
			}
			
			System.out.println("*********** Section: 1 ***********");
			System.out.println();
			
			System.out.println("Contents of the set are: ");
			System.out.print("[");
			for(int i = 0; i < mammals.length; i++) {
				System.out.print(mammals[i]);
				if(i != mammals.length - 1) {
					System.out.print(", ");
				}
			}
			System.out.println("]");
			
			SortedSet<String> sortedMammals = new TreeSet<String>(setMammals);
			
			System.out.println();
			System.out.println("Contents of the sorted set are: ");
			System.out.print("[");
			int j = 0;
			for (String mammal : sortedMammals) {
				System.out.print(mammal);
				if(j != sortedMammals.size() - 1) {
					System.out.print(", ");
				}
			}
			System.out.println("]");
			
			System.out.println();
			System.out.println("The first item in the set is: " + sortedMammals.first());
			System.out.println("The last items in the set is: " + sortedMammals.last());
	
		} catch(Exception ex) {
			System.out.println("Error: " + ex.toString());
		}
		
		
		//*********************************************************

		//****Assignment 3, Part (B), Section 2

		//*********************************************************
		System.out.println();
		System.out.println("*********** Section: 2 ***********");
		
		
		LinkedList<String> myFriends = new LinkedList<String>();
		
		try {
			System.out.println();
			myFriends.add("Fred 602-299-3300");
			myFriends.add("Ann 602-555-4949");
			myFriends.add("Grace 520-544-989");
			myFriends.add("Sam 602-343-8723");
			myFriends.add("Dorothy 520-689-9745");
			myFriends.add("Susan 520-981-8745");
			myFriends.add("Bill 520-456-9823");
			myFriends.add("Mary 520-788-3457");
		
			System.out.println("The contents of my friends list: ");
			DisplayList(myFriends);
			
			myFriends.remove(6);
			Collections.sort(myFriends);
			myFriends.removeFirst();
			myFriends.removeLast();
			myFriends.set(4, "Mary 520-897-4567");

			System.out.println();
			System.out.println("The updated contents of my friends list: ");
			DisplayList(myFriends);
			
			System.out.println();
			System.out.println("The number of friends in my list is: " + myFriends.size());
			
			System.out.println();
			int index = myFriends.indexOf("Fred 602-299-3300");
			if(index != -1) {
				System.out.println("Fred is in the list");
			} else {
				System.out.println("Fred is not in the list");
			}
			
			
		} catch(Exception ex) {
			System.out.println("Error: " + ex.toString());
		}
		
		
		
		
		
		
		
		
		
		
		//*********************************************************

		//****Assignment 3, Part (B), Section 3

		//*********************************************************
		
		new BinaryTree().create();
		
	}
	
	
	public static void DisplayList(List<String> list) {
		System.out.print("[");
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
			if(i != list.size() - 1) {
				System.out.println(", ");
			}
		}
		System.out.println("]");
	}

}

//*************************
//BinaryTree code created in the same package as Part A.
//*************************




//class Node {
//	public Node left;
//	public Node right;
//	public int value;
//	public Node(int value) {
//		this.value = value;
//	}
//}
//
//class BinaryTree{
//	public final void create() {
//		Node rootnode = new Node(50);
//		this.insert(rootnode, 30);
//		this.insert(rootnode, 45);
//		this.insert(rootnode,  12);
//		this.insert(rootnode, 29);
//		
//		System.out.println("The contents of the binary tree are: ");
//		this.traverse(rootnode);
//	}
//	
//	
//	public final void traverse(Node rootnode) {
//		System.out.println("InOrder Traversal");
//		this.printInOrder(rootnode);
//		
//		System.out.println();
//		
//		System.out.println("PreOrder Traversal");
//		this.printPreOrder(rootnode);
//		
//		System.out.println();
//		
//		System.out.println("PostOrder Traversal");
//		this.printPostOrder(rootnode);
//		
//	}
//	
//	
//	final void printInOrder(Node node) {
//		if(node != null) {
//			this.printInOrder(node.left);
//			System.out.println(" Traversed " + node.value);
//			this.printInOrder(node.right);
//		}
//	}
//	
//	final void printPreOrder(Node node) {
//		if(node != null) {
//			System.out.println(" Traversed " + node.value);
//			this.printPreOrder(node.left);
//			this.printPreOrder(node.right);
//		}
//	}
//	
//	final void printPostOrder(Node node) {
//		if(node != null) {
//			this.printPostOrder(node.left);
//			this.printPostOrder(node.right);
//			System.out.println(" Traversed " + node.value);
//		}
//	}
//	
//	
//	public final void insert(Node node, int value) {
//		if (value < node.value) {
//			if(node.left != null) {
//				this.insert(node.left, value);
//			} else {
//				node.left = new Node(value);
//			}
//		} else if (value > node.value) {
//			if(node.right != null) {
//				this.insert(node.right, value);
//			} else {
//				node.right = new Node(value);
//			}
//		}
//	}
//}

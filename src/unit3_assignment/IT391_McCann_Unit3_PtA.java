package unit3_assignment;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class IT391_McCann_Unit3_PtA {

	public static void main(String[] args) {
		
		
		//*********************************************************

		//****Assignment 3, Part (A), Section 1

		//*********************************************************
		System.out.println();
		System.out.println("**********Section 1 **********");
		System.out.println();
		
		String[] professions = new String[] {
				"Software Engineer",
				"Programmer",
				"Database Admin",
				"Network Admin",
				"Web Developer",
				"Program Manager"};
		
		HashSet<String> setprofessions = new HashSet<String>();
		
		try {
			for(int i = 0; i < professions.length; i++) {
				setprofessions.add(professions[i]);
			}
		
			System.out.println("Original List: ");
			System.out.print("[");
			
			for(int i = 0; i < professions.length; i++) {
				System.out.print(professions[i]);
			
				if(i == professions.length - 1) {
					System.out.print("]");
				} else {
					System.out.print(", ");
				}
			}
		
			System.out.println();
			System.out.println();
			
			System.out.println("Sorted Set: ");
			SortedSet<String> sortedProfessions = new TreeSet<String>(setprofessions);
			
			System.out.print("[");
			
			int j = 0;
			
			for(String job : sortedProfessions) {
				System.out.print(job);
				
				if(j != sortedProfessions.size() - 1) {
					System.out.print(",");
				} 
				j++;
			}
			System.out.println("]");
		
		
		} catch (Exception ex){
				System.out.println(("Error: " + ex.toString()));
		}
			
		
		//*********************************************************

		//****Assignment 3, Part (A), Section 2

		//*********************************************************
		
		System.out.println();
		System.out.println("**********Section 2 **********");
		System.out.println();
		
		LinkedList<String> lstbooks = new LinkedList<String>();
		
		lstbooks.add("To Kill a Mockingbird");
		lstbooks.add("Huckleberry Finn");
		lstbooks.add("Pride and Prejudice");
		lstbooks.add("Brave New World");
		lstbooks.add("Alice in Wonderland");
		lstbooks.add("The Old Mand and the Sea");
		lstbooks.add("Atlas Shrugged");
		
		System.out.println("Original Book List:");
		DisplayList(lstbooks);
		
		System.out.println();
		
		Collections.sort(lstbooks);
		System.out.println("Sorted List:");
		DisplayList(lstbooks);
		
		lstbooks.remove(1);
		lstbooks.remove(0);
		lstbooks.remove(lstbooks.size() - 1);
		
		System.out.println("Book List After Deletions: ");
		DisplayList(lstbooks);
		
		System.out.println("The number of itmes in my book list is: " + (lstbooks.size()));
		
		System.out.println();
		
		int index = lstbooks.indexOf("Brave New World");
		
		if(index != -1) {
			System.out.println("Brave New World is in the list.");
		} else {
			System.out.println("Brave New World is not in the list");
		}
		
		
		//*********************************************************

		//****Assignment 3, Part (A), Section 3

		//*********************************************************
		
		System.out.println();
		System.out.println("**********Section 3 **********");
		System.out.println();
		
		
		new BinaryTree().create();
		
}
	
	static void DisplayList(List<String> lst) {
		System.out.print("[");
		
		for(int i = 0; i < lst.size(); i++) {
			System.out.print(lst.get(i));
			if(i != lst.size() - 1) {
				System.out.print(",");
			}
		}
		System.out.println("]");
		System.out.println();
		
	}
}
	
	class Node {
		public Node left;
		public Node right;
		public int value;
		public Node(int value) {
			this.value = value;
		}
}
	
	class BinaryTree{
		public final void create() {
			Node rootnode = new Node(50);
			this.insert(rootnode, 30);
			this.insert(rootnode, 45);
			this.insert(rootnode,  12);
			this.insert(rootnode, 29);
			
			System.out.println("The contents of the binary tree are: ");
			this.traverse(rootnode);
			
		}
	
	public final void traverse(Node rootnode) {
		System.out.println();
		System.out.println("*********** Section: 3 ***********");
		System.out.println();
		System.out.println("InOrder Traversal");
		this.printInOrder(rootnode);
		
		System.out.println();
		
		System.out.println("PreOrder Traversal");
		this.printPreOrder(rootnode);
		
		System.out.println();
		
		System.out.println("PostOrder Traversal");
		this.printPostOrder(rootnode);
		
	}
	
	
	final void printInOrder(Node node) {
		if(node != null) {
			this.printInOrder(node.left);
			System.out.println(" Traversed " + node.value);
			this.printInOrder(node.right);
		}
	}
	
	final void printPreOrder(Node node) {
		if(node != null) {
			System.out.println(" Traversed " + node.value);
			this.printPreOrder(node.left);
			this.printPreOrder(node.right);
		}
	}
	
	final void printPostOrder(Node node) {
		if(node != null) {
			this.printPostOrder(node.left);
			this.printPostOrder(node.right);
			System.out.println(" Traversed " + node.value);
		}
	}
	
	
	public final void insert(Node node, int value) {
		if (value < node.value) {
			if(node.left != null) {
				this.insert(node.left, value);
			} else {
				node.left = new Node(value);
			}
		} else if (value > node.value) {
			if(node.right != null) {
				this.insert(node.right, value);
			} else {
				node.right = new Node(value);
			}
		}
	}
	
	
}	


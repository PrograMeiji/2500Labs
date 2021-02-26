//this class defines the linked list and gives it an action for inserting the nodes
package lds_lab_5;
import java.io.*;

public class LinkedList {
	
	//head of list
	Node head;
	//number of nodes in list, number of words in list,
	//number of comparisons in lists, number of references in list
	long nodeNum, wordNum, compareNum, referenceNum;
	long compareRem, referenceRem, compareRemove2, referenceRemove2;
	
	class Node {
		
		Element element;
		Node next;	
	
	}
	
	public LinkedList() {
		
		//set head to null and length to zero
		head = null;
		nodeNum = 0;
		wordNum = 0;
		compareNum = 0;
		referenceNum = 0;
		compareRem = referenceRem = compareRemove2 = referenceRemove2 = 0;
		
	}
	
	//method for inserting a new node
	public void add(Element element) {
		
		//sets current node to the top of the list
		Node currentNode = head;
		
		//increments from the head of the list to the end
		while (currentNode != null) {
			
			//increases number of comparisons by the list
			compareNum++;
			//if the current node has the same word as a node in the list,
			//it increases number at the element
			if (currentNode.element.word.equals(element.word)) {
				
				//increments number at current node
				currentNode.element.number++;
				return;
				
			}
			
			//current node incremented to the next node
			currentNode = currentNode.next;
		}
		
		
		//creates previous head node
		Node prevHead = head;
		//makes head a new node
		head = new Node();
		//element at head is set to element
		head.element = element;
		//head is pointed to previous head
		head.next = prevHead;
		//increments reference number by 2
		referenceNum += 2;
		
	}
	
	public void remove(Element element) {
		
		Node currentNode = head;
		Node prevNode = null;
		//iterates through list
		while(currentNode != null) {
			//increases reference removal number
			compareRem++;
			//compares words
			if(currentNode.element.word.equals(element.word)){
				//inc compare removals
				compareRem++;
				//if the number is more than 1
				if(currentNode.element.number > 1) {
					//decrease number by 1
					currentNode.element.number -= 1;
					return;
					
				}
				//if number is one, remove the node
				if(currentNode.element.number == 1) {
					
					compareRem++;
					//if the node is the top of the list
					if(currentNode == head) {
						
						referenceRem++;
						head = currentNode.next;
						return;
					}
					
					else {
						
						referenceRem++;
						prevNode.next = currentNode.next;
						
					}
				}
			}
			//sets the currentNode to the start of the list
			referenceRem += 2;
			prevNode = currentNode;
			currentNode = currentNode.next;
		}
	}
	
	//prints the number of compare and reference removals
	public void printRemove() {
		
		System.out.println();
		System.out.println("The number of comparisons removed is: " + compareRem);
		System.out.println("The number of references removed is: " + referenceRem);
		
	}
	
	//method prints the first 100 nodes
	public void printHunNode() {
		
		//sets current node to the begging of the list
		Node currentNode = head;
		//integer for counting how many nodes we print
		int ct = 0;
		//tells user what is being printed
		System.out.print("First 100 Nodes: ");
		System.out.println();
		
		//iterates through loop and print each node object until the 100 node (0-99) threshold is printed
		while (currentNode != null && ct < 100) {
			
			//prints the word and number of each element
			System.out.print(currentNode.element.word + ", ");
			System.out.println(currentNode.element.number);
			
			//increments current node to go through the loop
			currentNode = currentNode.next;
			//increases count
			ct++;
			
		}
	}
	
	//this method prints the reference change number and comparison number for the list
	public void print() {
		
		//prints number of comparisons
		System.out.print("The number of comparisons is: ");
		System.out.println(compareNum);
		//prints number of reference changes
		System.out.print("The number of reference changes is: ");
		System.out.println(referenceNum);
	}
	
	
	
	//this method print the total number of words
	public void listWords() {
		
		//creates current node variable set to head
		Node currentNode = head;
		//variable for holding number of words
		int wordNum = 0;
		//print line
		System.out.print("The number of total words is: ");
		//iterates through the list until currentNode is null
		while (currentNode != null) {
			
			//number of words is incremented by the number at the current node
			wordNum += currentNode.element.number;
			//increment current node to traverse the list
			currentNode = currentNode.next;
			
		}
		//prints the number of words
		System.out.println(wordNum);
		
	}
	
	//method for printing the number of distinct nodes
	public void listDisWords() {
		
		//starts current node at the top of the list
		Node currentNode = head;
		//creates current node variable
		int nodeNum = 0;
		
		//prints the string
		System.out.print("The number of distinct words is: ");
		
		//loop iterates through the list
		while(currentNode != null) {
			
			//increments number of nodes, which is the number of nodes
			nodeNum++;
			//sets current node to the next node
			currentNode = currentNode.next;
			
		}
		
		//prints the number of distinct words
		System.out.println(nodeNum);
		
	}
	
public void listWordsCount() {
		
		//creates current node variable set to head
		Node currentNode = head;
		//variable for holding number of words
		while (currentNode != null) {
			
			//number of words is incremented by the number at the current node
			wordNum += currentNode.element.number;
			//increment current node to traverse the list
			currentNode = currentNode.next;
			
		}
	}

public void listDisWordsCount() {
	
	//starts current node at the top of the list
	Node currentNode = head;
	//creates current node variable
	
	//loop iterates through the list
	while(currentNode != null) {
		
		//increments number of nodes, which is the number of nodes
		nodeNum++;
		//sets current node to the next node
		currentNode = currentNode.next;
		
	}
	
	}
}

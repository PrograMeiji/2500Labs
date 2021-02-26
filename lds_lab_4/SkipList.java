package lds_lab_4;

import java.util.Random;

public class SkipList {
	
	public SLNode head; //first element of top level
	public SLNode tail; //last element of top level
	
	public int length; //number of elements in the list
	public int height; //height of the list
	
	//variables for keeping tack of desired actions while code is running
	public long wordNum, nodeNum, compareNum, referenceNum, referenceRem, compareRem;
	
	public Random random; //coin toss
	
	public SkipList() {
		
		SLNode topInf, botInf;
		
		//create a -oo and oo object
		topInf = new SLNode(SLNode.negInf, null);
		botInf = new SLNode(SLNode.posInf, null);
		
		//link the -oo and oo objects together
		topInf.right = botInf;
		botInf.left = topInf;
		
		//initializes head and tail
		head = topInf;
		tail = botInf;
		
		length = 0; //no elements in the skip list
		height = 0; //height starts at 0
		//starts statistics to zero
		wordNum = nodeNum = compareNum = referenceNum = 0;
		
		random = new Random(); //make random obj to simulate coin toss
	}
	
	//method for searching if the entered word matches an existing word,
	//and will return the closest value of node less than input string
	public SLNode search(String s) {
		
		//local variable for head
		SLNode point;
		point = head;
		
		//loop ensure that the point isn't equal to positive infinity and 
		//that the comparison is less than or equal to zero
		while (true) {
			
			while(point.right.word != SLNode.posInf &&
				  point.right.word.compareTo(s) <= 0) {
				
				//increase number of comparisons
				compareNum++;
				//change the reference of point
				point = point.right;
				//increase reference number
				referenceNum++;
				
			}
			compareNum++;
			//checks if there is a reference down, and moves point down in order
			//to check that node
			if (point.down != null) {
				
				//moves point downwards a node
				point = point.down;
				//increase reference number
				referenceNum++;
				
			}
			else {
				
				break;
				
			}
		}
		
		return point;
		
	}
	
	//gets the number associated with the input string
	public Integer getNum(String s) {
		
		//create point node to go through the list
		SLNode point;
		//call search method to find the node with string w and set it to point
		point = search(s);
		//increase the number of comparisons
		compareNum++;
		//if the word and string input are equal, return the number stored at that node
		if (s.equals(point.getWord())) {
			
			return point.number;
			
		}
		//otherwise return false
		else {
			
			return null;
			
		}
	}
	
	//method for building the list
	public Integer insert(String s, Integer n) {
		
		//creates local variable for 2 nodes
		SLNode point, point2;
		int ct; //count variable
		//sets point equal to the node found using the search method
		point = search(s);
		
		//compares the two strings, and if equal, increments the number at that node
		compareNum++;
		if (s.equals(point.getWord())) {
			
			Integer previous = point.number;
			point.number++;
			return previous;
		
		}
		
		point2 = new SLNode(s, n);
		referenceNum += 4;
		//adds the node to our list
		point2.left = point;
		point2.right = point.right;
		point.right.left = point2;
		point.right = point2;
		
		ct = 0;
		
		while (random.nextDouble() < 0.5) {
			
			compareNum++;
			if( ct >= height) {
				
				SLNode node1, node2;
				
				height++;
				
				node1 = new SLNode(SLNode.negInf, null);
				node2 = new SLNode(SLNode.posInf, null);
				
				//moves the nodes to head and tail respectively
				node1.right = node2;
				node1.down = head;
				node2.left = node1;
				node2.down = tail;
				head.up = node1;
				tail.up = node2;
				head = node1;
				tail = node2;
				//increase reference number by 8
				referenceNum +=8;
			}
			
			while(point.up == null) {
				//moves node to the left
				point = point.left;
				//increase reference number
				referenceNum++;
				
			}
			
			//moves the node up
			point = point.up;
			referenceNum++;
			
			SLNode entry;
			entry = new SLNode(s, null);
			
			entry.left = point;
			entry.right = point.right;
			entry.down = point2;
			point.right.left = entry;
			point.right = entry;
			point2.up = entry;
			
			referenceNum += 7;
			
			point2 = entry;
			
			ct++;
		}
		
		length++;
		
		return null;
	}
	
	public SLNode removeSearch(String s) {
		
		SLNode point;
		point = head;
		
		while (true){
			
			while(point.right.word != SLNode.posInf &&
				  point.right.word.compareTo(s) <= 0) {
				
				compareRem++;
				referenceRem++;
				point = point.right;
				
			}
			compareRem++;
			if(point.down != null) {
				
				referenceRem++;
				point = point.down;
				
			}
			else {
				break;
			}
		}
		return point;
	}
	
	public void remove(String s) {
		
		SLNode point;
		point = removeSearch(s);
		
		//increment remove compare number
		compareRem++;
		//if the string is the same as the node word, remove the number unless it's 1,
		//then remove the node
		if(s.equals(point.getWord())){
			
			compareRem++;
			if (point.number > 1) {
				//decrement the number
				point.number -= 1;
				return;
				
			}
			compareRem++;
			//if number is 1, remove the node
			if (point.number == 1) {
				
				while(point.down != null) {
					
					while(point !=null) {
						
						referenceRem +=3;
						point.left.right = point.right;
						point.right.left = point.left;
						point = point.up;
						
					}
				}
			}
		}
	}
	
	//prints the statistics for the Skip List
	public void printSL() {
		
		//defines points and sets it to head
		SLNode point;
		point = head;
		//until our pointer is null
		while (point.down != null) {
			//moves our point down the list
			point = point.down;
			
		}
		//as long as we aren't at the bottom
		while(point != null) {
			//increase number of nodes
			nodeNum++;
			//if there is a number, count it
			if (point.number != null) {
				//increment word number by the count next to the word
				wordNum += point.number;
				
			}
			point = point.right;
		}
		//removes head and tail for unique word number
		nodeNum -= 2;
			
		System.out.println();
		System.out.println("The total number of words is: " + wordNum);
		System.out.println("The number of distinct words is: " + nodeNum);
		System.out.println("The number of comparisons made is: " + compareNum);
		System.out.println("The number of reference changes made is: " + referenceNum);
		
	}
	
	//print the new statistics of reference and comparison removal
	public void printRemStats() {
		
		System.out.println("The number of comparisons removed is: " + compareRem);
		System.out.println("The number of references removed is: " + referenceRem);
		
	}
}

package lds_lab_5;
import lds_lab_5.LinkedList.Node;

public class HashList extends LinkedList {
	
	NodeToTop LLArray[];
	
	public HashList() {
		
		super();
		//initializes the array to be 256 long and full of LLNode objects
		LLArray = new NodeToTop[256];
		
	}
	
	
	public int hash(Element element) {
		
		int hashNumber = 0;
		//adds each character together to get the total hash number before taking the modulus
		for(int i = 0; i < element.word.length(); i++) {
					
			//adds the value of hash number to itself plus the ASCII value of the character in the string until the end of the string
			hashNumber += element.word.charAt(i);
		}
				
		//this is the hash value that we will use when assigning the words into the array of linked lists
		return hashNumber % 256;
		
				
	}

	
	//method for inserting elements into the linked list array
	public void insert(Element element) {
		//gets the integer from the hash1 method
		int stringHash = this.hash(element);
		//makes instance of the array
		NodeToTop LLTop = LLArray[stringHash];
		
		//if there isn't a node at the hashValue, make this word the node there with count of 1
		if (LLTop == null) {
			
			LLArray[stringHash] = new NodeToTop();
			//adds element to the list using NodeToTop add method
			LLArray[stringHash].add(element);
			
		}
		
		//otherwise add it to the list by increasing the count, already defined in the add method for NodeToTop list
		else {
			
			LLTop.add(element);
			
		}
	}
	
	//method for printing the stats of the list
	public void printStats() {
		
		//variables for count
		long wordNumber = 0;
		long nodeNumber = 0;
		long comNumber = 0;
		long refNumber = 0;
		//loop for iterating through list array
		for(int i = 0; i < LLArray.length; i++) {
			//instance of list at i
			NodeToTop hashList = LLArray[i];
			
			if(hashList != null) {	
				//calls the count methods from linked list and adds the results to our counters
				hashList.listWordsCount();
				hashList.listDisWordsCount();
				//adds results to our counting variables
				wordNumber += hashList.wordNum;
				nodeNumber += hashList.nodeNum;
				comNumber += hashList.compareNum;
				refNumber += hashList.referenceNum;
				
			}
		}
		
		//prints the stats
		System.out.println("The number of total words is: " + wordNumber);
		System.out.println("The number of distinct words is: " + nodeNumber);
		System.out.println("The number of comparisons is: " + comNumber);
		System.out.println("The number of reference changes is: " + refNumber);
		
	}
	
	//method for printing the list
	public void printList() {
		
		System.out.println("Array Index, Number of Words, Number of Distinct Words");
		
		for(int i = 0; i < LLArray.length; i++) {
			
			NodeToTop LLTop = LLArray[i];
			if (LLTop != null) {
				
				LLTop.listWordsCount();
				System.out.println(i + ", " + LLTop.wordNum + ", " + LLTop.nodeNum);
			}
			else {
				System.out.println(i + ", 0, 0");
			}
		}
	}
}

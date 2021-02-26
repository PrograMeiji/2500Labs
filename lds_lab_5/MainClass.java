//this is the main class that runs the program and calls to other classes
//
package lds_lab_5;
import java.io.*;
import java.util.Scanner;

public class MainClass {
	
	public static final String FILE_NAME = "C:\\Users\\futbo\\Documents\\LDS Text Files\\Text-05M.txt";

	public static void main(String args[]) {
		
				
		//instantiates the toTop list
		NodeToTop tList = new NodeToTop();		
		
		//instance of skip list
		SkipList sList = new SkipList();
		
		HashList3 hList3 = new HashList3();
		
		//instance of BST
		BinarySearchTree BST = new BinarySearchTree();
		
		//variables for start and end time
		long start, end;
		//variable for runtime
		double time;
		
		try {
			
			//warms the cache in 1st run through, is not timed
			fileInputFirst();
			
			System.out.println("Just reading and parsing the file: ");
			System.out.println();
			start = System.currentTimeMillis();
			//runs the empty list through the buffer, is timed
			fileInputSecond();
			end = System.currentTimeMillis();
			time = (double)(end - start) / 1000;
			System.out.println("The runtime for the read and parse is: " + time + "s");
			System.out.println();
			
			//prints the toTop list, is timed
			start = System.currentTimeMillis();
			System.out.println("TO TOP LIST: ");
			//calls fileInput method, is timed
			fileInput(tList);
			end = System.currentTimeMillis();
			time = (double)(end - start) / 1000;
			System.out.println("The runtime for this list is: " + time + "s");
			System.out.println();
			
			start = System.currentTimeMillis();
			System.out.println("SKIP LIST: ");
			//calls fileInput method, is timed
			fileInputSL(sList);
			end = System.currentTimeMillis();
			time = (double)(end - start) / 1000;
			System.out.println("The runtime for this list is: " + time + "s");
			System.out.println();
			
			start = System.currentTimeMillis();
			System.out.println("HASH LIST 3: ");
			//calls fileInput method, is timed
			fileInputHash(hList3);
			end = System.currentTimeMillis();
			time = (double)(end - start) / 1000;
			System.out.println("The runtime for this list is: " + time + "s");
			//hList3.printList();
			System.out.println();
			
			start = System.currentTimeMillis();
			System.out.println("BINARY SEARCH TREE: ");
			//calls fileInput method, is timed
			fileInputBST(BST);
			end = System.currentTimeMillis();
			time = (double)(end - start) / 1000;
			System.out.println("The runtime for this tree is: " + time + "s");
			BST.displayFirst100();
			System.out.println();
			
		}
		
		 catch (Exception e) {
			 
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	
	//method for running through the list without changing anything
	public static void fileInputFirst() throws Exception {
		
		//makes scanner to read the file
		Scanner scn;
				
		scn = new Scanner (new File(FILE_NAME));
				
		//keeps scanner reading until end of the file
		scn.useDelimiter("\\Z");
		
	}
	
	public static void fileInputSecond() throws Exception {
		
		//makes scanner to read the file
		Scanner scn;
				
		scn = new Scanner (new File(FILE_NAME));
				
		//keeps scanner reading until end of the file
		scn.useDelimiter("\\Z");
			
		//file is saved a a single string
		String fileContents = scn.next();
				
		//removes punctuation from the string and makes it lower case
		fileContents = fileContents.toLowerCase().replaceAll("[^A-Za-z]+", " ");
				
		//trims the string, then splits string at white spaces, storing words in an array
		String[] fileWords = fileContents.trim().split("\\s+");
		
	}
	
	//takes the input from the text file and outputs the lists
	public static void fileInput(LinkedList list) throws Exception {
	
		//makes scanner to read the file
		Scanner scn;
		
		scn = new Scanner (new File(FILE_NAME));
		
		//keeps scanner reading until end of the file
		scn.useDelimiter("\\Z");
	
		//file is saved a a single string
		String fileContents = scn.next();
		
		//trims the string, then splits string at white spaces, storing words in an array
		String[] fileWords = fileContents.split("\\s+");
		
		//loop for iterating through the array and assigning words to elements in the linked list
		for (String word : fileWords) {
			
			word = word.toLowerCase().replaceFirst("^[^a-zA-Z]+", "").replaceAll("[^a-zA-Z]+$", "");
			//ensures no null spaces are in array
			if(word != null && word.length() > 0) {
				
			
			//feed the word at count into element method in LinkedList class
			Element e = new Element(word, 1);
			
			//inserts element into the list using add method from respective class class
			list.add(e);
			}
			
		}
		
		//calls listWords method
		list.listWords();
		//calls distinct words method
		list.listDisWords();
		//calls the reference and comparison print method
		list.print();
		
		//puts a blank line after list to differentiate between new lists
		System.out.println();
		
	}
	
	public static void fileInputSL(SkipList list) throws Exception {
		
		//makes scanner to read the file
		Scanner scn;
		
		scn = new Scanner (new File(FILE_NAME));
		
		//keeps scanner reading until end of the file
		scn.useDelimiter("\\Z");
	
		//file is saved a a single string
		String fileContents = scn.next();

		//trims the string, then splits string at white spaces, storing words in an array
		String[] fileWords = fileContents.split("\\s+");
		
		//loop for iterating through the array and assigning words to elements in the linked list
		for (String word : fileWords) {
			
			word = word.toLowerCase().replaceFirst("^[^a-zA-Z]+", "").replaceAll("[^a-zA-Z]+$", "");
			
			if(word != null && word.length() > 0) {
				//feed the word at count into element method in LinkedList class
				Element e = new Element(word, 1);
			
				//inserts element into the list using add method from respective class class
				list.insert(e.word, 1);
			}
			
			
			
		}
		list.printSL();
	}
	
	
	
public static void fileInputHash(HashList list) throws Exception {
		
		//makes scanner to read the file
		Scanner scn;
		
		scn = new Scanner (new File(FILE_NAME));
		
		//keeps scanner reading until end of the file
		scn.useDelimiter("\\Z");
	
		//file is saved a a single string
		String fileContents = scn.next();

		//trims the string, then splits string at white spaces, storing words in an array
		String[] fileWords = fileContents.split("\\s+");
		
		//loop for iterating through the array and assigning words to elements in the linked list
		for (String word : fileWords) {
			
			word = word.toLowerCase().replaceFirst("^[^a-zA-Z]+", "").replaceAll("[^a-zA-Z]+$", "");
			
			if(word != null && word.length() > 0) {
			
				//feed the word at count into element method in LinkedList class
				Element e = new Element(word, 1);
			
				//inserts element into the list using add method from respective class class
				list.insert(e);
			
			}
		}
		
		//calls hash list print
		list.printStats();
		
	}

public static void fileInputBST(BinarySearchTree tree) throws Exception {
	
	//makes scanner to read the file
	Scanner scn;
	
	scn = new Scanner (new File(FILE_NAME));
	
	//keeps scanner reading until end of the file
	scn.useDelimiter("\\Z");

	//file is saved a a single string
	String fileContents = scn.next();

	//trims the string, then splits string at white spaces, storing words in an array
	String[] fileWords = fileContents.split("\\s+");
	
	//loop for iterating through the array and assigning words to elements in the linked list
	for (String word : fileWords) {
		
		word = word.toLowerCase().replaceFirst("^[^a-zA-Z]+", "").replaceAll("[^a-zA-Z]+$", "");
		
		if(word != null && word.length() > 0) {
		
			//feed the word at count into element method in LinkedList class
			Element e = new Element(word, 1);
		
			//inserts element into the list using add method from respective class class
			tree.insert(e.word);
		
		}
	}
	
	//calls hash list print
	tree.printStatistics();
}
}

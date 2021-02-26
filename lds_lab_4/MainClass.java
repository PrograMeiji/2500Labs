//this is the main class that runs the program and calls to other classes
//
package lds_lab_4;
import java.io.*;
import java.util.Scanner;

public class MainClass {
	
	public static final String FILE_NAME = "C:\\Users\\futbo\\Documents\\LDS Text Files\\War and Peace.txt";

	public static void main(String args[]) {
		
		//instantiates the linked list
		LinkedList list = new LinkedList();		
		//instantiates alphabetical list
		AlphabeticalList aList = new AlphabeticalList();		
		//instantiates the toTop list
		NodeToTop tList = new NodeToTop();		
		//instantiates the upOne list
		NodeUpOneRef uList = new NodeUpOneRef();
		//instance of optimized alphabetical list
		OptimizedAlphabeticalList OAList = new OptimizedAlphabeticalList();
		//instance of skip list
		SkipList sList = new SkipList();
		//instance of hash list
		HashList hList = new HashList();
		HashList2 hList2 = new HashList2();
		HashList3 hList3 = new HashList3();
		
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
			System.out.println("The runtime for this list is: " + time + "s");
			System.out.println();
			
			
			/*//prints the unsorted list, is timed
			start = System.currentTimeMillis();
			System.out.println("UNSORTED LIST: ");
			//calls fileInput method, is timed
			fileInput(list);
			end = System.currentTimeMillis();
			time = (double)(end - start) / 1000;
			System.out.println("The runtime for this list is: " + time + "s");
			System.out.println();
			
			start = System.currentTimeMillis();
			System.out.println("UNSORTED REMOVE: ");
			//calls fileInput method, is timed
			remove(list);
			list.printRemove();
			end = System.currentTimeMillis();
			time = (double)(end - start) / 1000;
			System.out.println("The runtime for this list is: " + time + "s");
			System.out.println();
			
			//prints the alphabetical list, is timed
			start = System.currentTimeMillis();
			System.out.println("ALPHABETICAL LIST: ");
			//calls fileInput method, is timed
			fileInput(aList);
			end = System.currentTimeMillis();
			time = (double)(end - start) / 1000;
			System.out.println("The runtime for this list is: " + time + "s");
			System.out.println();
			
			start = System.currentTimeMillis();
			System.out.println("ALPHABETICAL REMOVE: ");
			//calls fileInput method, is timed
			remove(aList);
			aList.printRemove();
			end = System.currentTimeMillis();
			time = (double)(end - start) / 1000;
			System.out.println("The runtime for this list is: " + time + "s");
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
			System.out.println("TO TOP REMOVE: ");
			//calls fileInput method, is timed
			remove(tList);
			tList.printRemove();
			end = System.currentTimeMillis();
			time = (double)(end - start) / 1000;
			System.out.println("The runtime for this list is: " + time + "s");
			System.out.println();
			
			//recreates the tList so we can use the other remove on it, this was why lab 3 had remove 2 as empty
			//because the remove is already called, the list must be recreated
			topRecreate(tList);
			
			start = System.currentTimeMillis();
			System.out.println("TO TOP REMOVE 2: ");
			//calls fileInput method, is timed
			remove2(tList);
			tList.printRemove2();
			end = System.currentTimeMillis();
			time = (double)(end - start) / 1000;
			System.out.println("The runtime for this list is: " + time + "s");
			System.out.println();
			
			//prints the toTop list, is timed
			start = System.currentTimeMillis();
			System.out.println("UP ONE LIST: ");
			//calls fileInput method, is timed
			fileInput(uList);
			end = System.currentTimeMillis();
			time = (double)(end - start) / 1000;
			System.out.println("The runtime for this list is: " + time + "s");
			System.out.println();
			
			start = System.currentTimeMillis();
			System.out.println("UP ONE REMOVE: ");
			//calls fileInput method, is timed
			remove(uList);
			uList.printRemove();
			end = System.currentTimeMillis();
			time = (double)(end - start) / 1000;
			System.out.println("The runtime for this list is: " + time + "s");
			System.out.println();
			
			start = System.currentTimeMillis();
			System.out.println("OPTIMIZED ALPHABETICAL LIST: ");
			//calls fileInput method, is timed
			fileInput(OAList);
			end = System.currentTimeMillis();
			time = (double)(end - start) / 1000;
			System.out.println("The runtime for this list is: " + time + "s");
			System.out.println();
			
			start = System.currentTimeMillis();
			System.out.println("ALPHABETICAL REMOVE: ");
			//calls fileInput method, is timed
			remove(OAList);
			OAList.printRemove();
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
			System.out.println("SKIP REMOVE: ");
			//calls fileInput method, is timed
			skipRemove(sList);
			sList.printRemStats();
			end = System.currentTimeMillis();
			time = (double)(end - start) / 1000;
			System.out.println("The runtime for the removal is: " + time + "s");
			System.out.println();
			*/
			
			//prints the unsorted list, is timed
			start = System.currentTimeMillis();
			System.out.println("HASH LIST 1: ");
			//calls fileInput method, is timed
			fileInputHash(hList);
			end = System.currentTimeMillis();
			time = (double)(end - start) / 1000;
			System.out.println("The runtime for this list is: " + time + "s");
			//hList.printList();
			System.out.println();
			
			start = System.currentTimeMillis();
			System.out.println("HASH LIST 2: ");
			//calls fileInput method, is timed
			fileInputHash(hList2);
			end = System.currentTimeMillis();
			time = (double)(end - start) / 1000;
			System.out.println("The runtime for this list is: " + time + "s");
			//hList2.printList();
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
		
		//puts a blank line before each to make it easier to see where each list starts and ends
		/*System.out.println();
		list.printHunNode();
		*/
		
		//this would call the print 100 count method, but isn't needed at this point
		/*System.out.println();
		list.printHunCount();*/
		
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
	
	public static void skipRemove(SkipList s) throws Exception {
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
						s.remove(word);
					}
					
				}
	}
	public static void remove(LinkedList list) throws Exception {
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
					list.remove(e);
					}
					
				}
	}
	public static void remove2(NodeToTop list) throws Exception {
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
					list.remove2(e);
					
					}	
				}
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

//recreates the to top list for the second remove
public static void topRecreate(LinkedList list) throws Exception {
	
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
}
}

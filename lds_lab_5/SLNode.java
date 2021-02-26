package lds_lab_5;

//class for our skip list node, based on the link given in the lab 3 .pdf
public class SLNode {
	
	//variables for key and value which will be used in our SL node
	public String word;
	public Integer number;
	
	//node links for up, down, left and right
	public SLNode up, down, left, right;
	public int pos;
	
	public static String negInf = "-oo"; //-infinity word value for tail of list
	public static String posInf = "oo";  //+infinity word value for head of list
	
	//constructor for the SLNode class
	public SLNode(String w, Integer n) {
		
		//sets key and value to local variables word and number
		word = w;
		number = n;
		
		//set links up to point to null
		up = down = left = right = null;
		
	}
	
	//method for returning word in node
	public String getWord() {
		
		return word;
		
	}
	
	//method for returning number stored in the node
	public Integer getNumber() {
		
		return number;
		
	}
	
	//method for changing the number assigned to a node
	public Integer setNumber(Integer num) {
		
		//makes previous number variable that holds current value of number
		Integer prevNum = number;
		//sets number to the paramater's value
		number = num;
		//returns the previous number
		return prevNum;
		
	}
	
	//method for turning the node into a string
	public String toString() {
			
		return "(" + word + "," + number +")";
			
	}
		
	//node for checking if an object is equal to another object in the list
	public boolean equals(Object obj) {
		
		//entry node
		SLNode entry;
		
		try {
			
			entry = (SLNode) obj;
			
		}
		
		catch (Exception e) {
			
			return false;
			
		}
		
		//return the comparison between the entries word and number and the
		//word and number of the SLNode
		return (entry.getWord() == word && entry.getNumber() == number);
		
	}
}

package lds_lab_5;

public class BSTNode {

		//class variables for word and number
		public String word;
		public Integer number;
		
		
		public BSTNode left, right, parent;
		
	public BSTNode(String w) {
		
		word = w;
		number = 1;
		
		left = right = null;
		parent = null;
	}

	//method for returning word in node
	public String getWord() {
		
		return word;
		
	}
	
	//method for returning number stored in the node
	public Integer getNumber() {
		
		return number;
		
	}
}

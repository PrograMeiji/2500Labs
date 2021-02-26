package lds_lab_5;

//class for creating the search tree and gathering stats on how it runs
public class BinarySearchTree {
	
	//root node of the tree
	public BSTNode root;
	
	//height of the tree
	public int height;
	
	//variables for statistics
	public long wordNum, nodeNum, compareNum, referenceNum;
	
	//constructor for BST and sets variables for an empty tree
	public BinarySearchTree() {
		
		
		root = null;
		
		height = 0;
		
		wordNum = nodeNum = compareNum = referenceNum = 0;
		
	}
	
	public void insert(String s) {
		
		//z is inserted node, x is current node and starts at the root, y is a node lagging behind x by 1
		BSTNode z = new BSTNode(s);
		BSTNode x = root;
		BSTNode y = null;		
		
		//while loop runs until we reach a leaf node
		while(x != null) {
			
			y = x;
			referenceNum++;
			
			//compare integer for comparing z and x
			int zComX = z.word.compareTo(x.word);
			compareNum++;
			
			//checks if z is less than x
			if(zComX < 0) {
				x = x.left;
				referenceNum++;
			}
			//if z is greater than x
			else if (zComX > 0){
				x = x.right;
				referenceNum++;
			}
			//otherwise they must be equal
			else {
				x.number++;
				return;
			}
		}
		z.parent = y;
		referenceNum++;
		//checks is list is empty, then places z in the appropriate spot
		if (y == null) {
			root = z;
			referenceNum++;
			compareNum++;
		}
		//compares z and y
		else if(z.word.compareTo(y.word) < 0) {
			y.left = z;
			referenceNum++;
			compareNum++;
		}
		else {
			y.right = z;
			referenceNum++;
			compareNum++;
		}
	}
	
	//method for printing 100 nodes
	public void displayFirst100() {
		
		BSTNode p = minimum(root);
		System.out.println("First 100 Entries: ");
		
		for (int i = 0; i < 100; i++) {
			System.out.println(p.getWord() + " " + p.getNumber());
			p = successor(p);
		}
	}
	//successor method
	private BSTNode successor(BSTNode n) {
		
		BSTNode y = null;
		
		if(n.right != null) {
			return minimum(n.right);
		}
		y = n.parent;
		while( y != null && n == y.right) {
			n = y;
			y = y.parent;
		}
		return y;
		
	}
	//method for returning the smallest thing in the tree
	private BSTNode minimum(BSTNode n) {
		
		while(n.left != null) {
			n = n.left;
		}
		return n;
	}
	
	public void printStatistics() {
		
		height = traversal(root);
		System.out.println("The number of words in the tree is: " + wordNum);
		System.out.println("The number of nodes in the tree is: " + nodeNum);
		System.out.println("The height of the tree is: " + height);
		System.out.println("The number of comparisons made is: " + compareNum);
		System.out.println("The number of reference changes made is: " + referenceNum);
	}
	
	//recursive traverse for calculating the statistics
	public int traversal(BSTNode n) {
		
		nodeNum++;
		wordNum += n.number;
		int leftHeight = 1;
		int rightHeight = 1;
		
		if(n.left != null) {
			leftHeight += traversal(n.left);
		}
		if(n.right != null) {
			rightHeight += traversal(n.right);
		}
		if(leftHeight > rightHeight) {
			return leftHeight;
		}
		else {
			return rightHeight;
		}
	}

}

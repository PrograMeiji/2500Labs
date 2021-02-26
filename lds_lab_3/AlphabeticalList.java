//this class is for alphabetizing the list as the nodes are placed

package lds_lab_3;

public class AlphabeticalList extends LinkedList{
	
	//when a new node is added, it checks nodes until it finds 
	//a beginning letter that is after it and goes before that node
	public void add(Element element) {
		
		//variables for current node of the list and insertion node
		Node currentNode;
		Node nodeInsert = null;
		currentNode = head;
		
		//increase compare because of if statement comparison
		compareNum++;
		
		//iterates from the beginning of the stack to the end of the stack
		while (currentNode != null) {
			
			//increases number of comparisons
			compareNum++;
				
			//if the currentNode word is the same as a pre-existing node
			if (currentNode.element.word.equals(element.word)) {
				
				//increase the number of those words
				currentNode.element.number++;
				return;
				
			}
			
			//if the current node word is less than the elements word,
			//then the word goes before the compared word
			//Ex. "a" comparedTo "b" will result in -1, therefore a should go before b
			if (currentNode.element.word.compareTo(element.word) < 0) {
				
				//sets inserted node to currentNode
				nodeInsert = currentNode;
					
			}
			
			
			//sets current node to the next node so loop will iterate through the while loop
			currentNode = currentNode.next;
	
		}
		
		
		//creates new node for reference
		Node temp = new Node();
		//sets the element at temp equal to the element
		temp.element = element;
		
		//if the node isn't a new node then increase reference count by 2
		//and change the first node
		if(nodeInsert == null) {
			
			//sets temp pointer to head
			temp.next = head;
			//sets head to temp
			head = temp;
			//increases reference number by 2 because 2 reference pointers were changed
			referenceNum += 2;
			return;
			
		}
		
		//makes temp pointer equal to inserted node's pointer
		temp.next = nodeInsert.next;
		//points inserted node to temp
		nodeInsert.next = temp;
		//increases reference number by 2 because two reference pointers were changed
		referenceNum += 2;
		
	}
}

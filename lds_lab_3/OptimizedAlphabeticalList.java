package lds_lab_3;
//this class is for alphabetizing the list as the nodes are placed,
//and updated to start from the prevWord if the comparison comes after that word alphabetically,
//otherwise, it starts at the top

public class OptimizedAlphabeticalList extends LinkedList {
	//class variable for prevWord
		Node prevWord = null;
		//when a new node is added, it checks nodes until it finds 
		//a beginning letter that is after it and goes before that node
		public void add(Element element) {
			
			//variables for current node of the list and insertion node
			Node currentNode;
			Node nodeInsert = null;
			
			//if the word comes after prevWord, set currentNode to the previWord
			if (prevWord != null && prevWord.element.word.compareTo(element.word) < 0) {
				
				currentNode = prevWord;

			}
			
			//else set it to the start of the list
			else {
				
				currentNode = head;
				
			}
			
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
					//sets previous node to the incremented node
					prevWord = currentNode;
					return;
					
				}
				
				//if the current node word is less than the elements word,
				//then the word goes before the compared word
				//Ex. "a" comparedTo "b" will result in -1, therefore a should go before b
				if (currentNode.element.word.compareTo(element.word) < 0) {
					
					//sets inserted node to currentNode
					nodeInsert = currentNode;
					//sets previous node to the previous node before incrementing
					prevWord = nodeInsert;
						
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

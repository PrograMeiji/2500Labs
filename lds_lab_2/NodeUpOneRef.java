//this class moves repeated words up one place in the list,
//and increments their count as the list is created
package lds_lab_2;

public class NodeUpOneRef extends LinkedList {
	
	public void add(Element element) {
		
		//creates currentNode variable
		Node currentNode = head;
		//previous node variable
		Node prevNode = null;
		//node 2 behind the current node
		Node twoPrevNode = null;
		//runs through the list until the end
		while(currentNode != null) {
			
			//increase the number of comparisons each time the loop runs
			compareNum++;
			
			//checks if the compared word is the same as an existing word in the list
			if(currentNode.element.word.equals(element.word)) {
				
				//increases the number at the node of the same word
				currentNode.element.number++;
				
				//if the 2nd prevNode is null and the prevNode isn't null,
				//then move the node to the top of the list
				if(twoPrevNode == null && prevNode != null) {
					
					//sets head to current node
					head = currentNode;
					//sets the previous node pointer to after the current node
					prevNode.next =  currentNode.next;
					//points current node to the node before it
					currentNode.next = prevNode;
					//increase the number of references by three
					referenceNum += 3;
					
				}
				
				//if the 2nd prevNode and prevNode aren't null,
				//then move the current node back one space so it is between them
				else if (twoPrevNode != null && prevNode != null) {
					
					//set node 2 back to the same as current node
					twoPrevNode.next = currentNode;
					//points previous node to after next node
					prevNode.next = currentNode.next;
					//points current node to previous node
					currentNode.next = prevNode;
					//increase reference number by 3
					referenceNum += 3;
					
				}
				
				return;
				
			}
			
			//sets node 2 back equal to the previous node
			twoPrevNode = prevNode;
			//sets the node previous to current node
			prevNode = currentNode;
			//increments current node through the list
			currentNode = currentNode.next;
			//increase reference by 3
			referenceNum += 3;
			
		}
		
		//sets a previous head variable to head
		Node prevHead = head;
		//makes new head node
		head = new Node();
		//sets the head's elements equal to element
		head.element = element;
		//points head equal to the previous head
		head.next = prevHead;
		//increases references by 2
		referenceNum += 2;
		
	}

}

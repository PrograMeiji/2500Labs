//this class puts new nodes at the top of the list,
//if there is a repeated word, its node is moved to the top of the list
package lds_lab_4;

public class NodeToTop extends LinkedList {
	
	//method for adding nodes to the list
	public void add(Element element) {
		
		//sets current node to the top of the list
		Node currentNode = head;
		//node for previous node
		Node prevNode = null;
		
		while (currentNode != null) {
			
			//increase number of comparisons
			compareNum++;
			
			//if the current node's word is the same as the elements word,
			//move the node to the top of the list and increase word number
			if (currentNode.element.word.equals(element.word)) {
				
				
				//increases elements number
				currentNode.element.number++;
				
				//if prevNode isn't null, move the node to beginning of the list
				if(prevNode != null) {
					
					//sets node before current to node after current
					prevNode.next = currentNode.next;
					//points current node to head
					currentNode.next = head;
					//makes current node the beginning of the list
					head = currentNode;
					//increases number of reference changes by 3 because
					//3 references have to be manipulated to move the node correctly
					referenceNum += 3;
					
				}

				return;
				
			}
			
			//increases reference number by 2 because 2 references were changed
			referenceNum += 2;
			//prevNode is set to current node so when it is currentNode is switched,
			//prevNode will be the previous node
			prevNode = currentNode;
			//increments currentNode to the next node in list
			currentNode = currentNode.next;
			
		}
		
		//stores head in prevHead node
		Node prevHead = head;
		//makes head a new node
		head = new Node();
		//element at head is set to element
		head.element = element;
		//points head to prevHead
		head.next = prevHead;
		//increases number of references by 2 because we changed 2 links
		referenceNum += 2;
		
	}
	//to top remove
	public void remove2(Element element) {
		
		Node currentNode = head;
		Node prevNode = null;
		
		while (currentNode != null){
			
			compareRemove2++;
			if (currentNode.element.word.equals(element.word)) {
				
				compareRemove2++;
				if(currentNode.element.number > 1) {
					
					currentNode.element.number -= 1;
					
					if (prevNode != null) {
						
						referenceRemove2 += 3;
						
						prevNode.next = currentNode.next;
						
						currentNode.next = head;
						
						head = currentNode;
						
						return;
					}
				}
				
				compareRemove2++;
				
				if(currentNode.element.number == 1) {
					
					compareRemove2++;
					if(currentNode == head) {
						
						referenceRemove2++;
					
						head = currentNode.next;
					
						return;
					}
					else {
					
					referenceRemove2++;
					
					prevNode.next = currentNode;
					}
				}
			}
			referenceRemove2 += 2;
			prevNode = currentNode;
			currentNode = currentNode.next;
		}
	}
	
	public void printRemove2() {
		
		System.out.println();
		System.out.println("The number of comparison removals is: " + compareRemove2);
		System.out.println("The number of reference removals is: " + referenceRemove2);
		
	}
}

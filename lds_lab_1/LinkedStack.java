package lds_lab_1;

public class LinkedStack<Element> implements StackInterface<Element> {//creates stack to call upon by other classes.
	
	private Node start;//starting node in the stack.
	private int length;//number of elements in the stack.
	
	private class Node {
		Element element;
		Node next;//next node.
		
	}
	
	public LinkedStack() {//create the stack with first node being start.
		start = null;
		length = 0;
	}
	
	public boolean isEmpty() {//checks if the length is zero.
		return(length == 0);
	}
	
	public void push(Element element) {//push element onto the stack.
		Node prevStart = start;
		start = new Node();
		start.element = element;
		start.next = prevStart;
		length++;
	}
	
	public Element pop() {//pop element off of stack.
		Element element = start.element;
		start = start.next;
		length--;
		return element;
	}
	
	public Element top() {//view top of stack. If it's empty, throw exception.
		if (!isEmpty()) {
			return start.element;
		}
		else {
			throw new Exception("Cannot top because stack is empty.");
		}
	}
}

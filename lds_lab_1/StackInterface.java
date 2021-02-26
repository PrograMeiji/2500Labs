package lds_lab_1;

public interface StackInterface<Element> {
	
	void push(Element element);
	//pushes element onto stack. 
	//We don't have to worry about the stack being full because our list is unbounded.
	Element pop() throws Exception;
	//pops the stack as long as it's not empty. If it is, then it throws an exception.
	boolean isEmpty();
	//checks if stack is empty.
	Element top();
	//returns top of stack.
}

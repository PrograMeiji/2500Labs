//this class sets up the element object that our Linked List will be comprised of
package lds_lab_2;

public class Element {
	
	public String word;//creates word variable that will be tied to obj element
	public int number;//creates integer variable that will be tied to obj element

	Element() {
		
		//ties both word and number to Element
		this.word = null;
		this.number = 0;
		
	}
	
	//constructor for element
	public Element(String Word, int Number) {
		
		super();
		this.word = Word;
		this.number = Number;
		
	}
}

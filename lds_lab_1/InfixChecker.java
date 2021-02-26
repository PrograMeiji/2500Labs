package lds_lab_1;
public class InfixChecker {
	
	
	//Following method takes user input into a string that we can use.
	public String userInput(String input) {
		
		if (input.equals("")) {
			System.out.println("Program Terminated.");
			System.exit(0);
		}
		//input is passed into each method
		if (infixSymbolCheck(input) == true &&	
			checkConsecOp(input) == true &&
			checkParens(input) == true) {//if all are true, input is a valid infix notation.
			
			return input;
		}
		else {
			System.out.println("Invalid infix expression inputted.");
			System.out.println();
			return null;
		}
	}

	//Following method checks each char to see if there are any incorrect symbols.
	public Boolean infixSymbolCheck(String i) {
	
		
		//create a variable for all valid characters.
		char ch = '\u0000';
		boolean validChar = (ch == '0' || ch == '1' || ch == '2' || ch == '3' ||
				 ch == '4' || ch == '5' || ch == '6' || ch == '7' || ch == '8' ||ch <= '9' || 
				 ch == '(' || ch == ')' || 
				 ch == '+' || ch == '-' || ch == '*' || ch == '/' ||
				 ch == '^' || ch == 'Q' || ch == 'C' ||
				 ch == '<' || ch == '>' || ch == '%');
		
		//iterates through input to find any invalid characters.
		for (int count = 0; count < i.length(); count++) {
			ch = i.charAt(count);
			if (!validChar) {
				
				return false;
			}
		}
		return true;
	}
	
	//check to make sure there aren't two consecutive operators.
	public Boolean checkConsecOp(String i){
		
		char ch = '\u0000';
		
		boolean opChar = (ch == '+' || ch == '-' || ch == '*' || ch == '/' ||
				 ch == '^' || ch == 'Q' || ch == 'C' ||
				 ch == '<' || ch == '>' || ch == '%'); //this boolean is a check for operators only and doesn't include parenthesis or numbers.
		
		char ch2 = '\u0000';//need second char for the next char in the string.		
		boolean opChar2 = (ch2 == '+' || ch2 == '-' || ch2 == '*' || ch2 == '/' ||
				 ch2 == '^' || ch2 == 'Q' || ch2 == 'C' ||
				 ch2 == '<' || ch2 == '>' || ch2 == '%');//boolean for ch2 that checks if ch2 is an operator.
		
		for (int count = 0; count < i.length() - 1; count++) {
			
			int next = count + 1;
			
			ch = i.charAt(count);
			ch2 = i.charAt(next);
			
			//if both booleans are true, that means there are two operators next to each other.
			if(opChar && opChar2) {
			
				return false;
			}
		}
		return true;
	}
	
	/*check to make sure there is the same number of left and right parenthesis and
	that a left parenthesis is not immediately followed by a right parenthesis.*/
	public Boolean checkParens(String i) {
		
		int ctLeftParen = 0;
		int ctRightParen = 0;
		
		for (int count = 0; count < i.length(); count ++) {
			//counters for right and left parenthesis.
			
			if (i.charAt(count) == '(') {
				ctLeftParen++;
			}
			else if(i.charAt(count) == ')') {
				ctRightParen++;
			}
		}
		if (ctLeftParen != ctRightParen) {//if parenthesis are different numbers, incorrect expression.
			
			return false;
		}
		return true;
	}
}

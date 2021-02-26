package lds_lab_1;
import java.util.Scanner;

public class ExpressionEvaluator {
	
	public static void main(String args[]) {
	
		InfixChecker check = new InfixChecker();
		ConvertToPostfix conv = new ConvertToPostfix();
		String input = " ";
		System.out.println("Please enter a valid infix expression.");
		
		Scanner scn = new Scanner(System.in);
		
		while (!input.equals("")) {
			
			input = scn.nextLine().replaceAll("\\s+", ""); //change the input string to contain no spaces.
			try {
				check.userInput(input);
				//if a valid expression is inputted, then run the conversion and evaluator.
				if (check.infixSymbolCheck(input) == true &&	
					check.checkConsecOp(input) == true &&
					check.checkParens(input) == true) {
					
					conv.conversion(input);	//postfix evaluator is called at the end of the converter.
				}
			}
			catch (Exception e){
				System.out.println(e.getMessage());//gets exception text without breaking out of the terminal.
			}
		}
		System.exit(0);
	}
}

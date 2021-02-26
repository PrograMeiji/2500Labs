package lds_lab_1;
import java.util.Scanner;
import java.lang.Math;

public class PostfixEvaluator {
	
	public int postfixEvaluator(String i){
		
		StackInterface<Integer> stack = new LinkedStack<Integer>();
		
		int value;
		String operator;
	
		int operand1 = 0, operand2 = 0;
		
		int result = 0;
		
		Scanner tokenizer = new Scanner(i);

		while (tokenizer.hasNext()) {//while theres more tokens, run the loop.
			
			if (tokenizer.hasNextInt()) {//if the value is an integer push it onto the stack.
				value = tokenizer.nextInt();
				stack.push(value);
			}
			else {
				
				operator = tokenizer.next();//takes the operator
				
				if (stack.isEmpty() && operator.contains("C") && operator.contains("Q")) {
					throw new Exception("Not enough operands - stack " +
										"underflow");
				}
				if (!operator.contains("C") && !operator.contains("Q")) {
					operand2 = stack.top();
					stack.pop();//gets respective operand1 for operator.
				}
				
				if (stack.isEmpty() && operator.contains("C") && operator.contains("Q")) {
					throw new Exception("Not enough operands - stack" +
										"underflow");
				}
				
				if (!operator.contains("C") && !operator.contains("Q")) {
					operand1 = stack.top();
					stack.pop();//gets respective operand2
				}
				
				switch (operator) {//runs different functions depending on the operator.
				
				case "+":
					result = operand1 + operand2;
					break;
					
				case "-":
					result = operand1 - operand2;
					break;
					
				case "*":
					result = operand1 * operand2;
					break;
					
				case "/":
					result = operand1 / operand2;
					break;
					
				case "^":
					result = (int) Math.pow(operand1, operand2);
					break;
					
				case "Q":
					result = (int) Math.sqrt(stack.pop());
					break;
					
				case "C":
					result = (int) Math.cbrt(stack.pop());
					break;
					
				case "<":
					result = operand1 << operand2;
					break;
					
				case ">":
					result = operand1 >> operand2;
					break;
					
				case "%":
					result = operand1 % operand2;
					break;
				}
				stack.push(result);
			}
		}
		
		if (stack.isEmpty()) {
			throw new Exception("Not enough operands - stack undeflow");
		}
		
		result = stack.top();
		stack.pop();
		
		if (!stack.isEmpty()) {
			throw new Exception("Too many operands - operands left over");
		}
		//makes sure answer is in the approximate 2 billion range.
		if (result > 2000000000 || result < (-2000000000)) {
			throw new Exception("Out of bounds error, answer magnitude is too large.");
		}
		
		else {
			System.out.println(result);
			return result;
			}
		}
	}

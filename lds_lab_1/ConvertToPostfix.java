package lds_lab_1;

public class ConvertToPostfix {
	
	public ConvertToPostfix(){
		
	}
	
	public void conversion(String i) {
		
		PostfixEvaluator p = new PostfixEvaluator();
		
		String post = "";//the numbers of the postfix string that will be outputted to the user.
		int count = 0;
		char ch = '\u0000';
		
		StackInterface<Character> stack = new LinkedStack<Character>();//create stack
		
		while (count < i.length()) {//while there is still more tokens in input, run the code.
			
			int next = count + 1;
			
			ch = i.charAt(count);//sets ch to the next char every time count increases.
			
			//HANDLES RIGHT PARENTHESIS.
			if (ch == ')') {
				stack.top();//get top token of the stack.
				
				while (stack.top() != '(') {//while stack is not empty and not left parenthesis, run the code. 
					post += stack.top();//add top ch of stack to post.
					post += " ";// add space after operator.
					stack.pop();//pops top ch of stack.
					stack.top();//get the next ch on the stack.
				}
				stack.pop();//gets rid of left parenthesis.
			}
			
			//HANDLES OPERATORS.
			else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' ||
				 ch == '^' || ch == 'Q' || ch == 'C' ||
				 ch == '<' || ch == '>' || ch == '%'){//if the next ch is an operator then, run the code.
				//while the stack isn't empty and top isn't a left parenthesis.
				
				//stack.top();
				while (!stack.isEmpty() && stack.top() != '(') {
					post += stack.top();
					post += " ";
					stack.pop();
				}
				stack.push(ch);//push the ch onto the stack.
			}
			
			//HANDLES LEFT PARENTHESIS.
			else if (ch == '(') {
				stack.push(ch);//push left parenthesis onto stack.
			}
			
			//HANDLES OPERANDS.
			else {//if it's not an operator, or left parenthesis, or right parenthesis, then it must be a number.
				post += i.charAt(count);//adds number to the string.
				//if the next char isn't a number, put a space in post.
				//this ensure that multi-digit numbers a processed correctly.
				if (next < i.length()) {
					
					if (i.charAt(next) != '0' && i.charAt(next) != '1' &&
					i.charAt(next) != '2' && i.charAt(next) != '3' &&
					i.charAt(next) != '4' && i.charAt(next) != '5' &&
					i.charAt(next) != '6' && i.charAt(next) != '7' &&
					i.charAt(next) != '8' && i.charAt(next) != '9') {
						
					post += " ";
					}
				}
			}
			count++;//increase count.
		}
		while (!stack.isEmpty()) {
			post += " ";// add a space between any operators left in stack.
			post += stack.top();
			stack.pop();
		}
		post = post.replaceAll("  ", " ");
		System.out.println(post);
		p.postfixEvaluator(post);//feed post with colons into postfixEvaluator.
	}
}


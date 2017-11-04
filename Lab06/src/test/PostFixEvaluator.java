package test;

import java.util.Scanner;

public class PostFixEvaluator
{
	public static int evaluate(String expression)
	{
		Scanner sc = new Scanner(expression);
		StackInterface<Integer> stack = new LinkedStack<Integer>();  

		int value;
		String operator;
		int operand1, operand2;
		int result = 0;

		while (sc.hasNext())
		{
			if (sc.hasNextInt())
			{
				// Process operand.
				value = sc.nextInt();
				if (stack.isFull())
					throw new PostFixException("Too many operands-stack overflow");
				stack.push(value);
			}
			else
			{
				// Process operator.
				operator = sc.next();

				// Check for illegal symbol
				if (!(operator.equals("/") || operator.equals("*") ||
						operator.equals("+") || operator.equals("-")))
					throw new PostFixException("Illegal symbol: " + operator);

				// Obtain second operand from stack.
				if (stack.isEmpty())
					throw new PostFixException("Not enough operands-stack underflow");
				operand2 = stack.peek();
				stack.pop();

				// Obtain first operand from stack.
				if (stack.isEmpty())
					throw new PostFixException("Not enough operands-stack underflow");
				operand1 = stack.peek();
				stack.pop();

				// Perform operation.
				if (operator.equals("/"))
					result = operand1 / operand2;
				else
					if(operator.equals("*"))
						result = operand1 * operand2;
					else
						if(operator.equals("+"))
							result = operand1 + operand2;
						else
							if(operator.equals("-"))
								result = operand1 - operand2;

				// Push result of operation onto stack.
				stack.push(result);
			}
		}


		// Obtain final result from stack. 
		if (stack.isEmpty())
			throw new PostFixException("Not enough operands-stack underflow");
		result = stack.peek();
		stack.pop();

		// Stack should now be empty.
		if (!stack.isEmpty())
			throw new PostFixException("Too many operands-operands left over");

		// Return the final.
		return result;
	}
}
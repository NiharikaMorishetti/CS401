package test;

public class PFixCLI {
	public static void main(String[] args) {

		String expression = "1 3 8 * +"; // expression to be evaluated
		System.out.println(expression);
		int result, result1, result2; // result of evaluation
		result = PostFixEvaluator.evaluate(expression);
		System.out.println("Result = " + result + "\n");

		String expression1 = "8 2 - 8 4 / + 6 1 - + 6 2 / -"; // expression to be evaluated
		System.out.println(expression1);
		result1 = PostFixEvaluator.evaluate(expression1);
		System.out.println("Result = " + result1 + "\n");

		String expression2 = "8 3 - 4 6 * - 3 +"; // expression to be evaluated
		System.out.println(expression2);
		result2 = PostFixEvaluator.evaluate(expression2);
		System.out.println("Result = " + result2 + "\n");

	}
}

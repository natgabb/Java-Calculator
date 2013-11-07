// Natacha Gabbamonte
// 0932340
// CalculatorUtility.java

package utilities;

import exceptions.DAIllegalArgumentException;
import exceptions.DAIndexOutOfBoundsException;
import exceptions.DANullPointerException;
import exceptions.DANumberFormatException;
import arrays.DynamicArray;
import interfaces.DequeInterface;
import interfaces.QueueInterface;
import interfaces.StackInterface;

/**
 * 
 * This class defines a Calculator utility that does conversions from infix to
 * postfix and evaluates the result from a postfix.
 * 
 * @author Natacha Gabbamonte 0932340
 * 
 */
public class CalculatorUtility {

	/**
	 * Transforms an infix queue to a postfix queue. Ex: 1+3*2 becomes 132*+ Ex:
	 * (1+3)*2 becomes 13+2*
	 * 
	 * @param infix
	 *            The infix queue.
	 * @return The postfix queue.
	 * @throws DAIndexOutOfBoundsException
	 *             If an illegal operation occurs.
	 * @throws DANullPointerException
	 *             If the queue sent in is null.
	 * @throws DAIllegalArgumentException
	 *             If the queue contains illegal arguments or is empty.
	 */
	public static QueueInterface<String> infixToPostfix(
			QueueInterface<String> infix) throws DAIndexOutOfBoundsException,
			DANullPointerException, DAIllegalArgumentException {
		if (infix == null)
			throw new DANullPointerException("Infix queue should not be null.");
		QueueInterface<String> postfix = new DynamicArray<String>();
		StackInterface<String> operators = new DynamicArray<String>();
		String element;
		String operator;

		while (infix.size() > 0) {
			element = infix.remove();

			if (element == null)
				throw new DANullPointerException("Elements should not be null.");
			if (isOperator(element)) {
				if (operators.size() == 0)
					operators.push(element);
				else {
					// Compare the precedence of the Infix queue operand with
					// the operand on top of the Operators stack.
					if (getPrecedence(element) > getPrecedence(operators.peek())) {
						operators.push(element);
					} else {
						operator = operators.pop();
						postfix.add(operator);
						operators.push(element);
					}
				}
			} else if (element.equals("(")) {
				operators.push(element);
			} else if (element.equals(")")) {
				try {
					while (operators.peek() != "(") {
						postfix.add(operators.pop());
					}
				} catch (DAIndexOutOfBoundsException e) {
					throw new DAIllegalArgumentException(
							"Illegal syntax. Closing brace ')' without opening brace '('.");
				}
				operators.pop();
			} else if (isDouble(element)) {
				postfix.add(element);
			} else
				throw new DAIllegalArgumentException(
						"Your input has invalid characters."
								+ " It can only contain numbers (0-9) and operators (+ - / *)");
		}
		while (operators.size() > 0) {
			String op = operators.pop();
			if (op.equals("("))
				throw new DAIllegalArgumentException(
						"Illegal syntax. Opening brace '(' without closing brace ')'.");
			else
				postfix.add(op);
		}

		return postfix;
	}

	/**
	 * Takes a postfix queue and evaluates it.
	 * 
	 * @param postfix
	 *            The postfix queue.
	 * @return A string containing the solved equation.
	 * @throws DAIndexOutOfBoundsException
	 *             If an illegal operation occurs. This exception will also
	 *             occur if the postfix queue has an illegal format.
	 * @throws DANumberFormatException
	 *             If you try to divide by zero.
	 * @throws DAIllegalArgumentException
	 *             If the the postfix gueue has an illegal format.
	 * @throws DANullPointerException
	 *             If the postfix is null
	 */
	public static String evaluatePostfix(QueueInterface<String> postfix)
			throws DANumberFormatException, DAIllegalArgumentException,
			DAIndexOutOfBoundsException, DANullPointerException {
		if (postfix == null)
			throw new DANullPointerException(
					"The postfix queue cannot be null or empty.");
		if (postfix.size() == 0)
			throw new DAIllegalArgumentException(
					"The postfix queue cannot be empty.");
		StackInterface<String> operands = new DynamicArray<String>();
		DequeInterface<String> expression = new DynamicArray<String>();
		String element;

		while (postfix.size() > 0) {
			element = postfix.remove();
			if (isDouble(element)) {
				operands.push(element);
			} else if (isOperator(element)) { // There should already have been
												// one operator.
				// DAIndexOutOfBoundsException may occur if the postfix queue is
				// illegal.
				expression.addFirst(operands.pop());
				expression.addFirst(element);
				expression.addFirst(operands.pop());
				operands.push(evaluateExpression(expression));
			}
		}
		if (operands.size() == 0)
			throw new DAIllegalArgumentException(
					"The postfix queue contains illegal arguments.");
		return operands.pop();
	}

	/*
	 * This checks to see if a string can be parsed into a double.
	 * 
	 * @param element The element to evaluate.
	 * 
	 * @return Whether or not the element can be parsed into a double.
	 */
	private static boolean isDouble(String element) {
		try {
			Double.parseDouble(element);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/*
	 * This checks whether or the parameter is an operator.
	 * 
	 * @param o The operator.
	 * 
	 * @return Whether or not it is an operator.
	 */
	private static boolean isOperator(String o) {
		return (o.equals("+") || o.equals("-") || o.equals("/") || o
				.equals("*"));
	}

	/*
	 * The higher the precedence, the more important the operator.
	 * 
	 * @param operator The operator to be checked.
	 * 
	 * @return the precedence The precedence of the operator.
	 */
	private static int getPrecedence(String operator) {
		switch (operator) {
		case "*":
		case "/":
			return 2;
		case "+":
		case "-":
			return 1;
		case "(":
			return 0;
		}
		return -1;
	}

	/*
	 * This evaluates an expression.
	 * 
	 * @param expression The deque containing the expression to be evaluated.
	 * 
	 * @return The result of the evaluation.
	 * 
	 * @throws DAIndexOutOfBoundsException If an illegal operation occurs.
	 * 
	 * @throws DANumberFormatException
	 */
	private static String evaluateExpression(DequeInterface<String> expression)
			throws DAIndexOutOfBoundsException, DANumberFormatException {
		String result = "";
		double operand1 = Double.parseDouble(expression.removeFirst());
		String operator = expression.removeFirst();
		double operand2 = Double.parseDouble(expression.removeFirst());
		switch (operator) {
		case "+":
			result = (operand1 + operand2) + "";
			break;
		case "-":
			result = (operand1 - operand2) + "";
			break;
		case "/":
			if (operand2 == 0)
				throw new DANumberFormatException("Cannot divide by zero.");
			result = (operand1 / operand2) + "";
			break;
		case "*":
			result = (operand1 * operand2) + "";
			break;
		}
		return result;
	}
}

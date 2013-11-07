// Natacha Gabbamonte
// 0932340
// CalculatorUtilityTest.java

package tests;

import static org.junit.Assert.*;
import interfaces.QueueInterface;

import org.junit.Test;

import utilities.CalculatorUtility;

import exceptions.DAIllegalArgumentException;
import exceptions.DAIndexOutOfBoundsException;
import exceptions.DANullPointerException;
import exceptions.DANumberFormatException;

import arrays.DynamicArray;

public class CalculatorUtilityTest {
	
	///////////////////////////////////////////////////////////////////////////////////////////
	// TESTING INFIXTOPOSTFIX                                                                //
	///////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Test method for {@link
	 * utilities.CalculatorUtility#infixToPostfix(QueueInterface<T>)}. Tests for
	 * generic conversion from infix to postfix.
	 */
	@Test
	public void testInfixToPostfix1() throws DAIndexOutOfBoundsException,
			DANullPointerException, DAIllegalArgumentException {

		QueueInterface<String> infix = new DynamicArray<String>();
		infix.add("3");
		infix.add("+");
		infix.add("3");
		infix.add("*");
		infix.add("2");

		QueueInterface<String> postfix = CalculatorUtility
				.infixToPostfix(infix);
		assertEquals("3", postfix.remove());
		assertEquals("3", postfix.remove());
		assertEquals("2", postfix.remove());
		assertEquals("*", postfix.remove());
		assertEquals("+", postfix.remove());
	}

	/**
	 * Test method for {@link
	 * utilities.CalculatorUtility#infixToPostfix(QueueInterface<T>)}. Tests for
	 * generic conversion from infix to postfix.
	 */
	@Test
	public void testInfixToPostfix2() throws DAIndexOutOfBoundsException,
			DANullPointerException, DAIllegalArgumentException {

		QueueInterface<String> infix = new DynamicArray<String>();
		infix.add("3");
		infix.add("+");
		infix.add("3");
		infix.add("*");
		infix.add("2");
		infix.add("/");
		infix.add("3");
		infix.add("-");
		infix.add("2");

		QueueInterface<String> postfix = CalculatorUtility
				.infixToPostfix(infix);
		assertEquals("3", postfix.remove());
		assertEquals("3", postfix.remove());
		assertEquals("2", postfix.remove());
		assertEquals("*", postfix.remove());
		assertEquals("3", postfix.remove());
		assertEquals("/", postfix.remove());
		assertEquals("2", postfix.remove());
		assertEquals("-", postfix.remove());
		assertEquals("+", postfix.remove());
	}

	/**
	 * Test method for {@link
	 * utilities.CalculatorUtility#infixToPostfix(QueueInterface<T>)}. Tests for
	 * null in infix queue.
	 */
	@Test(expected = DANullPointerException.class)
	public void testInfixToPostfix3() throws DAIndexOutOfBoundsException,
			DANullPointerException, DAIllegalArgumentException {

		QueueInterface<String> infix = new DynamicArray<String>();
		infix.add(null);
		infix.add("+");
		infix.add("3");

		CalculatorUtility.infixToPostfix(infix);
	}

	/**
	 * Test method for {@link
	 * utilities.CalculatorUtility#infixToPostfix(QueueInterface<T>)}. Tests for
	 * illegal argument in infix queue.
	 */
	@Test(expected = DAIllegalArgumentException.class)
	public void testInfixToPostfix4() throws DAIndexOutOfBoundsException,
			DANullPointerException, DAIllegalArgumentException {

		QueueInterface<String> infix = new DynamicArray<String>();
		infix.add("hello");
		infix.add("+");
		infix.add("3");

		CalculatorUtility.infixToPostfix(infix);
	}

	/**
	 * Test method for {@link
	 * utilities.CalculatorUtility#infixToPostfix(QueueInterface<T>)}. Tests for
	 * ( ) nested operations.
	 */
	@Test
	public void testInfixToPostfix5() throws DAIndexOutOfBoundsException,
			DANullPointerException, DAIllegalArgumentException {

		QueueInterface<String> infix = new DynamicArray<String>();
		infix.add("(");
		infix.add("3");
		infix.add("*");
		infix.add("(");
		infix.add("3");
		infix.add("-");
		infix.add("4");
		infix.add(")");
		infix.add(")");
		infix.add("*");
		infix.add("(");
		infix.add("2");
		infix.add("-");
		infix.add("10");
		infix.add(")");

		QueueInterface<String> postfix = CalculatorUtility
				.infixToPostfix(infix);
		assertEquals("3", postfix.remove());
		assertEquals("3", postfix.remove());
		assertEquals("4", postfix.remove());
		assertEquals("-", postfix.remove());
		assertEquals("*", postfix.remove());
		assertEquals("2", postfix.remove());
		assertEquals("10", postfix.remove());
		assertEquals("-", postfix.remove());
		assertEquals("*", postfix.remove());
	}

	/**
	 * Test method for {@link
	 * utilities.CalculatorUtility#infixToPostfix(QueueInterface<T>)}. Tests for
	 * error "Illegal syntax. Opening brace '(' without closing brace ')'."
	 */
	@Test(expected = DAIllegalArgumentException.class)
	public void testInfixToPostfix6() throws DAIndexOutOfBoundsException,
			DANullPointerException, DAIllegalArgumentException {

		QueueInterface<String> infix = new DynamicArray<String>();
		infix.add("(");
		infix.add("3");
		infix.add("*");
		infix.add("2");

		CalculatorUtility.infixToPostfix(infix);
	}

	/**
	 * Test method for {@link
	 * utilities.CalculatorUtility#infixToPostfix(QueueInterface<T>)}. Tests for
	 * error "Illegal syntax. Closing brace ')' without opening brace '('."
	 */
	@Test(expected = DAIllegalArgumentException.class)
	public void testInfixToPostfix7() throws DAIndexOutOfBoundsException,
			DANullPointerException, DAIllegalArgumentException {

		QueueInterface<String> infix = new DynamicArray<String>();
		infix.add("3");
		infix.add("*");
		infix.add("2");
		infix.add(")");

		CalculatorUtility.infixToPostfix(infix);
	}

	/**
	 * Test method for {@link
	 * utilities.CalculatorUtility#infixToPostfix(QueueInterface<T>)}. Tests for
	 * illegal amount of operators. No exception is thrown, but the postfix is
	 * not valid.
	 * 
	 * @throws DANumberFormatException
	 * @throws NumberFormatException
	 */
	@Test
	public void testInfixToPostfix8() throws DAIndexOutOfBoundsException,
			DANullPointerException, DAIllegalArgumentException,
			NumberFormatException, DANumberFormatException {

		/*
		 * I decided to NOT make it throw an exception because the javascript
		 * infix to postfix calculator you linked us as an example shows the
		 * invalid postfix.
		 * The evaluatePostfix method will throw the exception instead.
		 */
		
		QueueInterface<String> infix = new DynamicArray<String>();
		infix.add("3");
		infix.add("*");
		infix.add("(");
		infix.add("+");
		infix.add("+");
		infix.add("3");
		infix.add(")");

		QueueInterface<String> postfix = CalculatorUtility
				.infixToPostfix(infix);
		assertEquals("3", postfix.remove());
		assertEquals("+", postfix.remove());
		assertEquals("3", postfix.remove());
		assertEquals("+", postfix.remove());
		assertEquals("*", postfix.remove());
	}

	/**
	 * Test method for {@link
	 * utilities.CalculatorUtility#infixToPostfix(QueueInterface<T>)}. Tests for
	 * an infix that starts with an operator. No exception is thrown, but the postfix is
	 * not valid.
	 * 
	 * @throws DANumberFormatException
	 * @throws NumberFormatException
	 */
	@Test
	public void testInfixToPostfix9() throws DAIndexOutOfBoundsException,
			DANullPointerException, DAIllegalArgumentException,
			NumberFormatException, DANumberFormatException {

		/*
		 * I decided to NOT make it throw an exception because the javascript
		 * infix to postfix calculator you linked us as an example shows the
		 * invalid postfix.
		 * The evaluatePostfix method will throw the exception instead.
		 */
		QueueInterface<String> infix = new DynamicArray<String>();
		infix.add("+");
		infix.add("3");
		infix.add("-");
		infix.add("2");

		QueueInterface<String> postfix = CalculatorUtility
				.infixToPostfix(infix);
		assertEquals("3", postfix.remove());
		assertEquals("+", postfix.remove());
		assertEquals("2", postfix.remove());
		assertEquals("-", postfix.remove());

	}

	///////////////////////////////////////////////////////////////////////////////////////////
	// TESTING EVALUATEPOSTFIX                                                               //
	///////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Test method for {@link
	 * utilities.CalculatorUtility#evaluatePostfix(QueueInterface<T>)}. Tests
	 * for generic evaluation of postfix.
	 */
	@Test
	public void testEvaluatePostfix1() throws DAIndexOutOfBoundsException,
			DANullPointerException, DAIllegalArgumentException,
			DANumberFormatException {
		QueueInterface<String> infix = new DynamicArray<String>();
		infix.add("3");
		infix.add("+");
		infix.add("3");
		infix.add("*");
		infix.add("2");

		QueueInterface<String> postfix = CalculatorUtility
				.infixToPostfix(infix);
		String result = CalculatorUtility.evaluatePostfix(postfix);
		assertEquals("9.0", result);
	}

	/**
	 * Test method for {@link
	 * utilities.CalculatorUtility#evaluatePostfix(QueueInterface<T>)}. Tests
	 * for generic evaluation of postfix.
	 */
	@Test
	public void testEvaluatePostfix2() throws DAIndexOutOfBoundsException,
			DANullPointerException, DAIllegalArgumentException,
			DANumberFormatException {
		QueueInterface<String> infix = new DynamicArray<String>();
		infix.add("3");
		infix.add("+");
		infix.add("3");
		infix.add("*");
		infix.add("2");
		infix.add("/");
		infix.add("3");
		infix.add("-");
		infix.add("2");

		QueueInterface<String> postfix = CalculatorUtility
				.infixToPostfix(infix);
		String result = CalculatorUtility.evaluatePostfix(postfix);
		assertEquals("3.0", result);
	}

	/**
	 * Test method for {@link
	 * utilities.CalculatorUtility#evaluatePostfix(QueueInterface<T>)}. Tests
	 * for generic evaluation of postfix but with nested operations.
	 */
	@Test
	public void testEvaluatePostfix3() throws DAIndexOutOfBoundsException,
			DANullPointerException, DAIllegalArgumentException,
			DANumberFormatException {
		QueueInterface<String> infix = new DynamicArray<String>();
		infix.add("(");
		infix.add("3");
		infix.add("+");
		infix.add("3");
		infix.add(")");
		infix.add("*");
		infix.add("2");
		infix.add("/");
		infix.add("(");
		infix.add("11");
		infix.add("-");
		infix.add("(");
		infix.add("2");
		infix.add("*");
		infix.add("5");
		infix.add(")");
		infix.add(")");

		QueueInterface<String> postfix = CalculatorUtility
				.infixToPostfix(infix);
		String result = CalculatorUtility.evaluatePostfix(postfix);
		assertEquals("12.0", result);
	}

	/**
	 * Test method for {@link
	 * utilities.CalculatorUtility#evaluatePostfix(QueueInterface<T>)}. Tests
	 * for division by zero.
	 */
	@Test(expected = DANumberFormatException.class)
	public void testEvaluatePostfix4() throws DAIndexOutOfBoundsException,
			DANullPointerException, DAIllegalArgumentException,
			DANumberFormatException {
		QueueInterface<String> infix = new DynamicArray<String>();
		infix.add("3");
		infix.add("+");
		infix.add("3");
		infix.add("*");
		infix.add("2");
		infix.add("/");
		infix.add("0");
		infix.add("-");
		infix.add("2");

		QueueInterface<String> postfix = CalculatorUtility
				.infixToPostfix(infix);
		CalculatorUtility.evaluatePostfix(postfix);
	}

	/**
	 * Test method for {@link
	 * utilities.CalculatorUtility#evaluatePostfix(QueueInterface<T>)}. Tests
	 * for a postfix queue containing illegal number of operands.
	 */
	@Test(expected = DAIndexOutOfBoundsException.class)
	public void testEvaluatePostfix5() throws DAIndexOutOfBoundsException,
			DANullPointerException, DAIllegalArgumentException,
			DANumberFormatException {
		QueueInterface<String> infix = new DynamicArray<String>();
		infix.add("3");
		infix.add("*");
		infix.add("(");
		infix.add("+");
		infix.add("+");
		infix.add("3");
		infix.add(")");

		QueueInterface<String> postfix = CalculatorUtility
				.infixToPostfix(infix);

		CalculatorUtility.evaluatePostfix(postfix);
	}

	/**
	 * Test method for {@link
	 * utilities.CalculatorUtility#evaluatePostfix(QueueInterface<T>)}. Tests
	 * for a postfix queue that is null.
	 */
	@Test(expected = DANullPointerException.class)
	public void testEvaluatePostfix6() throws DAIndexOutOfBoundsException,
			DANullPointerException, DAIllegalArgumentException,
			DANumberFormatException {
		QueueInterface<String> postfix = null;
		CalculatorUtility.evaluatePostfix(postfix);
	}

	/**
	 * Test method for {@link
	 * utilities.CalculatorUtility#evaluatePostfix(QueueInterface<T>)}. Tests
	 * for a postfix queue that is empty.
	 */
	@Test(expected = DAIllegalArgumentException.class)
	public void testEvaluatePostfix7() throws DAIndexOutOfBoundsException,
			DANullPointerException, DAIllegalArgumentException,
			DANumberFormatException {
		QueueInterface<String> postfix = new DynamicArray<String>();
		CalculatorUtility.evaluatePostfix(postfix);
	}

	/**
	 * Test method for {@link
	 * utilities.CalculatorUtility#evaluatePostfix(QueueInterface<T>)}. Tests
	 * for a postfix queue containing only one number.
	 */
	@Test
	public void testEvaluatePostfix8() throws DAIndexOutOfBoundsException,
			DANullPointerException, DAIllegalArgumentException,
			DANumberFormatException {
		QueueInterface<String> postfix = new DynamicArray<String>();
		postfix.add("3");

		String result = CalculatorUtility.evaluatePostfix(postfix);
		assertEquals("3", result);
	}

	/**
	 * Test method for {@link
	 * utilities.CalculatorUtility#evaluatePostfix(QueueInterface<T>)}. Tests
	 * for a postfix queue containing only an operand.
	 */
	@Test(expected = DAIndexOutOfBoundsException.class)
	public void testEvaluatePostfix9() throws DAIndexOutOfBoundsException,
			DANullPointerException, DAIllegalArgumentException,
			DANumberFormatException {
		QueueInterface<String> postfix = new DynamicArray<String>();
		postfix.add("+");

		CalculatorUtility.evaluatePostfix(postfix);
	}
}

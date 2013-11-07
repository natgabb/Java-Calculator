// Natacha Gabbamonte
// 0932340
// CalculatorParser.java

package calculator;

import interfaces.QueueInterface;

import java.util.List;

import utilities.CalculatorUtility;
import arrays.DynamicArray;
import exceptions.DAIllegalArgumentException;
import exceptions.DAIndexOutOfBoundsException;
import exceptions.DANullPointerException;
import exceptions.DANumberFormatException;

/**
 * Defines the Calculator's parser which takes care of getting the result of the
 * operations stored in the Model's list of values.
 * 
 * @author Natacha Gabbamonte - 0932340
 * 
 */
public class CalculatorParser {

	private CalculatorModel model;

	/**
	 * Constructor for the parser.
	 * 
	 * @param model
	 *            The model of the Calculator.
	 */
	public CalculatorParser(CalculatorModel model) {
		this.model = model;
	}

	/**
	 * Processes the Model's list of values/operations and then sends the result
	 * to the Model.
	 */
	public void processInputList() {
		if (model.beforeEvaluationProcessing()) {
			List<String> allValues = model.getAllValues();
			String result;
			boolean hasError = false;
			QueueInterface<String> infix = new DynamicArray<String>();
			try {
				for (String s : allValues)
					infix.add(s);
				result = CalculatorUtility.evaluatePostfix(CalculatorUtility
						.infixToPostfix(infix));
			} catch (DANumberFormatException e) {
				result = "DIVISION BY ZERO";
				hasError = true;
			} catch (DAIllegalArgumentException | DAIndexOutOfBoundsException
					| DANullPointerException e) {
				result = "SYNTAX ERROR";
				hasError = true;
			}
			model.equalsButtonPress(result, hasError);
		}
	}
}

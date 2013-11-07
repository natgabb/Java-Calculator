// Natacha Gabbamonte
// 0932340
// CalculatorModel.java

package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * This defines the Calculator's Model which contains the values that are
 * displayed. It is the Model part of the Model-View-Controller model.
 * 
 * @author Natacha Gabbamonte - 0932340
 * 
 */
public class CalculatorModel extends Observable {

	private List<String> allValues = null;
	private String currentValue = "0";
	private boolean hasPressedNumber = false;
	private boolean hasPressedEquals = false;
	private int numberOfOpeningP = 0;
	private int numberOfClosingP = 0;
	private boolean hasErrorMessage = false;

	/**
	 * Constructor for the Calculator's Model.
	 */
	public CalculatorModel() {
		allValues = new ArrayList<String>();
	}

	/**
	 * Receives a key press and updates the list of values and the current value
	 * accordingly.
	 * 
	 * @param key
	 */
	public void updateValues(String key) {
		if (key == null)
			throw new IllegalArgumentException("The key cannot be null.");
		else if (isNumber(key)) {
			if (allValues.size() > 0
					&& allValues.get(allValues.size() - 1).equals(")"))
				allValues.add("*");
			if (currentValue.equals("0")
					|| (allValues.size() == 0 && hasPressedEquals)) {
				currentValue = key;
				hasPressedEquals = false;
			} else
				currentValue += key;
			hasPressedNumber = true;
			hasErrorMessage = false;
		} else if (isOperator(key)) {
			// If they've pressed a number, or if they press an operator right
			// after pressing equals, then you want to add currentValue to
			// allValues.
			if (!hasErrorMessage) {
				if (hasPressedNumber || !currentValue.equals("0")) {
					addCurrentValueToAllValues();
				}
				if (allValues.size() > 0) {
					if (isOperator(allValues.get(allValues.size() - 1)))
						allValues.remove(allValues.size() - 1);
					if (!allValues.get(allValues.size() - 1).equals("("))
						allValues.add(key);
				}
			}
		} else if (key.equals("(")) {
			if (hasPressedNumber) {
				addCurrentValueToAllValues();
				allValues.add("*");
			} else if (allValues.size() == 0 && hasPressedEquals) {
				currentValue = "0";
				hasPressedNumber = false;
			} else if (allValues.size() > 0) {
				String previous = allValues.get(allValues.size() - 1);
				if (previous.equals(")"))
					allValues.add("*");
			}
			allValues.add(key);
			numberOfOpeningP++;

		} else if (key.equals(")")) {
			if (numberOfOpeningP > numberOfClosingP) {
				if (hasPressedNumber) {
					addCurrentValueToAllValues();
					allValues.add(key);
					numberOfClosingP++;
				} else if (allValues.get(allValues.size() - 1).equals(")")) {
					allValues.add(key);
					numberOfClosingP++;
				}
			}
		} else if (key.equals("+/-")) {
			if (!hasErrorMessage) {
				if (currentValue.indexOf('.') != -1)
					currentValue = "" + (Double.parseDouble(currentValue) * -1);
				else
					currentValue = "" + (Integer.parseInt(currentValue) * -1);
				hasPressedNumber = true;
			}
		} else if (key.equals(".")) {
			if (!hasErrorMessage)
				if (currentValue.indexOf('.') == -1) {
					currentValue += ".";
					hasPressedNumber = true;
				}
		} else if (key.equals("CE")) {
			// CE clears the currentValue if the user has pressed a number, or
			// the last thing that was added to the list of values. If the last
			// item in the list of values (after an item was remove) is a
			// number, it will be moved over to the currentValue.
			if (hasPressedNumber || !currentValue.equals("0")) {
				// Needs to check for NOT equal to zero, even if checking
				// hasPressedNumber, because if they have just pressed =, the
				// currentValue will (possibly) contain something other than a
				// zero, but will have the hasPressedNumber set to false. In
				// this case, we still want this value to be cleared.
				// Clear the current value.
				currentValue = "0";
				hasPressedNumber = false;
				hasErrorMessage = false;
			} else {
				if (allValues.size() > 0) {
					String poppedValue = allValues.remove(allValues.size() - 1);
					if (poppedValue.equals("("))
						numberOfOpeningP--;
					if (poppedValue.equals(")"))
						numberOfClosingP--;
					hasPressedNumber = false;
					if (allValues.size() > 0) {
						String nextValue = allValues.get(allValues.size() - 1);
						if (!nextValue.equals("(") && !nextValue.equals(")")
								&& !isOperator(nextValue)) {
							currentValue = allValues
									.remove(allValues.size() - 1);
							hasPressedNumber = true;
						}
					}

				}
			}

		} else if (key.equals("C")) {
			// Clears all the values.
			currentValue = "0";
			allValues = new ArrayList<String>();
			hasPressedNumber = false;
			numberOfClosingP = 0;
			numberOfOpeningP = 0;
			hasPressedEquals = false;
			hasErrorMessage = false;
		} else {
			// An invalid key was received.
			throw new IllegalArgumentException("The key is invalid: " + key);
		}
		// Notifies it's observers that it has changed.
		setChanged();
		notifyObservers();
	}

	/**
	 * Returns the ArrayList containing all the currently stored values.
	 * 
	 * @return The ArrayList
	 */
	public List<String> getAllValues() {
		List<String> newList = new ArrayList<String>();
		for (String value : allValues)
			newList.add(value);
		return newList;
	}

	/**
	 * Returns the current value String.
	 * 
	 * @return The current value
	 */
	public String getCurrentValue() {
		return currentValue;
	}

	/**
	 * Processes the list of values and the current value before an equals
	 * evaluation.
	 * 
	 * @return Whether or not the the process should continue.
	 */
	public boolean beforeEvaluationProcessing() {
		if(allValues.size() == 0)
			return false;
		if (!hasPressedNumber) {
			String lastValue = allValues.get(allValues.size() - 1);
			if (lastValue.equals("(") || isOperator(lastValue))
				return false;
		} else
			addCurrentValueToAllValues();

		// Adds missing closing parenthesis at the end of the list.
		while (numberOfOpeningP > numberOfClosingP) {
			allValues.add(")");
			numberOfClosingP++;
		}
		return true;
	}

	/**
	 * Receives the result of the equal processing and sets the values
	 * accordingly.
	 * 
	 * @param result
	 *            The result of the operations.
	 */
	public void equalsButtonPress(String result, boolean hasError) {
		allValues.clear();
		numberOfOpeningP = 0;
		numberOfClosingP = 0;
		currentValue = result;
		hasPressedNumber = false;
		hasPressedEquals = true;
		hasErrorMessage = hasError;

		if (currentValue.equals("Infinity"))
			hasErrorMessage = true;

		// Notifies it's observers that it has changed.
		setChanged();
		notifyObservers();
	}

	/*
	 * Adds the currentValue to allValues and resets various variables.
	 */
	private void addCurrentValueToAllValues() {
		allValues.add(currentValue);
		currentValue = "0";
		hasPressedNumber = false;
	}

	/*
	 * Checks if a key is an operator.
	 * 
	 * @param key The key
	 * 
	 * @return Whether it is an operator or not
	 */
	private boolean isOperator(String key) {
		switch (key) {
		case "+":
		case "-":
		case "/":
		case "*":
			return true;
		default:
			return false;
		}
	}

	/*
	 * Checks if a key is a number.
	 * 
	 * @param key The key
	 * 
	 * @return Whether it is a number or not
	 */
	private boolean isNumber(String key) {
		switch (key) {
		case "0":
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
		case "8":
		case "9":
			return true;
		default:
			return false;
		}
	}
}

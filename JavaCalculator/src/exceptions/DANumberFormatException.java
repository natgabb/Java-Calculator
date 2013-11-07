// Natacha Gabbamonte
// 0932340
// DANumberFormatException.java

package exceptions;

/**
 * This defines a checked exception for a number format error.
 * 
 * @author Natacha Gabbamonte 0932340
 * 
 */
public class DANumberFormatException extends Exception {

	private static final long serialVersionUID = 2L;

	/**
	 * Constructor with only an error message.
	 * 
	 * @param message
	 *            The error message
	 */
	public DANumberFormatException(String message) {
		super(message);
	}

	/**
	 * Constructor with only a throwable cause.
	 * 
	 * @param cause
	 *            The throwable cause
	 */
	public DANumberFormatException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor with an error message and a throwable cause.
	 * 
	 * @param message
	 *            The error message
	 * @param cause
	 *            The throwable cause
	 */
	public DANumberFormatException(String message, Throwable cause) {
		super(message, cause);
	}
}

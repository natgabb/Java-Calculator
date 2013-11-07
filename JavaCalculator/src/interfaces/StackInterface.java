// Natacha Gabbamonte
// 0932340
// StackInterface.java

package interfaces;

import exceptions.DAIndexOutOfBoundsException;

/**
 * Defines methods for a Stack.
 * @author 0932340
 */
public interface StackInterface<T> {
	/**
	 * Adds an element to the end (or top) of the stack
	 * @param t The element to add.
	 */
	void push(T t) throws DAIndexOutOfBoundsException;
	
	/**
	 * Pops the last (or top) element in the stack.
	 * @return The popped element.
	 */
	T pop() throws DAIndexOutOfBoundsException;
	
	/**
	 * Returns the last (or top) element in the stack.
	 * @return The last (or top) element in the stack.
	 */
	T peek() throws DAIndexOutOfBoundsException;
	
	/**
	 * Returns the actual size of the dynamic array. 
	 * @return The size
	 */
	int size();
}

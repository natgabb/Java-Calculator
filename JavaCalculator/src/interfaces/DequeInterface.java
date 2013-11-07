// Natacha Gabbamonte
// 0932340
// DequeInterface.java

package interfaces;

import exceptions.DAIndexOutOfBoundsException;

/**
 * Defines methods for a Deque.
 * @author 0932340
 */
public interface DequeInterface<T> {
	
	/**
	 * Adds an element to the beginning of the list.
	 * @param t The element to add.
	 * @throws DAIndexOutOfBoundsException 
	 */
	void addFirst(T t) throws DAIndexOutOfBoundsException;
	
	/**
	 * Adds an element to the end (or top) of the list.
	 * @param t The element to add.
	 * @throws DAIndexOutOfBoundsException 
	 */
	void addLast(T t) throws DAIndexOutOfBoundsException;
	
	/**
	 * Removes the first element in the list.
	 * @return The element that was removed
	 * @throws DAIndexOutOfBoundsException 
	 */
	T removeFirst() throws DAIndexOutOfBoundsException;
	
	/**
	 * Pops the last element in the list.
	 * @return The popped element.
	 * @throws DAIndexOutOfBoundsException 
	 */
	T removeLast() throws DAIndexOutOfBoundsException;
	
	/**
	 * Returns the last element in the list.
	 * @return The last element in the list.
	 * @throws DAIndexOutOfBoundsException 
	 */
	T getLast() throws DAIndexOutOfBoundsException;
	
	
	/**
	 * Returns the first element in the list.
	 * @return The element at the front of the list.
	 * @throws DAIndexOutOfBoundsException 
	 */
	T getFirst() throws DAIndexOutOfBoundsException;
	
	/**
	 * Returns the actual size of the dynamic array. 
	 * @return The size
	 */
	int size();
}

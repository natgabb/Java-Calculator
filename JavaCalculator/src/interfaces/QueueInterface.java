// Natacha Gabbamonte
// 0932340
// QueueInterface.java

package interfaces;

import exceptions.DAIndexOutOfBoundsException;

/**
 * Defines methods for a Queue.
 * @author 0932340
 */
public interface QueueInterface<T> {
	
	/**
	 * Adds an object at the end of the array.
	 * @param t The object to add.
	 */
	void add(T t) throws DAIndexOutOfBoundsException;
	
	/**
	 * Removes the first element in the queue.
	 * @return The element that was removed
	 */
	T remove() throws DAIndexOutOfBoundsException;
	
	/**
	 * Returns the first element in the queue.
	 * @return The element at the front of the queue.
	 */
	T element() throws DAIndexOutOfBoundsException;
	
	/**
	 * Returns the actual size of the dynamic array. 
	 * @return The size
	 */
	int size();
}

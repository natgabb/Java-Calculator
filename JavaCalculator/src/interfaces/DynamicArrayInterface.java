// Natacha Gabbamonte
// 0932340
// DynamicArrayInterface.java

package interfaces;

import exceptions.DAIndexOutOfBoundsException;

/**
 * Defines methods for Dynamic Arrays.
 * @author 0932340
 *
 */
public interface DynamicArrayInterface<T> {

	/**
	 * Gets the object at the specified index.
	 * @param index The index of the object to retrieve.
	 * @return The element
	 * @throws DAIndexOutOfBoundsException when the index is not within the required range.
	 */
	public T get(int index) throws DAIndexOutOfBoundsException;
	
	/**
	 * Sets the object at the specified index to the object sent in.
	 * @param index The index of the object to change.
	 * @param t The new object.
	 * @throws DAIndexOutOfBoundsException when the index is not within the required range.
	 */
	public void set(int index, T t) throws DAIndexOutOfBoundsException;
	
	/**
	 * Inserts an object at the specified index.
	 * @param index The index to insert at.
	 * @param t The object to insert.
	 * @throws DAIndexOutOfBoundsException when the index is not within the required range.
	 */
	public void insertAt(int index, T t) throws DAIndexOutOfBoundsException;
	
	/**
	 * Removes an object at the specified index.
	 * @param index The index to remove at.
	 * @return The deleted element.
	 * @throws DAIndexOutOfBoundsException when the index is not within the required range.
	 */
	public T removeAt(int index) throws DAIndexOutOfBoundsException;
	
	/**
	 * Adds an object at the end of the array.
	 * @param t The object to add.
	 * @throws DAIndexOutOfBoundsException when the index is not within the required range.
	 */
	public void add(T t) throws DAIndexOutOfBoundsException;

	/**
	 * Deletes an object at the end of the array.
	 * @return The element that was removed.
	 * @throws DAIndexOutOfBoundsException if there are no objects to delete.
	 */
	public T delete() throws DAIndexOutOfBoundsException;
	
	/**
	 * Returns the capacity of the dynamic array.
	 * @return the capacity
	 */
	public int getCapacity();
	
	/**
	 * Returns the actual size of the dynamic array.
	 * @return the size
	 */
	public int size();
}

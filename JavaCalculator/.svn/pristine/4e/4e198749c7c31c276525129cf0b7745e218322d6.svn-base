// Natacha Gabbamonte
// 0932340
// DynamicArray.java

package arrays;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import exceptions.DAIndexOutOfBoundsException;

import interfaces.DequeInterface;
import interfaces.DynamicArrayInterface;
import interfaces.QueueInterface;
import interfaces.StackInterface;

/**
 * This class implements the DynamicArrayInterface, DequeInterface,
 * QueueInterface, StackInterface and Iterable and defines a dynamic array that
 * can change length.
 * 
 * @author Natacha Gabbamonte 0932340
 * 
 */
public class DynamicArray<T> implements DynamicArrayInterface<T>,
		DequeInterface<T>, QueueInterface<T>, StackInterface<T>, Iterable<T> {
	private int size = 0;
	private int capacity = 10;
	private Object[] array;

	/**
	 * Creates new DynamicArray object.
	 */
	public DynamicArray() {
		array = new Object[capacity];
	}

	/**
	 * @see {@link arrays.DynamicArrayInterface#get(int)}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) throws DAIndexOutOfBoundsException {
		rangeCheck(index);
		return (T) array[index];
	}

	/**
	 * @see {@link arrays.DynamicArrayInterface#set(int, T)}
	 */
	@Override
	public void set(int index, T t) throws DAIndexOutOfBoundsException {
		rangeCheck(index);
		array[index] = t;
	}

	/**
	 * @see {@link arrays.DynamicArrayInterface#insertAt(int, T)}
	 */
	@Override
	public void insertAt(int index, T t) throws DAIndexOutOfBoundsException {
		if (index != size)
			rangeCheck(index);
		ensureCapacity(size + 1);

		System.arraycopy(array, index, array, index + 1, size - index);
		array[index] = t;

		size++;
	}

	/**
	 * @see {@link arrays.DynamicArrayInterface#removeAt(int)}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T removeAt(int index) throws DAIndexOutOfBoundsException {
		rangeCheck(index);
		T t = (T) array[index];
		System.arraycopy(array, index + 1, array, index, size - index);
		size--;
		pack();
		return t;
	}

	/**
	 * @throws DAIndexOutOfBoundsException
	 *             If the index is out of range.
	 * @see {@link arrays.DynamicArrayInterface#add(T)}
	 */
	@Override
	public void add(T t) throws DAIndexOutOfBoundsException {
		insertAt(size, t);
	}

	/**
	 * @see {@link arrays.DynamicArrayInterface#delete()}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T delete() throws DAIndexOutOfBoundsException {
		if (size == 0)
			throw new DAIndexOutOfBoundsException(
					"The DynamicArray has no objects to delete.");
		T t = (T) array[size - 1];
		size--;
		pack();
		return t;
	}

	/**
	 * @see {@link arrays.DynamicArrayInterface#getCapacity()}
	 */
	@Override
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @see {@link arrays.DynamicArrayInterface#size()}
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Ensures that the array has enough capacity.
	 * 
	 * @param neededCapacity
	 */
	private void ensureCapacity(int neededCapacity) {
		if (neededCapacity >= capacity) {
			capacity = (capacity * 3) / 2 + 1;
			array = Arrays.copyOf(array, capacity);
		}
	}

	/**
	 * Packs the array into the smallest size manageable.
	 */
	private void pack() {
		if (size <= (capacity / 2)) {
			capacity = (size * 3) / 2 + 1;
			array = Arrays.copyOf(array, capacity);
		}
	}

	/**
	 * Checks the index to make sure it is within the range of the size of the
	 * array.
	 * 
	 * @param index
	 *            The index to be compared to the range.
	 * @throws DAIndexOutOfBoundsException
	 *             If the index is not within the allowed range.
	 */
	private void rangeCheck(int index) throws DAIndexOutOfBoundsException {
		if (index < 0 || index >= size)
			throw new DAIndexOutOfBoundsException("There is no object at: "
					+ index);
	}

	/**
	 * @throws DAIndexOutOfBoundsException
	 * @see {@link arrays.DequeInterface#addFirst()}
	 */
	@Override
	public void addFirst(T t) throws DAIndexOutOfBoundsException {
		insertAt(0, t);
	}

	/**
	 * @throws DAIndexOutOfBoundsException
	 * @see {@link arrays.DequeInterface#push(T)}
	 */
	@Override
	public void push(T t) throws DAIndexOutOfBoundsException {
		add(t);
	}

	/**
	 * @throws DAIndexOutOfBoundsException
	 * @see {@link arrays.DequeInterface#remove()}
	 */
	@Override
	public T remove() throws DAIndexOutOfBoundsException {
		return removeAt(0);
	}

	/**
	 * @throws DAIndexOutOfBoundsException
	 * @see {@link arrays.DequeInterface#pop()}
	 */
	@Override
	public T pop() throws DAIndexOutOfBoundsException {
		return delete();
	}

	/**
	 * @throws DAIndexOutOfBoundsException
	 * @see {@link arrays.DequeInterface#peek()}
	 */
	@Override
	public T peek() throws DAIndexOutOfBoundsException {
		return get(size - 1);
	}

	/**
	 * @throws DAIndexOutOfBoundsException
	 * @see {@link arrays.DequeInterface#element()}
	 */
	@Override
	public T element() throws DAIndexOutOfBoundsException {
		return get(0);
	}

	@Override
	public void addLast(T t) throws DAIndexOutOfBoundsException {
		push(t);
	}

	@Override
	public T removeFirst() throws DAIndexOutOfBoundsException {
		return removeAt(0);
	}

	@Override
	public T removeLast() throws DAIndexOutOfBoundsException {
		return delete();
	}

	@Override
	public T getLast() throws DAIndexOutOfBoundsException {
		return peek();
	}

	@Override
	public T getFirst() throws DAIndexOutOfBoundsException {
		return element();
	}

	/**
	 * Returns an instance of the DynamicArrayIterator.
	 */
	@Override
	public Iterator<T> iterator() {
		return new DynamicArrayIterator<T>();
	}

	/*
	 * 
	 * This class implements the Iterator interface for the DynamicArray class.
	 * 
	 * @param <G>
	 */
	private class DynamicArrayIterator<G> implements Iterator<G> {
		// Keeps track of the position.
		private int indexPosition = -1;

		/**
		 * Returns if the iterator has a next element.
		 */
		@Override
		public boolean hasNext() {
			if (indexPosition >= size || size == 0)
				return false;
			else
				return true;
		}

		/**
		 * Returns the next element.
		 * 
		 * @throws NoSuchElementException
		 *             If there is no next element.
		 */
		@SuppressWarnings("unchecked")
		@Override
		public G next() {
			if (hasNext()) {
				try {
					return (G) get(++indexPosition);
				} catch (DAIndexOutOfBoundsException e) {
					throw new IndexOutOfBoundsException(e.getMessage());
				}
			}
			throw new NoSuchElementException("There are no more elements.");
		}

		/**
		 * Removes the next element.
		 * 
		 * @throws IndexOutOfBoundsException
		 *             If there is no element to remove.
		 */
		@Override
		public void remove() {
			try {
				if (indexPosition == -1)
					throw new IndexOutOfBoundsException(
							"next() must be called before remove()");
				removeAt(indexPosition);
				indexPosition--;
			} catch (DAIndexOutOfBoundsException e) {
				throw new IndexOutOfBoundsException(e.getMessage());
			}
		}

		@Override
		public String toString() {
			String s = "";
			for (int i = 0; i < size; i++)
				try {
					s += get(i) + " ";
				} catch (DAIndexOutOfBoundsException e) {
					e.printStackTrace();
				}
			return s;

		}
	}
}

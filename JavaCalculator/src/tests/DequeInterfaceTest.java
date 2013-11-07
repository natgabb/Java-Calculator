// Natacha Gabbamonte
// 0932340
// DequeInterfaceTest.java

package tests;

import static org.junit.Assert.*;
import interfaces.DequeInterface;

import org.junit.Before;
import org.junit.Test;

import exceptions.DAIndexOutOfBoundsException;

import arrays.DynamicArray;

public class DequeInterfaceTest {
	
	private static DequeInterface<String> deque;

	/**
	 * Sets up the deque.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		deque = new DynamicArray<String>();
	}

	/**
	 * Test method for {@link arrays.DynamicArray#addFirst(T)}.
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Test
	public void testAddFirst() throws DAIndexOutOfBoundsException {
		deque.addFirst("2");
		deque.addFirst("1");
		
		assertEquals("2", deque.getLast());
		assertEquals("1", deque.getFirst());
	}

	/**
	 * Test method for {@link arrays.DynamicArray#addLast(T)}.
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Test
	public void testAddLast() throws DAIndexOutOfBoundsException {
		deque.addLast("1");
		deque.addLast("2");
		
		assertEquals("2", deque.getLast());
		assertEquals("1", deque.getFirst());
	}

	/**
	 * Test method for {@link arrays.DynamicArray#removeFirst()}.
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Test
	public void testRemoveFirst() throws DAIndexOutOfBoundsException {
		deque.addLast("1");
		deque.addLast("2");
		deque.removeFirst();
		assertEquals(1, deque.size());
		assertEquals("2", deque.getFirst());
	}

	/**
	 * Test method for {@link arrays.DynamicArray#removeFirst()}.
	 * Specifically tests for remove when the deque is empty.
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Test(expected=DAIndexOutOfBoundsException.class)
	public void testRemoveFirst2() throws DAIndexOutOfBoundsException {
		deque.addLast("1");
		deque.removeFirst();
		deque.removeFirst();
	}

	/**
	 * Test method for {@link arrays.DynamicArray#removeLast()}.
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Test
	public void testRemoveLast() throws DAIndexOutOfBoundsException {
		deque.addLast("1");
		deque.addLast("2");
		deque.removeLast();
		assertEquals(1, deque.size());
		assertEquals("1", deque.getLast());
	}

	/**
	 * Test method for {@link arrays.DynamicArray#removeLast()}.
	 * Specifically tests for remove when the deque is empty.
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Test(expected=DAIndexOutOfBoundsException.class)
	public void testRemoveLast2() throws DAIndexOutOfBoundsException {
		deque.addLast("1");
		deque.addLast("2");
		deque.removeLast();
		deque.removeLast();
		deque.removeLast();
	}

	/**
	 * Test method for {@link arrays.DynamicArray#getLast()}.
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Test
	public void testGetLast() throws DAIndexOutOfBoundsException {
		deque.addFirst("1");
		deque.addLast("2");
		assertEquals("2", deque.getLast());
	}

	/**
	 * Test method for {@link arrays.DynamicArray#getLast()}.
	 * Tests for getting the last element when there are no elements.
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Test(expected=DAIndexOutOfBoundsException.class)
	public void testGetLast2() throws DAIndexOutOfBoundsException {
		deque.getLast();
	}

	/**
	 * Test method for {@link arrays.DynamicArray#getFirst()}.
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Test
	public void testGetFirst() throws DAIndexOutOfBoundsException {
		deque.addFirst("1");
		deque.addLast("2");
		assertEquals("1", deque.getFirst());
	}

	/**
	 * Test method for {@link arrays.DynamicArray#getFirst()}.
	 * Tests for getting the first element when there are no elements.
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Test(expected=DAIndexOutOfBoundsException.class)
	public void testGetFirst2() throws DAIndexOutOfBoundsException {
		deque.getFirst();
	}

}

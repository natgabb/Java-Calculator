// Natacha Gabbamonte
// 0932340
// QueueInterfaceTest.java

package tests;

import static org.junit.Assert.*;
import interfaces.QueueInterface;

import org.junit.Before;
import org.junit.Test;

import exceptions.DAIndexOutOfBoundsException;

import arrays.DynamicArray;

public class QueueInterfaceTest {

	private static QueueInterface<String> queue;
	
	/**
	 * Sets up the queue.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		queue = new DynamicArray<String>();
	}

	/**
	 * Test method for {@link arrays.DynamicArray#add(T)}.
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Test
	public void testAdd() throws DAIndexOutOfBoundsException {
		queue.add("1");
		queue.add("2");
		assertEquals(2,queue.size());
	}

	/**
	 * Test method for {@link arrays.DynamicArray#remove()}.
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Test
	public void testRemove() throws DAIndexOutOfBoundsException {
		queue.add("1");
		queue.add("2");
		String element = queue.remove();
		assertEquals("1",element);
		element = queue.remove();
		assertEquals("2",element);
	}
	
	/**
	 * Test method for {@link arrays.DynamicArray#remove()}.
	 * Specifically tests trying to remove from an already empty queue.
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Test(expected=DAIndexOutOfBoundsException.class)
	public void testRemove2() throws DAIndexOutOfBoundsException {
		queue.remove();
	}
	
	/**
	 * Test method for {@link arrays.DynamicArray#element()}.
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Test
	public void testElement() throws DAIndexOutOfBoundsException {
		queue.add("1");
		queue.add("2");
		String element = queue.element();
		assertEquals("1",element);	
		// element() doesn't remove anything, so it should
		// return the same thing again.
		element = queue.element();
		assertEquals("1",element);		
	}

}

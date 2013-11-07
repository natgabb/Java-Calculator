// Natacha Gabbamonte
// 0932340
// StackInterfaceTest.java

package tests;

import static org.junit.Assert.*;
import interfaces.StackInterface;

import org.junit.Before;
import org.junit.Test;

import exceptions.DAIndexOutOfBoundsException;

import arrays.DynamicArray;

public class StackInterfaceTest {

	private static StackInterface<String> stack;
	
	/**
	 * Sets up the stack.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		stack = new DynamicArray<String>();
	}

	/**
	 * Test method for {@link arrays.DynamicArray#push(T)}.
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Test
	public void testPush() throws DAIndexOutOfBoundsException {
		stack.push("1");
		stack.push("2");
		assertEquals(2, stack.size());
	}
	
	/**
	 * Test method for {@link arrays.DynamicArray#pop()}.
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Test
	public void testPop() throws DAIndexOutOfBoundsException{
		stack.push("1");
		stack.push("2");
		String element = stack.pop();
		assertEquals("2", element);
		element = stack.pop();
		assertEquals("1", element);
		
	}
	
	/**
	 * Test method for {@link arrays.DynamicArray#pop()}.
	 * Tests for trying to pop when there is nothing in the Stack.
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Test(expected=DAIndexOutOfBoundsException.class)
	public void testPop2() throws DAIndexOutOfBoundsException{
		stack.pop();		
	}
	
	/**
	 * Test method for {@link arrays.DynamicArray#peek()}.
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Test
	public void testPeek() throws DAIndexOutOfBoundsException {
		stack.push("1");
		stack.push("2");
		String element = stack.peek();
		assertEquals("2",element);	
		// peek() doesn't remove anything, so it should
		// return the same thing again.
		element = stack.peek();
		assertEquals("2",element);		
	}

}

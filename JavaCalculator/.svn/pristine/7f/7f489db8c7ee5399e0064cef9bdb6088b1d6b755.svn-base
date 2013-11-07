// Natacha Gabbamonte
// 0932340
// DynamicArrayIteratorTest.java

package tests;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import exceptions.DAIndexOutOfBoundsException;

import arrays.DynamicArray;

public class DynamicArrayIteratorTest {

	private static DynamicArray<String> array;
	private static Iterator<String> iterator;
	
	/**
	 * Sets up the iterator.
	 * @throws Exception
	 */
	@Before
	public void setUpBefore() throws Exception {
		array = new DynamicArray<String>();
		iterator = array.iterator();
	}

	/**
	 * Test method for {@link arrays.DynamicArray.DynamicArrayIterator#hasNext()}.
	 * @throws DAIndexOutOfBoundsException
	 */
	@Test
	public void testHasNext() throws DAIndexOutOfBoundsException {
		array.add("1");
		array.add("2");
		assertTrue(iterator.hasNext());
	}
	
	/**
	 * Test method for {@link arrays.DynamicArray.DynamicArrayIterator#hasNext()}.
	 */	
	@Test
	public void testHasNext2() {
		assertFalse(iterator.hasNext());
	}

	/**
	 * Test method for {@link arrays.DynamicArray.DynamicArrayIterator#next()}.
	 * @throws DAIndexOutOfBoundsException
	 */
	@Test
	public void testNext() throws DAIndexOutOfBoundsException {
		array.add("1");
		array.add("2");
		assertEquals("1",iterator.next());
		assertEquals("2",iterator.next());	
	}
	
	/**
	 * Test method for {@link arrays.DynamicArray.DynamicArrayIterator#next()}.
	 * @throws NoSuchElementException
	 */
	@Test(expected=NoSuchElementException.class)
	public void testNext2() {
		iterator.next();
	}
	
	/**
	 * Test method for {@link arrays.DynamicArray.DynamicArrayIterator#remove()}.
	 * @throws DAIndexOutOfBoundsException
	 */
	@Test
	public void testRemove() throws DAIndexOutOfBoundsException {
		array.add("1");
		array.add("2");
		iterator.next();
		iterator.remove();
		assertEquals(1,array.size());
		assertEquals("2",array.get(0));
		iterator.next();
		iterator.remove();
		assertEquals(0,array.size());	
	}
	
	/**
	 * Test method for {@link arrays.DynamicArray.DynamicArrayIterator#remove()}.
	 * @throws DAIndexOutOfBoundsException
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public void testRemove2() throws DAIndexOutOfBoundsException {
		array.add("1");
		array.add("2");
		iterator.remove();
	}
	
	/**
	 * Test method for {@link arrays.DynamicArray.DynamicArrayIterator#remove()}.
	 *@throws IndexOutOfBoundsException
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public void testRemove3() {
		iterator.remove();
	}

}

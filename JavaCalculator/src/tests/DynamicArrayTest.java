// Natacha Gabbamonte
// 0932340
// DynamicArrayTest.java

package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.DAIndexOutOfBoundsException;

import arrays.DynamicArray;

public class DynamicArrayTest {

	DynamicArray<String> array = new DynamicArray<String>();
	
	
	/**
	 * Test method for {@link arrays.DynamicArray#add(Object)}.
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Test
	public void testAdd1() throws DAIndexOutOfBoundsException {
		array.add("A");
		assertEquals(1,array.size());
	}
	
	/**
	 * Test method for {@link arrays.DynamicArray#add(Object)}.
	 * 
	 * This specifically tests to make sure the array is expanded if it 
	 * runs out of space.
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Test
	public void testAdd2() throws DAIndexOutOfBoundsException {
		assertTrue(array.getCapacity() == 10);
		array.add("1");
		array.add("2");
		array.add("3");
		array.add("4");
		array.add("5");
		array.add("6");
		array.add("7");
		array.add("8");
		array.add("9");
		array.add("10");
		array.add("11");
		array.add("12");
		array.add("13");
		array.add("14");
		array.add("15");
		assertTrue(array.getCapacity() > 10);		
		assertEquals(15,array.size());
		
		for(int i = 0; i < 15; i++)
			assertEquals("" + (i + 1),array.get(i));			
	}
	/**
	 * Test method for {@link arrays.DynamicArray#delete()}.
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Test
	public void testDelete1() throws DAIndexOutOfBoundsException {
		array.add("A");
		array.delete();
		assertEquals(0,array.size());
	}
	
	/**
	 * Test method for {@link arrays.DynamicArray#delete()}.
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Test(expected = DAIndexOutOfBoundsException.class)
	public void testDelete2() throws DAIndexOutOfBoundsException {
		array.delete();
	}	
	/**
	 * Test method for {@link arrays.DynamicArray#get(int)}.
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Test
	public void testGet() throws DAIndexOutOfBoundsException {
		array.add("A");
		array.add("B");
		array.add("C");
		assertEquals("C",array.get(2));
	}

	/**
	 * Test method for {@link arrays.DynamicArray#set(int, Object)}.
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Test
	public void testSet() throws DAIndexOutOfBoundsException {
		array.add("A");
		array.add("B");
		array.add("D");
		array.set(2,"E");
		assertEquals("E",array.get(2));
	}

	/**
	 * Test method for {@link arrays.DynamicArray#insertAt(int, Object)}.
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Test
	public void testInsertAt1() throws DAIndexOutOfBoundsException {
		array.add("1");
		array.add("2");
		array.add("4");
		array.insertAt(2, "3");
		for(int i = 0; i < 4; i++)
			assertEquals("" + (i + 1),array.get(i));
	}
	
	/**
	 * Test method for {@link arrays.DynamicArray#insertAt(int, Object)}.
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Test
	public void testInsertAt2() throws DAIndexOutOfBoundsException {
		array.add("A");
		array.insertAt(1, "B");
		assertEquals("B",array.get(1));
	}
	/**
	 * Test method for {@link arrays.DynamicArray#removeAt(int)}.
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Test
	public void testRemoveAt1() throws DAIndexOutOfBoundsException {
		array.add("A");
		array.removeAt(0);
		assertEquals(0, array.size());		
	}
	
	/**
	 * Test method for {@link arrays.DynamicArray#removeAt(int)}.
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Test(expected=DAIndexOutOfBoundsException.class)
	public void testRemoveAt2() throws DAIndexOutOfBoundsException {
		array.removeAt(0);	
	}

	/**
	 * Test method for {@link arrays.DynamicArray#getCapacity()}.
	 */
	@Test
	public void testGetCapacity() {
		assertEquals(10,array.getCapacity());
	}

	/**
	 * Test method for {@link arrays.DynamicArray#size()}.
	 * @throws DAIndexOutOfBoundsException 
	 */
	@Test
	public void testGetSize() throws DAIndexOutOfBoundsException {
		array.add("hello");
		assertEquals(1,array.size());
	}

}

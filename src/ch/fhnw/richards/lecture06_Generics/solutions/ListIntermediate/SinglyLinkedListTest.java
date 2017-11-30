package ch.fhnw.richards.lecture06_Generics.solutions.ListIntermediate;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class SinglyLinkedListTest {
	private SinglyLinkedList<String> myList;

	/**
	 * This method is run before each individual test-method. In this case, we
	 * reset the test-list to a new, empty list each time
	 */
	@Before
	public void setUp() throws Exception {
		myList = new SinglyLinkedList<>();
	}

	@Test(expected = ListException.class)
	public void testIllegalAddUpperBound() throws ListException {
		// when
		myList.add(1, "one");
	}

	@Test(expected = ListException.class)
	public void testIllegalAddLowerBound() throws ListException {
		// when
		myList.add(-1, "one");
	}

	@Test
	public void testAddFirst() throws Exception {
		// given
		final String first = "first";
		myList.add(0, first);
		final String second = "second";

		// when
		myList.add(0, second);

		// then
		assertEquals(second, myList.get(0));
		assertEquals(first, myList.get(1));
	}

	@Test
	public void testAddLast() throws Exception {
		// given
		final String first = "first";
		myList.add(0, first);

		final String second = "second";

		// when
		myList.add(1, second);

		// then
		assertEquals(first, myList.get(0));
		assertEquals(second, myList.get(1));
	}

	@Test
	public void testAddNull() throws Exception {
		// when
		myList.add(0, null);

		// then
		assertNull(myList.get(0));
		assertEquals(1, myList.size());
	}

	@Test
	public void testAddAtPos() throws Exception {
		// given

		final String first = "first";
		final String second = "second";

		// when
		myList.add(0, first);
		myList.add(1, second);

		final String newSecond = "newSecond";
		myList.add(1, newSecond);

		// then
		assertEquals(first, myList.get(0));
		assertEquals(newSecond, myList.get(1));
		assertEquals(second, myList.get(2));
	}

	@Test(expected = ListException.class)
	public void testIllegalRemoveUpperBound() throws Exception {
		myList.remove(0);
	}

	@Test(expected = ListException.class)
	public void testIllegalRemoveLowerBound() throws Exception {
		myList.remove(-1);
	}

	@Test
	public void testRemove() throws Exception {
		myList.add(0, "one");
		final String two = "two";
		myList.add(1, two);
		myList.remove(0);
		assertEquals(1, myList.size());
		assertSame(two, myList.get(0));
		myList.remove(0);
		assertTrue(myList.isEmpty());
	}

	@Test(expected = ListException.class)
	public void testIllegalGetUpperBound() throws Exception {
		myList.get(0);
	}

	@Test(expected = ListException.class)
	public void testIllegalGetLowerBound() throws Exception {
		myList.get(-1);
	}

	@Test
	public void testIsEmpty() throws Exception {
		assertTrue(myList.isEmpty());
		myList.add(0, "value");
		assertFalse(myList.isEmpty());
		myList.remove(0);
		assertTrue(myList.isEmpty());
	}

	@Test
	public void testContains() throws Exception {
		final String value = "value";
		assertFalse(myList.contains(value));
		myList.add(0, "otherValue");
		assertFalse(myList.contains(value));
		myList.add(0, value);
		assertTrue(myList.contains(value));
		assertFalse(myList.contains(null));
		myList.add(0, null);
		assertTrue(myList.contains(null));
	}

	@Test
	public void testSize() throws Exception {
		assertEquals(0, myList.size());
		myList.add(0, "value");
		assertEquals(1, myList.size());
		myList.remove(0);
		assertEquals(0, myList.size());
	}

	@Test
	public void testIterator() throws Exception {
		String[] values = new String[] { "four", "three", "two", "one" };
		for (String value : values) {
			myList.add(0, value);
		}

		int i = 0;
		for (String listValue : myList) {
			assertEquals(values[values.length - 1 - i], listValue);
			i++;
		}
	}

	@Test
	public void testIteratorRemove() throws Exception {
		String[] values = new String[] { "four", "three", "two", "one" };
		for (String value : values) {
			myList.add(0, value);
		}
		Iterator<String> it = myList.iterator();
		while (it.hasNext()) {
			if (!it.next().equals("two")) {
				it.remove();
			}
		}
		assertEquals(1, myList.size());
		assertEquals("two", myList.get(0));
	}

	@Test
	public void testIteratorRemoveSingleValue() throws Exception {
		String[] values = new String[] { "four", "three", "two", "one" };
		for (String value : values) {
			myList.add(0, value);
		}

		// remove first element
		Iterator<String> it = myList.iterator();
		while (it.hasNext()) {
			if (it.next().equals("one")) {
				it.remove();
			}
		}
		assertEquals(3, myList.size());
		assertEquals("two", myList.get(0));

		// remove something in the middle
		it = myList.iterator();
		while (it.hasNext()) {
			if (it.next().equals("three")) {
				it.remove();
			}
		}
		assertEquals(2, myList.size());
		assertFalse(myList.contains("three"));

		// remove last element
		it = myList.iterator();
		while (it.hasNext()) {
			if (it.next().equals("four")) {
				it.remove();
			}
		}
		assertEquals(1, myList.size());
		assertFalse(myList.contains("four"));
		assertEquals("two", myList.get(0));
	}

	@Test(expected = IllegalStateException.class)
	public void testIllegalIteratorRemove() {
		final Iterator<String> iterator = myList.iterator();
		iterator.remove();
	}

	@Test(expected = IllegalStateException.class)
	public void testCallIteratorRemoveTwice() throws Exception {
		myList.add(0, "value");
		final Iterator<String> it = myList.iterator();
		it.next();
		it.remove();
		it.remove();
	}

	@Test
	public void testToList() throws Exception {
		String[] array = new String[] { "one", "two", "three" };
		final SinglyLinkedList<String> list = SinglyLinkedList.toList(array);
		assertEquals(array.length, list.size());
		for (String element : array) {
			assertTrue(list.contains(element));
		}
	}

	@Test
	public void testToArray() throws Exception {
		myList.add(0, "one");
		myList.add(1, "two");
		myList.add(2, "three");
		String[] array = new String[myList.size()];
		SinglyLinkedList.toArray(myList, array);
		assertEquals(array.length, myList.size());
		for (String element : array) {
			assertTrue(myList.contains(element));
		}
	}

}

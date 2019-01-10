package ch.fhnw.richards.lecture06_Collections.exercises;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.fhnw.richards.lecture06_Collections.Person;

/**
 * This class is not complete. It should test all
 * important aspects of the Family class
 */
public class FamilyTest {

	@Test
	public void testInitialSize() {
		Family family = new Family(2); // Setup
		int size = family.size(); // Actual result
		assertEquals(0, size); // Expected result
	}

	@Test
	public void testSize() {
		Family family = new Family(2); // Setup
		Person person = new Person("Fred", 1.81, 80);
		family.add(person);
		int size = family.size(); // Actual result
		assertEquals(1, size); // Expected result
	}

	@Test
	public void testAdd() {
		Family family = new Family(2); // Setup
		Person person = new Person("Fred", 1.81, 80);
		family.add(person);
		assertTrue(family.isMember(person)); // Expected result
		assertFalse(family.isMember(new Person("Ann", 1.6, 55)));
	}

	// And lots more possible tests...
}

package ch.fhnw.richards.lecture05_Collections.solutions.array;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.fhnw.richards.lecture05_Collections.Person;
import ch.fhnw.richards.lecture05_Collections.exercises.Family;

public class FamilyTest {
	private Person fred = new Person("Fred", 1.81, 80);
	private Person ann = new Person("Ann", 1.6, 55);
	private Person john = new Person("John", 1.9, 95);

	@Test
	public void testInitialSize() {
		Family family = new Family(2); // Setup
		int size = family.size(); // Actual result
		assertEquals(0, size); // Expected result
	}

	@Test
	public void testSize() {
		Family family = new Family(2); // Setup
		family.add(fred);
		int size = family.size(); // Actual result
		assertEquals(1, size); // Expected result
	}

	@Test
	public void testAdd() {
		Family family = new Family(2); // Setup
		family.add(fred);
		assertTrue(family.isMember(fred)); // Expected result
		assertFalse(family.isMember(ann));
	}

	@Test
	public void testTallest() {
		Family family = new Family(5);
		
		family.add(fred);
		Person p = family.getTallest();
		assertEquals(p, fred);
		
		family.add(ann);
		p = family.getTallest();
		assertEquals(p, fred);
		
		family.add(john);
		p = family.getTallest();
		assertEquals(p, john);
	}
}

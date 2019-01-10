package ch.fhnw.richards.lecture06_Collections.solutions.hashmap;

import static org.junit.Assert.*;

import org.junit.Test;

public class FamilyTest {
	private Person fred = new Person("Fred", 1.81, 80);
	private Person fred2 = new Person(fred.getID(), "Fred2", 1.81, 80);
	private Person ann = new Person("Ann", 1.6, 55);
	private Person john = new Person("John", 1.9, 95);
	
	@Test
	public void testInitialSize() {
		Family family = new Family();
		int size = family.size();
		assertEquals(0, size);
	}

	@Test
	public void testSize() {
		Family family = new Family();
		family.add(fred);
		assertEquals(1, family.size());
		
		family.add(fred2); // Should not be added !!
		assertEquals(1, family.size()); // Still size 1
	}

	@Test
	public void testAdd() {
		Family family = new Family();
		family.add(fred);
		assertTrue(family.isMember(fred));
		assertFalse(family.isMember(ann));
	}

	@Test
	public void testTallest() {
		Family family = new Family();
		
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

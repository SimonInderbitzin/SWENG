package ch.fhnw.richards.lecture06_Collections;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {

	@Test
	public void testBMI() {
		// Set up data
		Person p = new Person("Fred", 1.81, 80);
		
		// Get actual result
		double bmi = p.getBMI();
		
		// Compare to expected result
		assertEquals(24.42, bmi, 0.01);
	}

}

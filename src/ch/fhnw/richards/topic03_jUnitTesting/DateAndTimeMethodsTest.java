/**
 * 
 */
package ch.fhnw.richards.topic03_jUnitTesting;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author brad
 *
 */
class DateAndTimeMethodsTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetAgeBasic() {
		LocalDate onDate = LocalDate.of(2015, 6, 15);
        assertEquals(DateAndTimeMethods.getAge(LocalDate.of(2010, 3, 3), onDate), 5);
        assertEquals(DateAndTimeMethods.getAge(LocalDate.of(2010, 8, 8), onDate), 4);
        assertEquals(DateAndTimeMethods.getAge(LocalDate.of(2010, 6, 3), onDate), 5);
        assertEquals(DateAndTimeMethods.getAge(LocalDate.of(2010, 6, 23), onDate), 4);
	}
	
    @Test
    public void testGetAgeNegative() {
        LocalDate onDate = LocalDate.of(2015, 6, 15);
        LocalDate birthDate = LocalDate.of(2020, 7, 23);
        try {
            DateAndTimeMethods.getAge2(birthDate, onDate);
            fail(); // Test failure
        } catch (Exception e) {
            assertTrue(true); // Test success
        }
    }

}

package ch.fhnw.richards.topic03_jUnitTesting;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class DateAndTimeMethodsTest3 {
	private static class TestCase {
		LocalDate birthDate; LocalDate onDate; int age;
		public TestCase(LocalDate birthDate, LocalDate onDate, int age) {
			this.birthDate = birthDate;
			this.onDate = onDate;
			this.age = age;
		}
	}
	
	private static ArrayList<TestCase> testData;
	
	private static int[][] testDataRaw = {
	    // Basic tests
	    { 2010, 3, 3, 2015, 6, 15, 5 },
	    { 2010, 8, 8, 2015, 6, 15, 4 },
	    { 2010, 6, 3, 2015, 6, 15, 5 },
	    { 2010, 6, 23, 2015, 6, 15, 4 },
	        
	    // Boundary tests
	    { 2010, 5, 23, 2015, 6, 15, 5 },
	    { 2010, 7, 1, 2015, 6, 15, 4 },
	    { 2010, 6, 15, 2015, 6, 15, 5 },
	    { 2010, 6, 16, 2015, 6, 15, 4 },
	    { 2015, 6, 15, 2015, 6, 15, 0 },
	       
	    // Error cases: -1 indicates
	    // that these are errors
	    { 2015, 6, 16, 2015, 6, 15, -1 },
	    { 2020, 7, 23, 2015, 6, 15, -1 }
	  };
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		testData = new ArrayList<>();
		for (int[] t : testDataRaw) {
			TestCase testCase = new TestCase(LocalDate.of(t[0], t[1], t[2]), LocalDate.of(t[3], t[4], t[5]), t[6]);
			testData.add(testCase);
		}
	}

	@ParameterizedTest
	@MethodSource("testCaseSource")
	void test(TestCase t) {
		try {
			int result = DateAndTimeMethods.getAge2(t.birthDate, t.onDate);
			assertEquals(result, t.age);
		} catch (Exception e) {
			assertEquals(t.age, -1); // Exception expected
		}
	}

	static Stream<TestCase> testCaseSource() {
		return testData.stream();
	}
}

package ch.fhnw.richards.topic03_jUnitTesting;

import java.time.LocalDate;

public class DateAndTimeMethods {
	public static int getAge(LocalDate birthDate, LocalDate onDate) {
		int onYear = onDate.getYear();
		int onMonth = onDate.getMonthValue();
		int onDay = onDate.getDayOfMonth();

		int birthYear = birthDate.getYear();
		int birthMonth = birthDate.getMonthValue();
		int birthDay = birthDate.getDayOfMonth();

		int age = onYear - birthYear;

		if (onMonth < birthMonth) {
			age--;
		} else if (onMonth == birthMonth) {
			if (onDay < birthDay) {
				age--;
			}
		}
		return age;
	}
	
	public static int getAge2(LocalDate birthDate, LocalDate onDate) throws Exception {
		int onYear = onDate.getYear();
		int onMonth = onDate.getMonthValue();
		int onDay = onDate.getDayOfMonth();

		int birthYear = birthDate.getYear();
		int birthMonth = birthDate.getMonthValue();
		int birthDay = birthDate.getDayOfMonth();

		int age = onYear - birthYear;

		if (onMonth < birthMonth) {
			age--;
		} else if (onMonth == birthMonth) {
			if (onDay < birthDay) {
				age--;
			}
		}
		if (age < 0) throw new Exception("Not born!");
		return age;
	}
	
}

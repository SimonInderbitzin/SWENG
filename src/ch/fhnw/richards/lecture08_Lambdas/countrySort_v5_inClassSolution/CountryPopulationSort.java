package ch.fhnw.richards.lecture08_Lambdas.countrySort_v5_inClassSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountryPopulationSort {
	static List<Country> countries = new ArrayList<>(Arrays.asList(
			new Country("Switzerland", 41285, 8526932),
			new Country("Germany", 357021, 82887000),
			new Country("France", 675417, 67372000),
			new Country("Austria", 83858, 8857960)));

	public static void main(String[] args) {
		countries.sort( (c1, c2) -> Integer.compare(c1.getPopulation(), c2.getPopulation()));
		
		for (Country c : countries) System.out.println(c);
	}

}

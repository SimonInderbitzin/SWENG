package ch.fhnw.richards.topic07_Lambdas.countrySort_v1;

import java.util.Comparator;

import ch.fhnw.richards.topic07_Lambdas.Country;

/**
 * @author Dieter Holz
 */
public class CountryByAreaComparator implements Comparator<Country> {
	@Override
	public int compare(Country o1, Country o2) {
		return (int) (o1.getArea() - o2.getArea());
		//return Double.compare(o1.getArea(), o2.getArea());
	}
}

package ch.fhnw.richards.lecture05_Collections.solutions.treeset;

import java.util.Collection;
import java.util.TreeSet;

public class Family {
	private TreeSet<Person> members;
	
	public Family() {
		members = new TreeSet<>();
	}
	
	public int size() {
		return members.size();
	}
	
	public void add(Person p) {
		members.add(p);
	}
	
	public Person getTallest() {
		Person tallest = null;
		for (Person p : members) {
			if (tallest == null || p != null && tallest.getHeight() < p.getHeight()) {
				tallest = p;
			}
		}
		return tallest;
	}
	
	public boolean isMember(Person p) {
		for (Person m : members) {
			if (m.equals(p)) {
				return true;
			}
		}
		return false;
	}
	
	public Collection<Person> getAllMembers() {
		return members;
	}
}

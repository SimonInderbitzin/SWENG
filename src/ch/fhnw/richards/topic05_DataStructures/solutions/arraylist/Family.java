package ch.fhnw.richards.topic05_DataStructures.solutions.arraylist;

import java.util.ArrayList;
import java.util.Collection;

import ch.fhnw.richards.topic05_DataStructures.solutions.Person;

public class Family {
	private ArrayList<Person> members;
	
	public Family() {
		members = new ArrayList<>();
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
		boolean isMember = false;
		for (int i = 0; i < members.size() & !isMember; i++) {
			if (members.get(i).equals(p)) {
				isMember = true;
			}
		}
		return isMember;
	}
	
	public Collection<Person> getAllMembers() {
		return members;
	}
}

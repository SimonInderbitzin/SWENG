package ch.fhnw.richards.lecture05_Collections.solutions.hashmap;

import java.util.Collection;
import java.util.HashMap;

public class Family {
	private HashMap<Integer, Person> members;
	
	public Family() {
		members = new HashMap<>();
	}
	
	public int size() {
		return members.size();
	}
	
	public void add(Person p) {
		members.put(p.getID(), p);
	}
	
	public Person getTallest() {
		Person tallest = null;
		for (Integer id : members.keySet()) {
			Person p = members.get(id);
			if (tallest == null || p != null && tallest.getHeight() < p.getHeight()) {
				tallest = p;
			}
		}
		return tallest;
	}
	
	public boolean isMember(Person p) {
		for (Integer id : members.keySet()) {
			if (id.equals(p.getID())) {
				return true;
			}
		}
		return false;
	}
}

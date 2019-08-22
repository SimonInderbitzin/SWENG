package ch.fhnw.richards.topic05_DataStructures.solutions.hashmap;

import java.util.HashMap;
import ch.fhnw.richards.topic05_DataStructures.solutions.Person;

public class Family {
	private HashMap<String, Person> members;
	
	public Family() {
		members = new HashMap<>();
	}
	
	public int size() {
		return members.size();
	}
	
	public void add(Person p) {
		members.put(p.getName(), p);
	}
	
	public Person getTallest() {
		Person tallest = null;
		for (String id : members.keySet()) {
			Person p = members.get(id);
			if (tallest == null || p != null && tallest.getHeight() < p.getHeight()) {
				tallest = p;
			}
		}
		return tallest;
	}
	
	public boolean isMember(Person p) {
		for (String id : members.keySet()) {
			if (id.equals(p.getName())) {
				return true;
			}
		}
		return false;
	}
	
	public HashMap<String, Person> getAllMembers() {
		return members;
	}
}

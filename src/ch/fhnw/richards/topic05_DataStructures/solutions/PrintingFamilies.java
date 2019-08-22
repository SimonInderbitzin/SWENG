package ch.fhnw.richards.topic05_DataStructures.solutions;

import java.util.HashMap;

public class PrintingFamilies {
	private static Person fred = new Person("Fred", 1.81, 80);
	private static Person ann = new Person("Ann", 1.6, 55);
	private static Person john = new Person("John", 1.9, 95);

	public static void main(String[] args) {
		ch.fhnw.richards.topic05_DataStructures.solutions.arraylist.Family arrayListFamily = new ch.fhnw.richards.topic05_DataStructures.solutions.arraylist.Family();
		ch.fhnw.richards.topic05_DataStructures.solutions.hashmap.Family hashmapFamily = new ch.fhnw.richards.topic05_DataStructures.solutions.hashmap.Family();
		ch.fhnw.richards.topic05_DataStructures.solutions.treeset.Family treesetFamily = new ch.fhnw.richards.topic05_DataStructures.solutions.treeset.Family();
		
		arrayListFamily.add(fred); arrayListFamily.add(ann); arrayListFamily.add(john);
		hashmapFamily.add(fred); hashmapFamily.add(ann); hashmapFamily.add(john);
		treesetFamily.add(fred); treesetFamily.add(ann); treesetFamily.add(john);
		
		System.out.println("--- ArrayList ---");
		for (Person p : arrayListFamily.getAllMembers()) System.out.print(p + " ");
		
		System.out.println("\n");
		
		System.out.println("--- HashMap ---");
		HashMap<String, Person> hmMembers = hashmapFamily.getAllMembers(); 
		for (String key : hmMembers.keySet()) System.out.print(hmMembers.get(key) + " ");
		
		System.out.println("\n");
		
		System.out.println("--- TreeSet ---");
		for (Person p : treesetFamily.getAllMembers()) System.out.print(p + " ");
	}

}

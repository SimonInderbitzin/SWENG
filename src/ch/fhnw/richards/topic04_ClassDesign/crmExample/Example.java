package ch.fhnw.richards.topic04_ClassDesign.crmExample;

import java.util.ArrayList;

public class Example {
	public static void main(String[] args) {
		
		ArrayList<GeneralContact> allContacts = new ArrayList<>();
		
		GeneralContact g = new GeneralContact();
		g.setName("Ann");
		allContacts.add(g);
		
		Customer c = new Customer();
		c.setName("Bob");
		allContacts.add(c);
		
		g = new GeneralContact();
		g.setName("Carol");
		allContacts.add(g);
		
		c = new Customer();
		c.setName("David");
		allContacts.add(c);
		
		g = new GeneralContact();
		g.setName("Ernie");
		allContacts.add(g);

		// Send a letter to all customers
		for (GeneralContact gc : allContacts) {
			if (gc instanceof Customer) {
				gc.printLetter("This is a letter");
			}
		}
	}

}

package ch.fhnw.richards.topic04_ClassDesign.crmExample;

import java.util.ArrayList;

public class GeneralContact {
	private final Integer ID;
	private String name;
	private Gender gender;
	private Address postal;
	private ArrayList<String> emails;
	
	// Class attribute for global IDs
	private static Integer nextID = 0;
	
	/**
	 * Class method for global IDs. Note: in a real program, we would
	 * need to check against IDs stored in our CRM database, not just
	 * look at our class attribute.
	 */
	private static Integer getNextID() {
		return nextID++;
	}
	
	/**
	 * Constructor
	 */
	public GeneralContact() {
		this.ID = getNextID();
	}
	
	/**
	 * PrintLetter uses a template to create a letter to this contact,
	 * filling in details from this object, and using the text passed
	 * in as a parameter
	 */
	public void printLetter(String text) {
		// Omitted for simplicity...
	}

	
	// --- Getters and setters ---
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Address getPostal() {
		return postal;
	}

	public void setPostal(Address postal) {
		this.postal = postal;
	}

	public ArrayList<String> getEmails() {
		return emails;
	}

	public void setEmails(ArrayList<String> emails) {
		this.emails = emails;
	}

	public Integer getID() {
		return ID;
	}
}

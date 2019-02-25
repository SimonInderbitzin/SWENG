package ch.fhnw.richards.lecture02_basel.personGUI;

public class Person {
	private static int highestID = -1;
	
	private final int ID;
	private String lastName;
	private String firstName;
	private Gender gender;

	public enum Gender { MALE, FEMALE };
	
	// Class method to get the next available ID
	  private static int getNextID() {
	    highestID++;
	    return highestID;
	  }
	  
	private Person() {
		this.ID = getNextID();
	}
	
	public Person(String lastName, String firstName, Gender gender) {
		this(); // Call to constructor with no parameters
		this.lastName = lastName;
		this.firstName = firstName;
		this.gender = gender;
	}

	// --- Getters and Setters ---
	
	public int getID() {
		return ID;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (!lastName.isEmpty()) this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (!firstName.isEmpty()) this.firstName = firstName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
}

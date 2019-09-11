package ch.fhnw.richards.topic04_ClassDesign.crmExample;

public class Address {
	private final Integer ID;
	private String[] addressLines;
	private String postalCode;
	private String town;
	private String region;
	private String country;

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
	public Address() {
		this.ID = getNextID();
		addressLines = new String[3];
	}

	// --- Getters and setters ---
	public String[] getAddressLines() {
		return addressLines;
	}
	public void setAddressLines(String[] addressLines) {
		this.addressLines = addressLines;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getID() {
		return ID;
	}
}

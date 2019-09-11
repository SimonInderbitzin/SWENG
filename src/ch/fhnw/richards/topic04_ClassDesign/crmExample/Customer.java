package ch.fhnw.richards.topic04_ClassDesign.crmExample;

public class Customer extends GeneralContact {
	private Address billing;

	/**
	 * Constructors must initialize the superclass _first_
	 */
	public Customer() {
		super(); // Let the superclass initialize		
	}
	
	public Customer(Address billing) {
		super(); // Let the superclass initialize
		this.billing = billing;
	}

	/**
	 * PrintInvoice: print a cover letter and an invoice
	 */
	public void printInvoice(String text) {
		// Get the cover letter text from wherever...
		String coverLetterText = "This is a cover letter";
		
		// Call the method in the superclass
		super.printLetter(coverLetterText);
		
		// Now print the invoice...omitted for simplicity
	}
	
	// --- Getters and setters ---
	public Address getBilling() {
		return billing;
	}

	public void setBilling(Address billing) {
		this.billing = billing;
	}
}

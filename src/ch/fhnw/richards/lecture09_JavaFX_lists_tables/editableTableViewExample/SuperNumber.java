package ch.fhnw.richards.lecture09_JavaFX_lists_tables.editableTableViewExample;

import java.util.logging.Logger;

import javafx.beans.property.SimpleStringProperty;

/**
 * A SuperNumber is an integer, along with String representations of that
 * integer as a binary, decimal, and hexadecimal number. The setter methods
 * allow any of the representations to be changed (Strings). Changing a
 * representation will change the value of the number, and this will change all
 * of the other representations as well.
 * 
 * This class is part of the model. Since the representations will be needed by
 * the View, these are stored as properties, to allow ChangeListeners to be
 * defined.
 */
public class SuperNumber {
	private Integer value = 0;
	private final SimpleStringProperty asDecimal = new SimpleStringProperty();
	private final SimpleStringProperty asBinary = new SimpleStringProperty();
	private final SimpleStringProperty asHexadecimal = new SimpleStringProperty();
	
	public SuperNumber(int value) {
		this.value = value;
		updateRepresentations();
	}
	
	private void updateRepresentations() {
		asDecimal.set(value.toString());
		asBinary.set(Integer.toBinaryString(value));
		asHexadecimal.set(Integer.toHexString(value));
		Logger.getLogger("").info("Representations updated: " + asDecimal.get());
	}

	//--- Getters and Setters ---
	
	// Note: The naming is CRITICAL, because the TableView will derive method
	// names from the property names that it is given.
	
	public SimpleStringProperty asDecimalProperty() {
		return asDecimal;
	}

	public String getAsDecimal() {
		return asDecimal.get();
	}
	
	public void setAsDecimal(String newValue) {
		value = Integer.parseInt(newValue);
		updateRepresentations();
	}

	public SimpleStringProperty asBinaryProperty() {
		return asBinary;
	}
	
	public String getAsBinary() {
		return asBinary.get();
	}

	public void setAsBinary(String newValue) {
		value = Integer.parseInt(newValue, 2);
		updateRepresentations();
	}

	public SimpleStringProperty asHexadecimalProperty() {
		return asHexadecimal;
	}
	
	public String getAsHexadecimal() {
		return asHexadecimal.get();
	}

	public void setAsHexadecimal(String newValue) {
		value = Integer.parseInt(newValue, 16);
		updateRepresentations();
	}
}

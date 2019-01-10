package ch.fhnw.richards.lecture09_JavaFX_lists_tables.editableTableViewExample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TveModel {
	private final ObservableList<SuperNumber> elements = FXCollections.observableArrayList();

	public void addNewElement() {
		elements.add(new SuperNumber(elements.size()));
	}

	// getters and setters
	public ObservableList<SuperNumber> getElements() {
		return elements;
	}
}

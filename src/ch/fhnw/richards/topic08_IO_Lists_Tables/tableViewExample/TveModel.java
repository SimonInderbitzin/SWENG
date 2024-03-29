package ch.fhnw.richards.topic08_IO_Lists_Tables.tableViewExample;

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

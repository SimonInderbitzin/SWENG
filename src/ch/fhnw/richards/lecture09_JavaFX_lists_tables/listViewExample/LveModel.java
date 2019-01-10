package ch.fhnw.richards.lecture09_JavaFX_lists_tables.listViewExample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LveModel {
	private final ObservableList<Integer> elements = FXCollections.observableArrayList();

	public void addNewElement() {
		elements.add(elements.size());
	}
	
	public int multiplyByTwo(int input) {
		return input * 2;
	}

	// getters and setters
	public ObservableList<Integer> getElements() {
		return elements;
	}
}

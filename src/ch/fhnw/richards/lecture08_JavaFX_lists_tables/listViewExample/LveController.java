package ch.fhnw.richards.lecture08_JavaFX_lists_tables.listViewExample;

import javafx.collections.ListChangeListener;

public class LveController {
	private final LveModel model;
	private final LveView view;
	
	public LveController(LveModel model, LveView view) {
		this.model = model;
		this.view = view;
		
		// Event handler for the buttons
		view.btnAddNewElt.setOnAction(event -> model.addNewElement());
		view.btnMultiply.setOnAction(event -> doMultiply());
		
		// Event handler for the model's ObservableList requires a ListChangeListener.
		// To make generics happy, we have to cast our lambda: what kind of data do we have?
		// Note: May contain multiple changes - hence, the loop!
		model.getElements().addListener((ListChangeListener<Integer>) c -> {
			while (c.next()) {
				view.listView.scrollTo(c.getFrom());
			}
		});
	}
	
	private void doMultiply() {
		Integer value = view.listView.getSelectionModel().getSelectedItem();
		if (value != null) {
			Integer result = model.multiplyByTwo(value);
			view.lblResult.setText(result.toString());
		}
	}
}

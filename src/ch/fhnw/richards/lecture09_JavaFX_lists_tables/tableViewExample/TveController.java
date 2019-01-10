package ch.fhnw.richards.lecture09_JavaFX_lists_tables.tableViewExample;

import javafx.collections.ListChangeListener;

public class TveController {
	private final TveModel model;
	private final TveView view;
	
	public TveController(TveModel model, TveView view) {
		this.model = model;
		this.view = view;
		
		// Event handler for the button
		view.button.setOnAction(event -> model.addNewElement());
		
		// Event handler for the model's ObservableList requires a ListChangeListener.
		// To make generics happy, we have to cast our lambda: what kind of data do we have?
		// Note: May contain multiple changes - hence, the loop!
		model.getElements().addListener((ListChangeListener<SuperNumber>) c -> {
			while (c.next()) {
				view.tableView.scrollTo(c.getFrom());
			}
		});
	}

}

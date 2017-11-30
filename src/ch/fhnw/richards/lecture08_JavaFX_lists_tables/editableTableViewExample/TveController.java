package ch.fhnw.richards.lecture08_JavaFX_lists_tables.editableTableViewExample;

import javafx.collections.ListChangeListener;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;

public class TveController {
	private final TveModel model;
	private final TveView view;

	public TveController(TveModel model, TveView view) {
		this.model = model;
		this.view = view;

		// Event handler for the button
		view.button.setOnAction(event -> model.addNewElement());

		// Event handlers for the table columns: validate user input
		view.colBinary.setOnEditCommit(editEvent -> {
			String newValue = editEvent.getNewValue();
			if (isNumberValid(newValue, 2))
				getSuperNumberFromEvent(editEvent).setAsBinary(newValue);
			else // Erase invalid edited value by refreshing
				editEvent.getTableView().refresh();
		});

		// Decimal
		view.colDecimal.setOnEditCommit(editEvent -> {
			String newValue = editEvent.getNewValue();
			if (isNumberValid(newValue, 10))
				getSuperNumberFromEvent(editEvent).setAsDecimal(newValue);
			else // Erase invalid edited value by refreshing
				editEvent.getTableView().refresh();
		});

		// Hex
		view.colHex.setOnEditCommit(editEvent -> {
			String newValue = editEvent.getNewValue();
			if (isNumberValid(newValue, 16))
				getSuperNumberFromEvent(editEvent).setAsHexadecimal(newValue);
			else // Erase invalid edited value by refreshing
				editEvent.getTableView().refresh();
		});

		// Event handler for the model's ObservableList requires a
		// ListChangeListener, which is generic, so we have to cast our lambda
		// to fill in the type.
		//
		// ListChangeListener provides a list of events, so we must provide
		// a loop in case multiple changes are pending. We only want to scroll
		// to the position of the last change made.
		model.getElements().addListener((ListChangeListener<SuperNumber>) c -> {
			while (c.next()) {
				view.tableView.scrollTo(c.getFrom());
			}
		});
	}

	private boolean isNumberValid(String number, int radix) {
		boolean valid;
		try {
			Integer.parseInt(number, radix);
			valid = true;
		} catch (NumberFormatException e) {
			valid = false;
		}
		return valid;
	}

	private SuperNumber getSuperNumberFromEvent(CellEditEvent<SuperNumber, String> editEvent) {
		TableView<SuperNumber> tv = editEvent.getTableView();
		int rowNumber = editEvent.getTablePosition().getRow();
		return tv.getItems().get(rowNumber);
	}

}

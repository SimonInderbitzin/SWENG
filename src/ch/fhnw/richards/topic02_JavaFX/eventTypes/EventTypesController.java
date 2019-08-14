package ch.fhnw.richards.topic02_JavaFX.eventTypes;

import javafx.event.Event;

public class EventTypesController {
	final private EventTypesModel model;
	final private EventTypesView view;

	protected EventTypesController(EventTypesModel model, EventTypesView view) {
		this.model = model;
		this.view = view;

		view.btnClick.setOnAction(this::displayEvent);
		view.btnClick.setOnContextMenuRequested(this::displayEvent);
		view.btnClick.setOnKeyPressed(this::displayEvent);
		view.btnClick.setOnMouseClicked(this::displayEvent);
		view.btnClick.setOnMouseEntered(this::displayEvent);
		view.btnClick.setOnMouseExited(this::displayEvent);

		// Window can never be closed !!
		view.stage.setOnCloseRequest(e -> {
			displayEvent(e);
			e.consume();
		});
	}

	private void displayEvent(Event e) {
		String desc = e.getEventType().toString() + "\n";
		view.txtEventLog.appendText(desc);
	}
}

package ch.fhnw.richards.topic02_JavaFX.eventHandlingDemo;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

public class EventHandlingDemoController {

	final private EventHandlingDemoModel model;
	final private EventHandlingDemoView view;

	protected EventHandlingDemoController(EventHandlingDemoModel model, EventHandlingDemoView view) {
		this.model = model;
		this.view = view;
		
		// Event handling with an anonymous class
		view.btnClickAnonClass.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				incrementValue(e);
			}
		});
		
		// Event handling with a lambda
		view.btnClickLambda.setOnAction(e -> {
			incrementValue(e);
		});

		// Event handling with a method reference
		view.btnClickMethRef.setOnAction(this::incrementValue);

		// register ourselves to handle window-closing event
		view.getStage().setOnCloseRequest(this::closeWindow);
	}
	
	private void incrementValue(ActionEvent e) {
		model.incrementValue();
		String newText = Integer.toString(model.getValue());
		view.lblNumber.setText(newText);
	}
	
	public void closeWindow(WindowEvent e) {
		view.stop();
		Platform.exit();
	}
}

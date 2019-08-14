package ch.fhnw.richards.topic02_JavaFX.eventTypes;

import javafx.application.Application;
import javafx.stage.Stage;

public class EventTypesMVC extends Application {
	private EventTypesView view;
	private EventTypesController controller;
	private EventTypesModel model;

	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Note the dependencies between model, view and controller. Additionally,
	 * the view needs access to the primaryStage
	 */
	@Override
	public void start(Stage primaryStage) {
		// Initialize the GUI
		model = new EventTypesModel();
		view = new EventTypesView(primaryStage, model);
		controller = new EventTypesController(model, view);

		// Display the GUI after all initialization is complete
		view.start();
	}
}

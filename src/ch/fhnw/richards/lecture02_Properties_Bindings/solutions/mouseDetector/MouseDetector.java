package ch.fhnw.richards.lecture02_Properties_Bindings.solutions.mouseDetector;

import javafx.application.Application;
import javafx.stage.Stage;

public class MouseDetector extends Application {

	private MouseDetector_View view;
	private MouseDetector_Controller controller;
	private MouseDetector_Model model;

	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Note the dependencies between model, view and controller. Additionally,
	 * the view needs the primaryStage created by JavaFX.
	 */
	@Override
	public void start(Stage primaryStage) {
		// Initialize the GUI
		model = new MouseDetector_Model();
		view = new MouseDetector_View(primaryStage, model);
		controller = new MouseDetector_Controller(model, view);

		// Display the GUI after all initialization is complete
		view.start();
	}
}

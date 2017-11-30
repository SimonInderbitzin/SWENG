package ch.fhnw.richards.lecture08_JavaFX_lists_tables.editableTableViewExample;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TveMain extends Application {
	private TveModel model;
	private TveView view;
	private TveController controller;

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		model = new TveModel();
		view = new TveView(stage, model);
		controller = new TveController(model, view);

		view.start();
	}

}

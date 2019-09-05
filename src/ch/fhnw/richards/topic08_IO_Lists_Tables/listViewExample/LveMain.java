package ch.fhnw.richards.topic08_IO_Lists_Tables.listViewExample;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LveMain extends Application {
	private LveModel model;
	private LveView view;
	private LveController controller;

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		model = new LveModel();
		view = new LveView(stage, model);
		controller = new LveController(model, view);

		view.start();
	}

}

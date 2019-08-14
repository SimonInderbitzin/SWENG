package ch.fhnw.richards.topic02_JavaFX.solutions.dice;

import javafx.application.Application;
import javafx.stage.Stage;

public class Dice_MVC extends Application {
	private Dice_Model model;
	private Dice_View view;
	private Dice_Controller controller;
	
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		this.model = new Dice_Model();
		this.view = new Dice_View(stage, model);
		this.controller = new Dice_Controller(model, view);
		view.start();
	}
}

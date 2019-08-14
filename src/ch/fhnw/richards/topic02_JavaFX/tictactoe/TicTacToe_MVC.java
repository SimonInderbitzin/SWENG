package ch.fhnw.richards.topic02_JavaFX.tictactoe;

import javafx.application.Application;
import javafx.stage.Stage;

public class TicTacToe_MVC extends Application {
	private TicTacToe_Model model;
	private TicTacToe_View view;
	private TicTacToe_Controller controller;
	
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		this.model = new TicTacToe_Model();
		this.view = new TicTacToe_View(stage, model);
		this.controller = new TicTacToe_Controller(model, view);
		view.start();
	}
}

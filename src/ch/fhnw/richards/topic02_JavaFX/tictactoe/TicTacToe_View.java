package ch.fhnw.richards.topic02_JavaFX.tictactoe;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToe_View {
	private Stage stage;
	private TicTacToe_Model model;
	protected Button[][] buttons = new Button[TicTacToe_Model.BOARD_SIZE][TicTacToe_Model.BOARD_SIZE];
	
	public TicTacToe_View(Stage stage, TicTacToe_Model model) {
		this.stage = stage;
		this.model = model;
		
		GridPane grid = new GridPane();

		// Create the buttons
		for (int col = 0; col < TicTacToe_Model.BOARD_SIZE; col++) {
			for (int row = 0; row < TicTacToe_Model.BOARD_SIZE; row++) {
				// Create button for this position
				Button btn = new Button();
				buttons[col][row] = btn;
				grid.add(btn, col, row);
			}
		}
		
		// Create the scene using our layout; then display it
		Scene scene = new Scene(grid);
		scene.getStylesheets().add(
				getClass().getResource("TicTacToe.css").toExternalForm());
		stage.setScene(scene);
		stage.setTitle("Tic-Tac-Toe");
		stage.setResizable(false);
	}
	
	protected void start() {
		stage.show();
	}
}

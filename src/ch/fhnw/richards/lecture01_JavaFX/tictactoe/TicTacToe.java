package ch.fhnw.richards.lecture01_JavaFX.tictactoe;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToe extends Application {	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane grid = new GridPane();

		// Create the buttons: 3 columns & 3 rows
		for (int col = 0; col < 3; col++) {
			for (int row = 0; row < 3; row++) {
				// Create button for this position
				Button btn = new Button();
				grid.add(btn, col, row);
				
				// Set button size
				btn.setPrefSize(120, 120);
				
				// What happens when clicked?
				btn.setOnAction((ActionEvent e) -> {
						setButtonText(e);
				});
			}
		}
		
		// Create the scene using our layout; then display it
		Scene scene = new Scene(grid);
		scene.getStylesheets().add(
				getClass().getResource("TicTacToe.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Tic-Tac-Toe");
		primaryStage.show();
	}

	// When a button is clicked
	enum ValidMoves { X, O }; // Possible moves
	private ValidMoves nextMove = ValidMoves.X;
	
	private void setButtonText(ActionEvent e) {
		Button btn = (Button) e.getSource();
		btn.setText(nextMove.toString());
		if (nextMove.equals(ValidMoves.X)) {
			nextMove = ValidMoves.O;
		} else {
			nextMove = ValidMoves.X;
		}
	}
}
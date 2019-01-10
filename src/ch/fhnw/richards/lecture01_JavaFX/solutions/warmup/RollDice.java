package ch.fhnw.richards.lecture01_JavaFX.solutions.warmup;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RollDice extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane root = new GridPane();
		
		for (int i = 0; i < 2; i++) {
			Button btn = new Button("1"); // Initially show "1"
			root.add(btn, i, 0);
			btn.setPrefSize(100,100);
			btn.setOnAction((ActionEvent e) -> rollDie(e));
		}
		
		// Create the scene using our layout; then display it
		Scene scene = new Scene(root);
		scene.getStylesheets().add(
				getClass().getResource("RollDice.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Roll Dice");
		primaryStage.show();
	}
	
	private void rollDie(ActionEvent e) {
		Button btn = (Button) e.getSource();
		
		// Generate random number 1-6
		double rand = Math.random(); // Random number [0,1)
		int intRand = 1 + (int) (6 * rand); // Random integer [1,6]
		String strRand = Integer.toString(intRand); // Now as a string
		btn.setText(strRand);
	}
}

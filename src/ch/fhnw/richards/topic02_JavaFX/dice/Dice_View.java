package ch.fhnw.richards.topic02_JavaFX.dice;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Dice_View {
	private Stage stage;
	private Dice_Model model;
	
	Button[] dice = new Button[2]; // Array for buttons
	
	public Dice_View(Stage stage, Dice_Model model) {
		this.stage = stage;
		this.model = model;
		
		// Create and display the buttons
		GridPane root = new GridPane();

		// TODO: create buttons and add to layout
		
		// Create the scene using our layout; then display it
		Scene scene = new Scene(root);
		scene.getStylesheets().add(
				getClass().getResource("Dice.css").toExternalForm());
		stage.setScene(scene);
		stage.setTitle("Dice");
	}
	
	protected void start() {
		stage.show();
	}
}

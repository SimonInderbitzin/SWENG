package ch.fhnw.richards.topic02_JavaFX.petExample.v0;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PetView {
	private Stage stage;
	private PetModel model;

	public PetView(Stage stage, PetModel model) {
		this.stage = stage;
		this.model = model;
		
		VBox root = new VBox();
		root.getChildren().add(createDataEntryPane());
		root.getChildren().add(createControlPane());
		root.getChildren().add(createDataDisplayPane());

		// Standard stuff for Scene and Stage
		Scene scene = new Scene(root);
		scene.getStylesheets().add(
				getClass().getResource("Pet.css").toExternalForm());
		stage.setTitle("Enter and display a pet");
		stage.setScene(scene);
		stage.show();
	}
	
	public void start() {
		stage.show();
	}

	private Pane createDataEntryPane() {
		GridPane pane = new GridPane();
		pane.setId("dataEntry");
		pane.add(new Label("Data entry area"), 0, 0);
		return pane;
	}

	private Pane createControlPane() {
		GridPane pane = new GridPane();
		pane.setId("controlArea");
		pane.add(new Label("Control area"), 0, 0);
		return pane;
	}

	private Pane createDataDisplayPane() {
		GridPane pane = new GridPane();
		pane.setId("dataDisplay");
		pane.add(new Label("Data display area"), 0, 0);
		return pane;
	}
}

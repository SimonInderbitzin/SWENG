package ch.fhnw.richards.lecture02_basel.personGUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PersonEntry1 extends Application {
	Person person;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		VBox root = new VBox();
		root.getChildren().add(createDataEntryPane());
		root.getChildren().add(createButtonPane());
		root.getChildren().add(createDataDisplayPane());

		// Create the scene using our layout; then display it
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("PersonEntry1.css").toExternalForm());
		primaryStage.setTitle("Enter and display a person");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private Pane createDataEntryPane() {
		GridPane pane = new GridPane();
		pane.setId("dataEntry"); // ID for CSS formatting		
		pane.add(new Label("Data entry area"), 0, 0);		
		return pane;
	}

	private Pane createButtonPane() {
		GridPane pane = new GridPane();
		pane.setId("buttonArea"); // ID for CSS formatting		
		pane.add(new Label("Button area"), 0, 0);		
		return pane;
	}

	private Pane createDataDisplayPane() {
		GridPane pane = new GridPane();
		pane.setId("dataDisplay"); // ID for CSS formatting		
		pane.add(new Label("Data display area"), 0, 0);		
		return pane;
	}

}

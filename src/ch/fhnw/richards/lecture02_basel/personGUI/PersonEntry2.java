package ch.fhnw.richards.lecture02_basel.personGUI;

import ch.fhnw.richards.lecture02_basel.personGUI.Person.Gender;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PersonEntry2 extends Application {
	Person person = new Person("Miller", "James", Gender.MALE);
	
	// Controls used for data processing
	Label idData = new Label(Integer.toString(person.getID()));
    Label lnData = new Label(person.getLastName());
    Label fnData = new Label(person.getFirstName());
    Label genderData = new Label(person.getGender().toString());

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
		
		// Declare the individual controls in the GUI
	    Label idLabel = new Label("ID: ");
	    Label lnLabel = new Label("Last name: ");
	    Label fnLabel = new Label("First name: ");
	    Label genderLabel = new Label("Gender: ");
	    
	    // Organize the layout, add in the controls (col, row)
	    pane.add(idLabel, 0, 0); pane.add(idData, 1, 0);
	    pane.add(lnLabel, 0, 1); pane.add(lnData, 1, 1);
	    pane.add(fnLabel, 0, 2); pane.add(fnData, 1, 2);
	    pane.add(genderLabel, 0, 3); pane.add(genderData, 1, 3);
	    
		return pane;
	}

}

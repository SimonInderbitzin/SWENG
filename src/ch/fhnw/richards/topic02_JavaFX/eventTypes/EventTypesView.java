package ch.fhnw.richards.topic02_JavaFX.eventTypes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EventTypesView {
    private EventTypesModel model;
    protected Stage stage;
    
    protected Button btnClick = new Button("I am a button!");
    protected TextArea txtEventLog = new TextArea();

    protected EventTypesView(Stage stage, EventTypesModel model) {
		this.stage = stage;
		this.model = model;
		
		stage.setTitle("Event Handling Demo");
		
		GridPane root = new GridPane();
		root.addColumn(0, btnClick, txtEventLog);
		
		Scene scene = new Scene(root);
		stage.setScene(scene);;
	}
	
	public void start() {
		stage.show();
	}
}

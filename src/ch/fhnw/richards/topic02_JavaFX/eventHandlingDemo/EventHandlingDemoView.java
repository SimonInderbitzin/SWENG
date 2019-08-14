package ch.fhnw.richards.topic02_JavaFX.eventHandlingDemo;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EventHandlingDemoView {
    private EventHandlingDemoModel model;
    private Stage stage;

    protected Label lblAnonClass = new Label("Anon. Class");
    protected Label lblLambda = new Label("Lambda");
    protected Label lblMethodReference = new Label("Method Ref.");
	protected Label lblNumber = new Label();
	protected Button btnClickAnonClass = new Button("Click Me!");
	protected Button btnClickLambda = new Button("Click Me!");
	protected Button btnClickMethRef = new Button("Click Me!");

	protected EventHandlingDemoView(Stage stage, EventHandlingDemoModel model) {
		this.stage = stage;
		this.model = model;
		
		stage.setTitle("Event Handling Demo");
		
		GridPane root = new GridPane();
		lblNumber.setText(Integer.toString(model.getValue()));
		root.addRow(0,  lblAnonClass, lblLambda, lblMethodReference);
		root.addRow(1,  btnClickAnonClass, btnClickLambda, btnClickMethRef);
		root.add(lblNumber, 0, 2, 3, 1);
		
		lblNumber.setId("Number");
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(
				getClass().getResource("EventHandlingDemo.css").toExternalForm());
		stage.setScene(scene);;
	}
	
	public void start() {
		stage.show();
	}
	
	/**
	 * Stopping the view - just make it invisible
	 */
	public void stop() {
		stage.hide();
	}
	
	/**
	 * Getter for the stage, so that the controller can access window events
	 */
	public Stage getStage() {
		return stage;
	}
}
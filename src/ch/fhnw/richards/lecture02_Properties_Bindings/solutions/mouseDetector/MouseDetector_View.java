package ch.fhnw.richards.lecture02_Properties_Bindings.solutions.mouseDetector;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MouseDetector_View {
    private MouseDetector_Model model;
    private Stage stage;

	protected Label lblDetector;
	
	protected MouseDetector_View(Stage stage, MouseDetector_Model model) {
		this.stage = stage;
		this.model = model;
		
		stage.setTitle("Button Click MVC");
		
		GridPane root = new GridPane();
		lblDetector = new Label("This is a label");
		lblDetector.setMinSize(200, 200);
		root.add(lblDetector, 0, 0);

		Scene scene = new Scene(root);
		stage.setScene(scene);;
	}
	
	public void start() {
		stage.show();
	}
}

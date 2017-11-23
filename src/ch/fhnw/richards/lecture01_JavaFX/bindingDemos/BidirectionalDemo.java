package ch.fhnw.richards.lecture01_JavaFX.bindingDemos;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BidirectionalDemo extends Application {
	private Slider slider1 = new Slider(0, 100, 50);
	private Slider slider2 = new Slider(0, 100, 50);
	private TextField text1 = new TextField();
	private TextField text2 = new TextField();

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {

		// Bind the sliders together
		slider1.valueProperty().bindBidirectional(slider2.valueProperty());
		
		// Bind the textfields together
		text1.textProperty().bindBidirectional(text2.textProperty());

		VBox root = new VBox(slider1, slider2, text1, text2);

		// We should format in CSS, not in Java
		root.setPadding(new Insets(10));
		root.setSpacing(10);

		Scene scene = new Scene(root);
		stage.setTitle("Bidirectional Binding");
		stage.setScene(scene);
		stage.show();
	}

}

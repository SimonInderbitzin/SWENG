package ch.fhnw.richards.lecture01_JavaFX.bindingDemos;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UnidirectionalSlider extends Application {
	private Label  label = new Label();;
	private Slider slider = new Slider(0, 100, 50);

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		// Bind the slider to the label
		label.textProperty().bind(slider.valueProperty().asString("%.2f"));
		
		VBox root = new VBox(label, slider);
		
		// We should format in CSS, not in Java
		root.setPadding(new Insets(10));
		root.setSpacing(10);
		
		Scene scene = new Scene(root);
		stage.setTitle("Unidirectional Binding");
		stage.setScene(scene);
		stage.show();
	}

}

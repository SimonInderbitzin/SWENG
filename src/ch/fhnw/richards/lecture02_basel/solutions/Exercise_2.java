package ch.fhnw.richards.lecture02_basel.solutions;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise_2 extends Application {
	private TextField txtIn = new TextField();
	private Button btnSave = new Button("Save");
	private Label lblData = new Label("Text copied here");

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane root = new GridPane();
		root.add(txtIn, 0, 0);
		root.add(btnSave, 1, 0);
		root.add(lblData, 0, 1, 2, 1);
		
		btnSave.setOnAction(e -> {
			lblData.setText(txtIn.getText());
		});
		
		Scene scene = new Scene(root, 300, 100);
		primaryStage.setTitle("Exercise 2");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
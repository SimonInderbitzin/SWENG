package ch.fhnw.richards.lecture02_basel.solutions;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise_1 extends Application {
	private TextField txtLeft = new TextField("13");
	private TextField txtRight = new TextField("27");
	private Button btnLeft = new Button("Left Button");
	private Button btnRight = new Button("Right Button");

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane root = new GridPane();
		root.add(txtLeft, 0, 0);
		root.add(txtRight, 1, 0);
		root.add(btnLeft, 0, 1);
		root.add(btnRight, 1, 1);
		
		btnLeft.setOnAction(e -> {
			int leftValue = Integer.parseInt(txtLeft.getText());
			txtLeft.setText(Integer.toString(leftValue * 2));
		
			int rightValue = Integer.parseInt(txtRight.getText());
			txtRight.setText(Integer.toString(rightValue+1));
		});

		btnRight.setOnAction(e -> {
			int leftValue = Integer.parseInt(txtLeft.getText());
			txtLeft.setText(Integer.toString(leftValue - 1));
		
			int rightValue = Integer.parseInt(txtRight.getText());
			txtRight.setText(Integer.toString(rightValue / 2));
		});		
		
		Scene scene = new Scene(root, 300, 100);
		primaryStage.setTitle("Exercise 1");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}

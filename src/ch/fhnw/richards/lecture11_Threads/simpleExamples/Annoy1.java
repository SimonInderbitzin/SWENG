package ch.fhnw.richards.lecture11_Threads.simpleExamples;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Annoy1 extends Application {
	private AnnoyThread1 annoyance = null;
	BorderPane root;
	private Button btnClick = new Button("Start annoying me");
	
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		root = new BorderPane();
		
		root.setCenter(btnClick);

		btnClick.setOnAction( event -> doIt());

		Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.show();
	}
	
	private void doIt() {
		if (annoyance == null) {
			annoyance = new AnnoyThread1(this, "annoyer");
			annoyance.start();
			btnClick.setText("Stop annoying me!");
		} else {
			annoyance.pleaseStop();
			annoyance.interrupt(); // optional
			annoyance = null;
			btnClick.setText("Start annoying me!");
		}		
	}
	
	public Node getRoot() {
		return root;
	}
}

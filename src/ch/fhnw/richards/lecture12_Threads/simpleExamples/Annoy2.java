package ch.fhnw.richards.lecture12_Threads.simpleExamples;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Annoy2 extends Application {
	private ArrayList<AnnoyLabel2> labels = new ArrayList<>();
	private Button btnClick = new Button("Start annoying me"); 

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane root = new BorderPane();
		root.setCenter(btnClick);
		
		AnnoyLabel2 north = new AnnoyLabel2("North", 300);
		root.setTop(north);
		labels.add(north);
		
		AnnoyLabel2 east = new AnnoyLabel2("East", 200);
		root.setRight(east);
		labels.add(east);
		
		AnnoyLabel2 south = new AnnoyLabel2("South", 500);
		root.setBottom(south);
		labels.add(south);
		
		AnnoyLabel2 west = new AnnoyLabel2("West", 400);
		root.setLeft(west);
		labels.add(west);

		btnClick.setOnAction( event -> doIt());

		Scene scene = new Scene(root, 400, 300);
        scene.getStylesheets().add(
                getClass().getResource("Annoy2.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
	}
	
	private void doIt() {
		for (AnnoyLabel2 r : labels) {
			if (r.isAlive()) {
				r.stop();
				btnClick.setText("Start annoying me!");
			} else {
				r.start();
				btnClick.setText("Stop annoying me!");
			}
		}
	}
}

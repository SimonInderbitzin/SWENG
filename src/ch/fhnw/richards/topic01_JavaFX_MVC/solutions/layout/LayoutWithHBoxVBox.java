package ch.fhnw.richards.topic01_JavaFX_MVC.solutions.layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LayoutWithHBoxVBox extends Application {
	Button alpha = new Button("alpha");
	Button beta = new Button("beta");
	Button delta = new Button("delta");
	Button gamma = new Button("gamma");
	Button left = new Button("left");
	Button right = new Button("right");
	TextArea bigText = new TextArea(
			"Lorem ipsum dolor sit amet,\n" +
			"consetetur sadipscing elitr,\n" +
			"sed diam nonumy eirmod tempor,\n" +
			"invidunt ut labore et dolore,\n" +
			"magna aliquyam erat, sed diam,\n" +
			"voluptua. At vero eos et accusam,\n" +
			"et justo duo dolores et ea rebum.,\n" +
			"Stet clita kasd gubergren, no sea,\n" +
			"takimata sanctus est Lorem ipsum,\n" +
			"dolor sit amet. Lorem ipsum dolor,\n" +
			"sit amet, consetetur sadipscing,\n" +
			"elitr, sed diam nonumy eirmod,\n" +
			"tempor invidunt ut labore et,\n" +
			"dolore magna aliquyam erat, sed,\n" +
			"diam voluptua. At vero eos et,\n" +
			"accusam et justo duo dolores et,\n" +
			"ea rebum. Stet clita kasd,\n" +
			"gubergren, no sea takimata sanctus,\n" +
			"est Lorem ipsum dolor sit amet.");

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Define a fixed spacer between the buttons
		Region spacer1 = new Region();
		spacer1.setPrefHeight(30);
	    VBox leftButtons = new VBox(alpha, beta, spacer1, delta, gamma);
	    
	    // Button text disappears (bad resizing from JavaFX) if the window
	    // is too narrow: force min-size to be at least the computed pref-size
	    alpha.setMinWidth(Region.USE_PREF_SIZE);
	    beta.setMinWidth(Region.USE_PREF_SIZE);
	    delta.setMinWidth(Region.USE_PREF_SIZE);
	    gamma.setMinWidth(Region.USE_PREF_SIZE);
	    
	    // Define a spacer between the buttons, that grows if the HBox is resized
	    Region spacer2 = new Region();
	    HBox.setHgrow(spacer2, Priority.ALWAYS);
	    HBox bottomButtons = new HBox(left, spacer2, right);
	    
	    // ensure that bigText grows if the VBox is resized
	    VBox.setVgrow(bigText, Priority.ALWAYS);
	    VBox rightRegion = new VBox(bigText, bottomButtons);
	    
	    HBox root = new HBox(leftButtons, rightRegion);

	    Scene scene = new Scene(root);
	    primaryStage.setTitle("Layout exercise");
	    primaryStage.setScene(scene);
	    primaryStage.show();

	}
}

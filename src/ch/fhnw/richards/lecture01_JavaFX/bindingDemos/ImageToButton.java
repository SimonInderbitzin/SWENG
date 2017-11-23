package ch.fhnw.richards.lecture01_JavaFX.bindingDemos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * This is an example where a binding is the wrong solution!
 * 
 * Image source: https://commons.wikimedia.org/wiki/File:Kot_Leni.jpg
 */
public class ImageToButton extends Application {
	Button btn = new Button();
	Image img = new Image(ImageToButton.class.getResourceAsStream("Kot_Leni.jpg"));

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		
		btn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		root.setCenter(btn);
		
		ImageView imv = new ImageView();
		imv.setImage(img);
		imv.setPreserveRatio(true);
		
		btn.setGraphic(imv);
		
		// We must leave room at the edge of the button, or we get a runaway effect
//		btn.widthProperty().addListener((e) -> imv.setFitWidth(btn.getWidth()-20));
		
		// We can also do this with a binding - but again, we must subtract 20 to
		// to avoid a runaway effect.
		imv.fitWidthProperty().bind(btn.widthProperty().subtract(20)); 
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}

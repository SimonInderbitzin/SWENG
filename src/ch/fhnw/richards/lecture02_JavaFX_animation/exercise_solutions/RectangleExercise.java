package ch.fhnw.richards.lecture02_JavaFX_animation.exercise_solutions;

import javafx.animation.Animation;
import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RectangleExercise extends Application {

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Create new object with initial position and size
		Rectangle rect = new Rectangle(0, 0, 50, 50);
		rect.setStroke(Color.BLUE);
		rect.setStrokeWidth(4);
		rect.setFill(Color.GREEN);
		
		// Create the PathTransition
		Path path = new Path();
		path.getElements().add(new MoveTo(25,25));
		path.getElements().add(new LineTo(375,25));
		path.getElements().add(new LineTo(375,375));
		path.getElements().add(new LineTo(25,375));
		path.getElements().add(new LineTo(25,25));
		PathTransition move = new PathTransition(Duration.millis(4000), path);
		
		// Create a FillTransition that reverses
		FillTransition fill = new FillTransition(Duration.millis(2000));
		fill.setToValue(Color.RED);
		fill.setAutoReverse(true);
		fill.setCycleCount(2);
		
		// Create the ParallelTransition
		ParallelTransition parallel = new ParallelTransition(move, fill);
		
		// Execute
		parallel.setNode(rect);
		parallel.setCycleCount(Animation.INDEFINITE);
		parallel.play();
		
		
		// Display the scene, which contains our object-group
		Scene scene = new Scene(new Group(rect), 400, 400, Color.WHITE);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Rectangle Exercise");
		primaryStage.show();
	}
}

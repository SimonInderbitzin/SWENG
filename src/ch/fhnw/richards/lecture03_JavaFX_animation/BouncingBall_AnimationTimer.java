package ch.fhnw.richards.lecture03_JavaFX_animation;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class BouncingBall_AnimationTimer extends Application {
	private final Circle ball = new Circle(100, 100, 20, Color.BLUE);
	private int deltaX = 2; // X velocity
	private int deltaY = 3; // Y velocity

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(final Stage primaryStage) {
		Scene scene = new Scene(new Group(ball), 400, 400, Color.WHITE);
		primaryStage.setTitle("BouncingBall_AnimationTimer");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long time) {
				// Locate the edges of the ball
				double xMin = ball.getBoundsInParent().getMinX();
				double yMin = ball.getBoundsInParent().getMinY();
				double xMax = ball.getBoundsInParent().getMaxX();
				double yMax = ball.getBoundsInParent().getMaxY();

				// Bounce off of edge of scene
				if (xMin < 0 || xMax > scene.getWidth()) deltaX = 0 - deltaX;
				if (yMin < 0 || yMax > scene.getHeight()) deltaY = 0 - deltaY;

				// Directly update the position of the ball
				ball.setTranslateX(ball.getTranslateX() + deltaX);
				ball.setTranslateY(ball.getTranslateY() + deltaY);
			}
		};		
		timer.start();
	}
}
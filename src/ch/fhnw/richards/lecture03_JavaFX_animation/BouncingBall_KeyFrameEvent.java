package ch.fhnw.richards.lecture03_JavaFX_animation;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Adapted from: http://www.java2s.com/Code/Java/JavaFX/KeyFrameandTimelinebasedanimation.htm
 */
public class BouncingBall_KeyFrameEvent extends Application {
	private final Circle ball = new Circle(100, 100, 20, Color.BLUE);
	private int deltaX = 2; // X velocity
	private int deltaY = 3; // Y velocity

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(final Stage primaryStage) {
		Scene scene = new Scene(new Group(ball), 400, 400, Color.WHITE);

		KeyFrame moveBall = new KeyFrame(Duration.seconds(.02), // 50 FPS
				new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
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
				});
		Timeline tl = new Timeline(moveBall);
		tl.setCycleCount(Animation.INDEFINITE);
		tl.play();

		primaryStage.setTitle("BouncingBall_KeyFrameEvent");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
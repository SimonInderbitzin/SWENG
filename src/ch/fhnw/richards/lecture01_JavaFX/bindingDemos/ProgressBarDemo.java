package ch.fhnw.richards.lecture01_JavaFX.bindingDemos;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.Worker.State;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ProgressBarDemo extends Application {

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		ProgressBar progressBar = new ProgressBar();

		// A "Task" is a JavaFX object that does work. We create a task below.
		// One of its properties is the progressProperty, which we can bind to
		// the progress bar.
		// - Normally, the task would be part of the model
		// - Normally, this binding would be made in the controller
		progressBar.progressProperty().bind(longTask.progressProperty());

		// When finished, close this program
		longTask.stateProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue == State.SUCCEEDED) Platform.exit();
		});

		GridPane root = new GridPane();
		root.add(progressBar, 0, 0);
		progressBar.setPrefWidth(300);

		Scene scene = new Scene(root);
		stage.setScene(scene);
		;
		stage.setTitle("Email Validator");
		stage.show();

		new Thread(longTask).start();
	}

	// A "Task" is a JavaFX class that contains some piece of work to be done.
	// Tasks have properties, one of which is their progress.
	final Task<Void> longTask = new Task<Void>() {
		@Override
		protected Void call() throws Exception {

			// Some long task here
			for (long i = 0; i < 10000000000l; i++) {
				if ((i % 1000000) == 0) {
					int step = (int) (i / 1000000000l + 1);
					this.updateProgress(step, 10);
				}
			}

			return null; // done
		}
	};

}

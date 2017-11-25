package ch.fhnw.richards.lecture01_JavaFX.mvc.buttonClick;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

public class ButtonClickController {

	final private ButtonClickModel model;
	final private ButtonClickView view;

	protected ButtonClickController(ButtonClickModel model, ButtonClickView view) {
		this.model = model;
		this.view = view;

		// register ourselves to listen for button clicks
		view.btnClick.setOnAction((event) -> {
			model.incrementValue();
			String newText = Integer.toString(model.getValue());
			view.lblNumber.setText(newText);
		});

		// register ourselves to handle window-closing event
		view.getStage().setOnCloseRequest((event) -> {
			view.stop();
			Platform.exit();
		});
	}
}

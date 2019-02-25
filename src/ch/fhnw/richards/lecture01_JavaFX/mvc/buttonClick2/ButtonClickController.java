package ch.fhnw.richards.lecture01_JavaFX.mvc.buttonClick2;

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
		view.btnClick.setOnAction(this::incrementValue);

		// register ourselves to handle window-closing event
		view.getStage().setOnCloseRequest(this::closeWindow);
	}
	
	public void incrementValue(ActionEvent e) {
		model.incrementValue();
		String newText = Integer.toString(model.getValue());
		view.lblNumber.setText(newText);
	}
	
	public void closeWindow(WindowEvent e) {
		view.stop();
		Platform.exit();
	}
}

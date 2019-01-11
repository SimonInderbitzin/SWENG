package ch.fhnw.richards.lecture02_Properties_Bindings.solutions.mouseDetector;

public class MouseDetector_Controller {
	final private MouseDetector_Model model;
	final private MouseDetector_View view;

	protected MouseDetector_Controller(MouseDetector_Model model, MouseDetector_View view) {
		this.model = model;
		this.view = view;

		view.lblDetector.setOnMouseClicked((mouseEvent) -> Woof("Clicked"));

		view.lblDetector.setOnMouseEntered((mouseEvent) -> Woof("Detected"));

		view.lblDetector.setOnMouseExited((mouseEvent) -> Woof("Missing"));
	}

	private void Woof(String text) {
		view.lblDetector.setText("Mouse " + text);
	}

}

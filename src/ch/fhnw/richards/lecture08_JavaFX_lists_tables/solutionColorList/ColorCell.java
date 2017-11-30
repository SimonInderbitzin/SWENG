package ch.fhnw.richards.lecture08_JavaFX_lists_tables.solutionColorList;

import javafx.scene.control.ListCell;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * @author Dieter Holz
 */
public class ColorCell extends ListCell<Color> {
	private Circle circle = new Circle(30);

	@Override
	protected void updateItem(Color item, boolean empty) {
		super.updateItem(item, empty);
		if (item != null & !empty) {
			int red   = (int) Math.round(item.getRed() * 255);
			int green = (int) Math.round(item.getGreen() * 255);
			int blue  = (int) Math.round(item.getBlue() * 255);
			setText("R: " + red + " G: " + green + " B:" + blue);
			circle.setFill(item);
			setGraphic(circle);
		} else {
			setText("");
			setGraphic(null);
		}
	}
}

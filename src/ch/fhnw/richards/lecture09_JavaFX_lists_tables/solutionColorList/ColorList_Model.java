package ch.fhnw.richards.lecture09_JavaFX_lists_tables.solutionColorList;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

public class ColorList_Model {
	private final ObservableList<Color> colorList = FXCollections.observableArrayList();

	private final IntegerProperty red   = new SimpleIntegerProperty(0);
	private final IntegerProperty green = new SimpleIntegerProperty(0);
	private final IntegerProperty blue  = new SimpleIntegerProperty(0);

	private final ObjectProperty<Color> color = new SimpleObjectProperty<>();

	public ColorList_Model() {
		color.bind(Bindings.createObjectBinding(() -> Color.rgb(getRed(), getGreen(), getBlue()), red, green, blue));
	}

	public void addColor() {
		colorList.add(getColor());
	}


	// all getters and setters

	public int getRed() {
		return red.get();
	}

	public IntegerProperty redProperty() {
		return red;
	}

	public void setRed(int red) {
		this.red.set(red);
	}

	public int getGreen() {
		return green.get();
	}

	public IntegerProperty greenProperty() {
		return green;
	}

	public void setGreen(int green) {
		this.green.set(green);
	}

	public int getBlue() {
		return blue.get();
	}

	public IntegerProperty blueProperty() {
		return blue;
	}

	public void setBlue(int blue) {
		this.blue.set(blue);
	}

	public Color getColor() {
		return color.get();
	}

	public ObjectProperty<Color> colorProperty() {
		return color;
	}

	public void setColor(Color color) {
		this.color.set(color);
	}

	public ObservableList<Color> getColorList() {
		return colorList;
	}
}
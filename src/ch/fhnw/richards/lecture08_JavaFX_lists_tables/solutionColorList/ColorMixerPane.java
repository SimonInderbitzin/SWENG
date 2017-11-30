package ch.fhnw.richards.lecture08_JavaFX_lists_tables.solutionColorList;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.shape.Rectangle;


public class ColorMixerPane extends GridPane {
	private final ColorList_Model model;

	protected Slider sliderRed;
	protected Slider sliderGreen;
	protected Slider sliderBlue;

	protected Label lblRed;
	protected Label lblBlue;
	protected Label lblGreen;

	protected Rectangle rectColorDisplay;

	public ColorMixerPane(ColorList_Model model) {
		this.model = model;
		initializeControls();
		layoutControls();
	}

	private void initializeControls() {
		sliderRed   = new Slider(0.0, 255, 0);
		sliderGreen = new Slider(0.0, 255, 0);
		sliderBlue  = new Slider(0.0, 255, 0);

		lblRed = new Label();
		lblGreen = new Label();
		lblBlue = new Label();

		rectColorDisplay = new Rectangle();
		rectColorDisplay.setHeight(100);
	}

	private void layoutControls() {
		setPadding(new Insets(10));
		setHgap(10);
		setVgap(10);

		ColumnConstraints sliderColumn = new ColumnConstraints();
		sliderColumn.setHgrow(Priority.ALWAYS);

		ColumnConstraints valueColumn = new ColumnConstraints(30);
		valueColumn.setHalignment(HPos.RIGHT);

		getColumnConstraints().addAll(sliderColumn, valueColumn);

		addRow(0, sliderRed  , lblRed);
		addRow(1, sliderGreen, lblGreen);
		addRow(2, sliderBlue , lblBlue);
		add(rectColorDisplay, 0, 3, 2, 1);

		setPrefHeight(getPrefHeight() + 200);
	}	
}

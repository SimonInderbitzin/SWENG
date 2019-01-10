package ch.fhnw.richards.lecture09_JavaFX_lists_tables.solutionColorList;

import javafx.collections.ListChangeListener;
import javafx.scene.paint.Color;

public class ColorList_Controller {
	private ColorList_Model model;
	private ColorList_View view;
	
	
	public ColorList_Controller(ColorList_Model model, ColorList_View view) {
		this.model = model;
		this.view = view;
		
		addEventHandlers();
		addValueChangedListeners();
		addColorMixerPaneBindings();
	}

	private void addEventHandlers() {
		view.button.setOnAction(event -> model.addColor());
	}

	private void addValueChangedListeners() {
		model.getColorList().addListener((ListChangeListener<Color>) c -> {
			while(c.next()){
				view.listView.scrollTo(c.getFrom());
			}
		});
	}
	
	private void addColorMixerPaneBindings() {
		ColorMixerPane cmp = view.colorMixer;
		cmp.sliderRed.valueProperty().bindBidirectional(model.redProperty());
		cmp.lblRed.textProperty().bind(model.redProperty().asString());

		cmp.sliderGreen.valueProperty().bindBidirectional(model.greenProperty());
		cmp.lblGreen.textProperty().bind(model.greenProperty().asString());

		cmp.sliderBlue.valueProperty().bindBidirectional(model.blueProperty());
		cmp.lblBlue.textProperty().bind(model.blueProperty().asString());

		cmp.rectColorDisplay.fillProperty().bind(model.colorProperty());

		cmp.rectColorDisplay.widthProperty().bind(cmp.widthProperty().subtract(20));
	}	
}

package ch.fhnw.richards.lecture08_JavaFX_lists_tables.solutionColorList;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ColorList_View {
	private Stage stage;
	private ColorList_Model model;
	
	protected ColorMixerPane colorMixer;
	protected Button          button;
	protected ListView<Color> listView;

	public ColorList_View(Stage stage, ColorList_Model model) {
		this.stage = stage;
		this.model = model;
		
		colorMixer = new ColorMixerPane(model);
		button = new Button("Save color");
		listView = new ListView<>(model.getColorList());
		listView.setCellFactory(param -> new ColorCell());
		
		VBox root = new VBox(colorMixer, button, listView);
		root.getStyleClass().add("root"); // Class for styling
		VBox.setVgrow(listView, Priority.ALWAYS);

		Scene scene = new Scene(root);
		String stylesheet = getClass().getResource("style.css").toExternalForm();
		scene.getStylesheets().add(stylesheet);
		stage.setTitle("Color List");
		stage.setScene(scene);
	}
	
	public void start() {
		stage.show();
	}
}

package ch.fhnw.richards.lecture09_JavaFX_lists_tables.listViewExample;

import javax.swing.GroupLayout.Alignment;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class LveView {
	private final LveModel model;
	private final Stage stage;

	protected Button btnAddNewElt = new Button("Add New Element");
	protected Button btnMultiply = new Button("Multiply by 2");
	protected Label lblResult = new Label();

	protected ListView<Integer> listView;

	public LveView(Stage stage, LveModel model) {
		this.model = model;
		this.stage = stage;

		// Initialize ListView: bind to ObservableList in model
		listView = new ListView<>(model.getElements());

		// Lower HBox for multiplication
		HBox.setHgrow(lblResult, Priority.ALWAYS); // Resize goes to the label
		HBox hbox = new HBox(btnMultiply, lblResult);
		
		// Layout root pane
		VBox root = new VBox();
		root.getStyleClass().add("root"); // Class for styling
		VBox.setVgrow(listView, Priority.ALWAYS); // Vertical resize goes to the listView
		root.getChildren().addAll(listView, btnAddNewElt, hbox);

		// Size constraints
		btnAddNewElt.setMaxWidth(Double.MAX_VALUE); // button can grow horizontally

		// Final stuff
		Scene scene = new Scene(root);
		String stylesheet = getClass().getResource("style.css").toExternalForm();
		scene.getStylesheets().add(stylesheet);
		stage.setTitle("List view example");
		stage.setScene(scene);
	}

	public void start() {
		stage.show();
	}
}

package ch.fhnw.richards.topic08_IO_Lists_Tables.tableViewExample;

import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TveView {
	private final TveModel model;
	private final Stage stage;

	protected Button button = new Button("Add New Element");
	protected TableView<SuperNumber> tableView;

	public TveView(Stage stage, TveModel model) {
		this.model = model;
		this.stage = stage;

		// Initialize TableView
		TableView<SuperNumber> tableView = createTableView();

		// Layout root pane
		VBox root = new VBox();
		root.setPadding(new Insets(10)); // around edge of VBox
		root.setSpacing(10); // between elements
		VBox.setVgrow(tableView, Priority.ALWAYS); // Vertical resize goes to the table
		root.getChildren().addAll(tableView, button);

		// Size constraints
		button.setMaxWidth(Double.MAX_VALUE); // button can grow horizontally

		// Final stuff
		Scene scene = new Scene(root);
		stage.setTitle("Table view example");
		stage.setScene(scene);
	}

	private TableView<SuperNumber> createTableView() {
		tableView = new TableView<>();

		// Each column needs a title, and a source of data.
		TableColumn<SuperNumber, String> colBinary = new TableColumn<>("Binary");
		colBinary.setCellValueFactory(c -> c.getValue().asBinaryProperty());
		tableView.getColumns().add(colBinary);

		TableColumn<SuperNumber, String> colDecimal = new TableColumn<>("Decimal");
		colDecimal.setCellValueFactory(c -> c.getValue().asDecimalProperty());
		tableView.getColumns().add(colDecimal);

		TableColumn<SuperNumber, String> colHex = new TableColumn<>("Hexadecimal");
		colHex.setCellValueFactory(c -> c.getValue().asHexadecimalProperty());
		tableView.getColumns().add(colHex);

		// Finally, attach the tableView to the ObservableList of data
		tableView.setItems(model.getElements());
		
		return tableView;
	}

	public void start() {
		stage.show();
	}
}

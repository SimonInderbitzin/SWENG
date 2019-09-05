package ch.fhnw.richards.topic08_IO_Lists_Tables.nationalAssemblyElection;

import java.util.Comparator;

import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NA_View {
	private Stage stage;
	private NA_Model model;
	
	private TableView<Result> tblResult;
	private Label lblStatus = new Label();
	
	public NA_View(Stage stage, NA_Model model) {
		this.stage = stage;
		this.model = model;
		
		tblResult = initTable();
		
		VBox root = new VBox();
		root.getChildren().addAll(tblResult, lblStatus);
		VBox.setVgrow(tblResult, Priority.ALWAYS);

		// Status label is computed from model information
		lblStatus.textProperty().bind(
				Bindings.size(model.getResults()).asString("Election results from %d townships"));
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("National assembly elections 2007");
	}
	
	public void start() {
		stage.show();
	}

	private TableView<Result> initTable() {
		TableView<Result> tableView = new TableView<>(model.getResults());

		TableColumn<Result, String> townshipNameCol   = new TableColumn<>("Township");
		TableColumn<Result, String> cantonCol          = new TableColumn<>("");
		TableColumn<Result, Number> registeredVotersCol = new TableColumn<>("Registered voters");
		TableColumn<Result, Number> numberVotersCol        = new TableColumn<>("Num. voters");
		TableColumn<Result, String> voterParticipationCol = new TableColumn<>("Voter participation");

		townshipNameCol.setCellValueFactory(cell -> cell.getValue().townshipNameProperty());
		cantonCol.setCellValueFactory(cell -> cell.getValue().cantonProperty());
		registeredVotersCol.setCellValueFactory(cell -> cell.getValue().registeredVotersProperty());
		numberVotersCol.setCellValueFactory(cell -> cell.getValue().numberVotersProperty());
		voterParticipationCol.setCellValueFactory(cell -> cell.getValue().voterParticipationProperty().asString("%.2f %%"));

		cantonCol.setCellFactory(param -> new CantonTableCell());

		townshipNameCol.setMinWidth(200);

		tableView.getColumns().addAll(townshipNameCol, cantonCol, registeredVotersCol, numberVotersCol, voterParticipationCol);

		return tableView;
	}
}

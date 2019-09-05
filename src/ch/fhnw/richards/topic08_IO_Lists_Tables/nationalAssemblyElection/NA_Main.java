package ch.fhnw.richards.topic08_IO_Lists_Tables.nationalAssemblyElection;

import javafx.application.Application;
import javafx.stage.Stage;

public class NA_Main extends Application {
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		NA_Model model = new NA_Model();
		NA_View view = new NA_View(primaryStage, model);
		NA_Controller controller = new NA_Controller(model, view);
		
		view.start();
	}

}

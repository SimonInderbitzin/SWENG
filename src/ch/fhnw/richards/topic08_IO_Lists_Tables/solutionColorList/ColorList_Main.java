package ch.fhnw.richards.topic08_IO_Lists_Tables.solutionColorList;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ColorList_Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		ColorList_Model model = new ColorList_Model();
		ColorList_View view = new ColorList_View(primaryStage, model);
		ColorList_Controller controller = new ColorList_Controller(model, view);
		
		view.start();
	}

}

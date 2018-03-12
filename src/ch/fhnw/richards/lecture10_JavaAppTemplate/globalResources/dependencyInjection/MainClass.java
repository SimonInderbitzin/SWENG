package ch.fhnw.richards.lecture10_JavaAppTemplate.globalResources.dependencyInjection;

import java.util.Locale;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// ServiceLocator via dependency injection
public class MainClass extends Application {
	private ServiceLocator serviceLocator;

	// Available locales
	private Locale locale_en = new Locale("en");
	private Locale locale_de = new Locale("de");

	// Controls
	Label lblLocale = new Label();
	Button btnSwitch = new Button("Switch Locale");
	Button btnGo = new Button("Go do stuff");
	Label lblResult = new Label();

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void init() {
		// Initialize ServiceLocator and resources
		serviceLocator = new ServiceLocator();
		serviceLocator.setLocale(locale_en);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox(10);
		root.getChildren().addAll(lblLocale, btnSwitch, btnGo, lblResult);

		btnSwitch.setOnAction(e -> {
			if (serviceLocator.getLocale() == locale_en) {
				serviceLocator.setLocale(locale_de);
			} else {
				serviceLocator.setLocale(locale_en);
			}
			updateGUI();
		});

		btnGo.setOnAction(e -> do_stuff());

		updateGUI();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("example.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void updateGUI() {
		lblLocale.setText("Currently selected: " + serviceLocator.getLocale().getDisplayLanguage());
	}

	// This method represents the program functionality
	// In our case, we just create an instance of MiddleClass,
	// passing it our one resource "selectedLocale"
	private void do_stuff() {
		MiddleClass m = new MiddleClass(serviceLocator);
		lblResult.setText(m.go());
	}
}

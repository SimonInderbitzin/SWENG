package jabberwocky.letterBased.appClasses;

import java.util.Locale;
import java.util.logging.Logger;

import jabberwocky.letterBased.ServiceLocator;
import jabberwocky.letterBased.abstractClasses.View;
import jabberwocky.letterBased.commonClasses.Translator;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Copyright 2015, FHNW, Prof. Dr. Brad Richards. All rights reserved. This code
 * is licensed under the terms of the BSD 3-clause license (see the file
 * license.txt).
 * 
 * @author Brad Richards
 */
public class App_View extends View<App_Model> {
	Menu menuFile;
	Menu menuFileLanguage;
	MenuItem menuFileTrain;
	Menu menuHelp;
	Slider sliderNumLetters;
	Button btnGenerate;
	Text txtGeneratedText;
	ScrollPane txtScroll;
	Label lblStatus;

	ServiceLocator sl = ServiceLocator.getServiceLocator();

	public App_View(Stage stage, App_Model model) {
		super(stage, model);
		stage.setTitle(sl.getTranslator().getString("program.name"));

		sl.getLogger().info("Application view initialized");
	}

	@Override
	protected Scene create_GUI() {
		ServiceLocator sl = ServiceLocator.getServiceLocator();
		Logger logger = sl.getLogger();
		Translator t = sl.getTranslator();

		MenuBar menuBar = new MenuBar();
		menuFile = new Menu(t.getString("program.menu.file"));
		menuFileLanguage = new Menu(t.getString("program.menu.file.language"));
		menuFile.getItems().add(menuFileLanguage);

		for (Locale locale : sl.getLocales()) {
			MenuItem language = new MenuItem(locale.getLanguage());
			menuFileLanguage.getItems().add(language);
			language.setOnAction(event -> {
				sl.getConfiguration().setLocalOption("Language", locale.getLanguage());
				sl.setTranslator(new Translator(locale.getLanguage()));
				updateTexts();
			});
		}

		menuFileTrain = new MenuItem(t.getString("program.menu.file.train"));
		menuFile.getItems().add(menuFileTrain);

		menuHelp = new Menu(t.getString("program.menu.help"));
		menuBar.getMenus().addAll(menuFile, menuHelp);

		sliderNumLetters = new Slider(1, 7, 3);
		sliderNumLetters.setShowTickLabels(true);
		sliderNumLetters.setMajorTickUnit(1);
		sliderNumLetters.setMinorTickCount(0);
		sliderNumLetters.setBlockIncrement(1);
		sliderNumLetters.setSnapToTicks(true);
		
		txtGeneratedText = new Text();
		txtScroll= new ScrollPane(txtGeneratedText);
		txtScroll.setId("generatedText");
		
		btnGenerate = new Button();
		lblStatus = new Label();
		
		HBox topHBox = new HBox(10, sliderNumLetters, btnGenerate);		
		VBox topVBox = new VBox(menuBar, topHBox);

		BorderPane root = new BorderPane();
		root.setTop(topVBox);
		root.setCenter(txtScroll);
		root.setBottom(lblStatus);
		
		updateTexts();
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
		return scene;
	}

	protected void updateTexts() {
		Translator t = ServiceLocator.getServiceLocator().getTranslator();

		// The menu entries
		menuFile.setText(t.getString("program.menu.file"));
		menuFileLanguage.setText(t.getString("program.menu.file.language"));
		menuHelp.setText(t.getString("program.menu.help"));

		// Other controls
		btnGenerate.setText(t.getString("button.generate"));
		
		// Update status bar
		updateStatusBar();
	}
	
	void updateStatusBar() {
		Translator t = ServiceLocator.getServiceLocator().getTranslator();
		int numEntries = model.getNumEntries();
		String status = t.getString("status.entries") + " " + numEntries;
		if (numEntries > 0) status += "   /   "
				+ t.getString("status.links") + " " + model.getNumLinks();
		lblStatus.setText(status);
		btnGenerate.setDisable(numEntries == 0);
	}
}
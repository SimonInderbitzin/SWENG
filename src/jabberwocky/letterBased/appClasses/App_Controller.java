package jabberwocky.letterBased.appClasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import jabberwocky.letterBased.ServiceLocator;
import jabberwocky.letterBased.abstractClasses.Controller;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.WindowEvent;

/**
 * Copyright 2015, FHNW, Prof. Dr. Brad Richards. All rights reserved. This code
 * is licensed under the terms of the BSD 3-clause license (see the file
 * license.txt).
 * 
 * @author Brad Richards
 */
public class App_Controller extends Controller<App_Model, App_View> {
	ServiceLocator serviceLocator;

	public App_Controller(App_Model model, App_View view) {
		super(model, view);
		
		// register ourselves to listen for menu items
		view.menuFileTrain.setOnAction((e) -> train() );
		view.menuFileClear.setOnAction((e) -> clear() );

		// register ourselves to listen for button clicks
		view.btnGenerate.setOnAction((e) -> buttonClick() );
		
		serviceLocator = ServiceLocator.getServiceLocator();
		serviceLocator.getLogger().info("Application controller initialized");
	}

	public void clear() {
		model.clearTrainingData();
		view.updateStatus();
	}
	
	public void train() {
		FileChooser fileChooser = new FileChooser();
		File f = fileChooser.showOpenDialog(view.getStage());
		if (f != null) {		
			try (BufferedReader in = new BufferedReader(new FileReader(f))) {
				StringBuffer sb = new StringBuffer();
				String line = in.readLine();
				while (line != null) {
					sb.append(line);
					sb.append("\n");
					line = in.readLine();
				}
				int numChars = (int) view.sliderNumLetters.getValue();
				model.train(numChars, sb.toString());
				view.updateStatus();
			} catch (Exception e) {
				serviceLocator.getLogger().severe(e.toString());
			}			
		}
	}

	public void buttonClick() {
		String out = model.generateText();
		view.txtGeneratedText.setText(out);
	}
}

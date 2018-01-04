package jabberwocky.letterBased.appClasses;

import jabberwocky.letterBased.ServiceLocator;
import jabberwocky.letterBased.abstractClasses.Controller;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

		// register ourselves to listen for button clicks
		view.btnClick.setOnAction((e) -> buttonClick() );
		
		serviceLocator = ServiceLocator.getServiceLocator();
		serviceLocator.getLogger().info("Application controller initialized");
	}
	
	public void train() {
		
	}

	public void buttonClick() {
		model.incrementValue();
		String newText = Integer.toString(model.getValue());

		view.lblNumber.setText(newText);
	}
}

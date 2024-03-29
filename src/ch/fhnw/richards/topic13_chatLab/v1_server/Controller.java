package ch.fhnw.richards.topic13_chatLab.v1_server;

import javafx.collections.ListChangeListener;

public class Controller {
	private Model model;
	private View view;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;

		view.btnStart.setOnAction(event -> {
			int port = Integer.parseInt(view.txtPort.getText());
			model.startServer(port);
		});

		view.stage.setOnCloseRequest(event -> model.stopServer());

		model.clients.addListener((ListChangeListener) (event -> view.updateClients()));
	}
}

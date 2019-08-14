package ch.fhnw.richards.topic02_JavaFX.tictactoe;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class TicTacToe_Controller {
	private TicTacToe_Model model;
	private TicTacToe_View view;

	public TicTacToe_Controller(TicTacToe_Model model, TicTacToe_View view) {
		this.model = model;
		this.view = view;
		
		for (int col = 0; col < view.buttons.length; col++) {
			for (int row = 0; row < view.buttons[0].length; row++) {
				view.buttons[col][row].setOnAction(this::buttonClick);
			}
		}
	}
	
	private void buttonClick(ActionEvent e) {
		// Find the button
		Button btn = (Button) e.getSource();
		int col = -1;
		int row = -1;
		for (int c = 0; c < view.buttons.length; c++) {
			for (int r = 0; r < view.buttons[0].length; r++) {
				if (btn == view.buttons[c][r]) {
					col = c;
					row = r;
				}
			}
		}

		if (model.makeMove(col, row)) {
			view.buttons[col][row].setText(model.board[col][row].toString());
		}
	}
}

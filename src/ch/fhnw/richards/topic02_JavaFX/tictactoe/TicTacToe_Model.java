package ch.fhnw.richards.topic02_JavaFX.tictactoe;

public class TicTacToe_Model {
	public static final int BOARD_SIZE = 3;
	
	public enum ValidMove { X, O }; // Possible moves
	private ValidMove nextMove = ValidMove.X;
	
	protected ValidMove[][] board = new ValidMove[BOARD_SIZE][BOARD_SIZE];
	
	/**
	 * Make a move in the indicated place, alternating X and O.
	 * We can only move in a blank (null) space.
	 */
	public boolean makeMove(int col, int row) {
		boolean moveMade = false;
		if (board[col][row] == null) {
			board[col][row] = nextMove;
			nextMove = (nextMove == ValidMove.X) ? ValidMove.O : ValidMove.X;
			moveMade = true;
		}
		return moveMade;
	}
}

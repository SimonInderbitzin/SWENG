package poker_v0;

import javafx.application.Application;
import javafx.stage.Stage;
import poker_v0.gui.PokerGameGUI;
import poker_v0.logic.PokerGameLogic;

public class PokerGame extends Application {
	public static final int NUM_PLAYERS = 2;
	PokerGameLogic logic;
	PokerGameGUI gui;
	
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    	// Create and initialize the game logic
    	logic = new PokerGameLogic();
    	
    	// Create the GUI, using the primaryStage
    	gui = new PokerGameGUI(primaryStage, logic);
    }
}

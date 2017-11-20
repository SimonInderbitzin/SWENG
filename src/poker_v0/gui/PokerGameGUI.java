package poker_v0.gui;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import poker_v0.PokerGame;
import poker_v0.logic.Player;
import poker_v0.logic.PokerGameLogic;

public class PokerGameGUI {
	private HBox players;
	private ControlArea controls;
	
	private PokerGameLogic logic;
	
	public PokerGameGUI(Stage stage, PokerGameLogic logic) {
		this.logic = logic;
		
		// Create all of the player panes we need, and put them into an HBox
		players = new HBox();
		for (int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
			PlayerPane pp = new PlayerPane();
			pp.setPlayer(logic.getPlayer(i)); // link to player object in the logic
			players.getChildren().add(pp);
		}
		
		// Create the control area
		controls = new ControlArea(this, logic);
		controls.linkDeck(logic.getDeck()); // link DeckLabel to DeckOfCards in the logic
		
		// Put players and controls into a VBox
		VBox root = new VBox(players, controls);

        // Create the scene using our layout; then display it
        Scene scene = new Scene(root);
        scene.getStylesheets().add(
                getClass().getResource("poker.css").toExternalForm());
        stage.setTitle("Poker Miniproject");
        stage.setScene(scene);
        stage.show();		
	}
	
	public PlayerPane getPlayerPane(int i) {
		return (PlayerPane) players.getChildren().get(i);
	}
}

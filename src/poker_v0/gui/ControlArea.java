package poker_v0.gui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import poker_v0.PokerGame;
import poker_v0.logic.Card;
import poker_v0.logic.DeckOfCards;
import poker_v0.logic.Player;
import poker_v0.logic.PokerGameLogic;

public class ControlArea extends HBox implements EventHandler<ActionEvent> {
	PokerGameGUI gui;
	PokerGameLogic logic;
	
    private DeckLabel lblDeck = new DeckLabel();
    private Region spacer = new Region(); // Empty spacer
    private Button btnShuffle = new Button("Shuffle");
    private Button btnDeal = new Button("Deal");

    public ControlArea(PokerGameGUI gui, PokerGameLogic logic) {
    	super(); // Always call super-constructor first !!
    	
    	this.gui = gui;
    	this.logic = logic;
    	
    	this.getChildren().addAll(lblDeck, spacer, btnShuffle, btnDeal);

        HBox.setHgrow(spacer, Priority.ALWAYS); // Use region to absorb resizing
        this.setId("controlArea"); // Unique ID in the CSS
        
        // Register for button events
        btnShuffle.setOnAction(this);
        btnDeal.setOnAction(this);    
    }
    
    public void linkDeck(DeckOfCards deck) {
    	lblDeck.setDeck(deck);
    }

    /**
     * Handle button clicks
     */
    @Override
    public void handle(ActionEvent event) {
        Button btnClicked = (Button) event.getSource();
        if (btnClicked == btnShuffle) {
            shuffleCards();
        } else if (btnClicked == btnDeal) {
            playPoker();
        }
    }

    /**
     * Remove all cards from players hands, and shuffle the deck
     */
    private void shuffleCards() {
    	for (int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
    		Player p = logic.getPlayer(i);
    		p.discardHand();
    		PlayerPane pp = gui.getPlayerPane(i);
    		pp.updatePlayerDisplay();
    	}

        logic.getDeck().shuffle();
    }
    
    /**
     * Deal each player five cards, then evaluate the two hands
     */
    private void playPoker() {
    	int cardsRequired = PokerGame.NUM_PLAYERS * Player.HAND_SIZE;
    	DeckOfCards deck = logic.getDeck();
    	if (cardsRequired <= deck.getCardsRemaining()) {
        	for (int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
        		Player p = logic.getPlayer(i);
        		p.discardHand();
        		for (int j = 0; j < Player.HAND_SIZE; j++) {
        			Card card = deck.dealCard();
        			p.addCard(card);
        		}
        		p.evaluateHand();
        		PlayerPane pp = gui.getPlayerPane(i);
        		pp.updatePlayerDisplay();
        	}
    	} else {
            Alert alert = new Alert(AlertType.ERROR, "Not enough cards - shuffle first");
            alert.showAndWait();
    	}
    }
}

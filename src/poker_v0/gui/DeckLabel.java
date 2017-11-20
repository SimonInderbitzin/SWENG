package poker_v0.gui;

import javafx.scene.control.Label;
import poker_v0.logic.DeckOfCards;

public class DeckLabel extends Label {
	private DeckOfCards deck;
	
	public DeckLabel() {
		super();
		this.getStyleClass().add("deck");
	}
	
	// Bind the label to the CardsRemaining property of the deck
	public void setDeck(DeckOfCards deck) {
		this.textProperty().bind(deck.getCardsRemainingProperty().asString());
	}
}

package poker_v0.gui;

import javafx.scene.control.Label;
import poker_v0.logic.Card;

public class CardLabel extends Label {
	private Card card;
	
	public CardLabel() {
		super();
		this.getStyleClass().add("card");
	}
	
	public void setCard(Card card) {
		this.card = card;
		if (card != null)
			this.setText(card.toString());
		else
			this.setText("");
	}
}

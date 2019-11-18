package model;

import java.util.ArrayList;
import java.util.Observable;


@SuppressWarnings("deprecation")
public class Board extends Observable {
	private ArrayList<Card> cards;
	final int MAX_CARD = 7;
	
	public boolean addCard(Card card) {
		if(this.MAX_CARD == this.cards.size()) {
			return false;
		}
		this.cards.add(card);
		notifyObservers("addCard");
		return true;
	}
	
	public boolean destroyCard(Card card) {
		for(Card board_card : this.cards) {
			if(board_card.equals(card)) {
				this.cards.remove(board_card);
			}
		}
		notifyObservers("destroyCard");
		return true;
	}
}

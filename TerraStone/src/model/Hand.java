package model;
import java.util.Observable;
import java.util.ArrayList;

@SuppressWarnings("deprecation")
public class Hand extends Observable{
	private ArrayList<Card> cards;
	final int MAX_CARD=10; 
	
	public boolean removeCard(Card card) {
		for(Card hand_card : this.cards) {
			if(hand_card.equals(card)) {
				this.cards.remove(hand_card);
			}
		}
		notifyObservers("removeCard");
		return true;
	}
	public boolean addCard(Card card) {
		if(this.MAX_CARD == this.cards.size()) {
			return false;
		}
		this.cards.add(card);
		notifyObservers("addCard");
		return true;
	}


}

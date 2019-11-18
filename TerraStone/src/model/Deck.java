package model;
import java.util.Observable;
import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("deprecation")
public class Deck extends Observable{
	private ArrayList<Card> cards;
	final int MAX_CARD=20; 
	
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
	public Card pickCard() {
		// TODO Auto-generated method stub
		Card retour = null;
		if(this.cards.size()>0) {
			Collections.shuffle(this.cards);
			retour = this.cards.get(0);
		}
		notifyObservers("pickCard");
		return retour;
	}
}

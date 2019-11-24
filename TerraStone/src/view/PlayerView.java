package view;

import java.util.Observable;
import java.util.Observer;

import javafx.fxml.FXML;
import model.Deck;
import model.Hand;
import model.Player;

public class PlayerView implements Observer{
	
	Player player;
	Deck deck;
	Hand hand;
	
	PlayerView(Player player) {
		this.player = player;
		player.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		this.deck = player.getDeck();
		this.hand = player.getHand();
		System.out.println(this.deck);
	}
	
	
	@FXML
	private void initialize() {
		System.out.println("initialize player view");
		
	}
	

}

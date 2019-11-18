package model;
import java.util.ArrayList;
import java.util.Observable;

@SuppressWarnings("deprecation")
public class Player extends Observable{
	/**
	 * Attributes
	 */
	private Deck deck;
	private Hero hero;
	private Hand hand;
	private Board board;
	private Deck tmp_deck;
	
	
	/**
	 * Constructor
	 */
	public Player() {
		this.deck = new Deck();
		this.hero = new Hero();
		this.hand = new Hand();
		this.setBoard(new Board());
		this.tmp_deck = new Deck();
	}
	
	/**
	 * Getters 
	 * Setters
	 */

	/**
	 * @return the deck
	 */
	public Deck getDeck() {
		return deck;
	}

	/**
	 * @param deck the deck to set
	 */
	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	/**
	 * @return the hero
	 */
	public Hero getHero() {
		return hero;
	}

	/**
	 * @param hero the hero to set
	 */
	public void setHero(Hero hero) {
		this.hero = hero;
	}

	/**
	 * @return the hand
	 */
	public Hand getHand() {
		return hand;
	}

	/**
	 * @param hand the hand to set
	 */
	public void setHand(Hand hand) {
		this.hand = hand;
	}

	/**
	 * @return the tmp_deck
	 */
	public Deck getTmp_deck() {
		return tmp_deck;
	}

	/**
	 * @param tmp_deck the tmp_deck to set
	 */
	public void setTmp_deck(Deck tmp_deck) {
		this.tmp_deck = tmp_deck;
	}

	/**
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * @param board the board to set
	 */
	public void setBoard(Board board) {
		this.board = board;
	}
	
	/**
	 * Methods
	 */
	public boolean addCardToDeck(Card card) {
		
		notifyObservers("addCardToDeck");
		return false;
	}
	
	public boolean removeCardFromDeck(Card card) {
		
		notifyObservers("removeCardFromDeck");
		return false;
	}
	
	public boolean saveDeck(Card card) {
		
		notifyObservers("saveDeck");
		return false;
	}
	
	public boolean playMonsterOnBoard(Card card) {
		boolean cardIsOnBoard = this.board.addCard(card);
		if(cardIsOnBoard) this.hand.removeCard(card);
		notifyObservers("playMonsterOnBoard");
		return false;
	}
	
	public boolean useSpell(Card card,Hero hero,ArrayList<Card> targets_card) {
		
		notifyObservers("useSpell");
		return false;
	}
	
	public boolean draw() {
		Card newCard = this.tmp_deck.pickCard();
		if(newCard != null) {
			this.hand.addCard(newCard);
			this.tmp_deck.removeCard(newCard);
		} else {
			this.hero.exhaustHero();
		}
		notifyObservers("draw");
		return false;
	}
	
	public boolean getLaPiece() {
		
		notifyObservers("getLaPiece");
		return false;
	}
	
	public boolean useHeroPower() {
		
		notifyObservers("useHeroPower");
		return false;
	}
	
	public boolean monsterAttack(Card card, Hero hero) {
		
		notifyObservers("monsterAttack");
		return false;
	}

}

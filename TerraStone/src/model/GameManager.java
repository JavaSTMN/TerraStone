package model;
import java.util.Random;
public class GameManager {
	/**
	 * Attributes
	 */
	private Player p1;
	private Player p2;
	private boolean order;
	
	/**
	 * Constructor
	 */
	public GameManager() {
		this.setP1(new Player());
		this.setP2(new Player());
		this.setOrder((new Random()).nextBoolean());
		if(this.getOrder()) {
			Player p2 = this.getP2();
			p2.getLaPiece();
		}
	}



	/**
	 * @return the p2
	 */
	public Player getP2() {
		return p2;
	}


	/**
	 * @param p2 the p2 to set
	 */
	public void setP2(Player p2) {
		this.p2 = p2;
	}


	/**
	 * @return the p1
	 */
	public Player getP1() {
		return p1;
	}


	/**
	 * @param p1 the p1 to set
	 */
	public void setP1(Player p1) {
		this.p1 = p1;
	}
	
	/**
	 * @return the order
	 */
	public boolean getOrder() {
		return order;
	}
	
	
	/**
	 * @param order the order to set
	 */
	public void setOrder(boolean order) {
		this.order = order;
	}
	
	public void newTurn() {
		boolean order = this.getOrder();
		if(order) {
			Hero h1 = this.p1.getHero();
			h1.refresh_mana();
			h1.setHeroPowerIsUsed(false);
		} else {
			Hero h2 = this.p2.getHero();
			h2.refresh_mana();
			h2.setHeroPowerIsUsed(false);
		}
		
		this.setOrder(!order);
	}


}
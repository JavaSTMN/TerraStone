package model;
public class Monster extends Card implements ITarget{
	private int damages;
	private int hp;
	private boolean hasAttacked;
	
	public Monster(int mana_cost,String name, String effect_description,String type,int damages,int hp) {
		super(mana_cost,name,effect_description,type);
		this.damages = damages;
		this.hp = hp;
		this.hasAttacked =false;
		
	}
	public int getDamages() {
		return damages;
	}
	public void setDamages(int damages) {
		this.damages = damages;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public boolean isHasAttacked() {
		return hasAttacked;
	}
	public void setHasAttacked(boolean hasAttacked) {
		this.hasAttacked = hasAttacked;
		notifyObservers("setHasAttacked");
	}
	@Override
	public int takeDamages(int val) {
		this.setHp(this.hp-val);
		notifyObservers("takeDamages");
		return this.damages;
	} 
}

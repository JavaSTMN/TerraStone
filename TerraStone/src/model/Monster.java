package model;

public class Monster implements ITarget{
	private int damages;
	private int hp;
	private boolean hasAttacked;
	
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
	}
	@Override
	public boolean takeDamages(int val) {
		this.setHp(this.hp-val);
		return true;
	} 
}

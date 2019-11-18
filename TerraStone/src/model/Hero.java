package model;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class Hero extends Observable implements ITarget{
	private int mana;
	private int mana_max;
	private int hero_power;
	private int health;
	private String name;
	private String name_class;
	
	// Getters - Setters
	
		public int getMana() {
			return mana;
		}
		public void setMana(int mana) {
			this.mana = mana;
		}
		public int getMana_max() {
			return mana_max;
		}
		public void setMana_max(int mana_max) {
			this.mana_max = mana_max;
		}
		public int getHero_power() {
			return hero_power;
		}
		public void setHero_power(int hero_power) {
			this.hero_power = hero_power;
		}
		public int getHealth() {
			return health;
		}
		public void setHealth(int health) {
			this.health = health;
		}
		public String getName_class() {
			return name_class;
		}
		public void setName_class(String name_class) {
			this.name_class = name_class;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		//Methods
	
	public int gain_mana(int mana) {
		if(this.mana != 10) {
			mana = this.mana + 1;
		}
		notifyObservers("gain_mana");
		return mana;
	}
	
	public int refresh_mana() {
		if(this.mana_max != 10) 
		{
			this.mana_max = this.mana_max + 1;
			this.mana = this.mana_max;
		}		
		else
		{
			this.mana_max = 10;
			this.mana = this.mana_max;
		}
		notifyObservers("refresh_mana");
		return this.mana;
	}
	
	public int spend_mana(int mana_cost) {
		if(this.mana > mana_cost) {
			this.mana = this.mana - mana_cost;
		}
		else {
			return -1;
		}
		notifyObservers("spend_mana");
		return this.mana;
	}
	
	@Override
	public boolean takeDamages(int val) {
		// TODO Auto-generated method stub
		return false;
	}	
}

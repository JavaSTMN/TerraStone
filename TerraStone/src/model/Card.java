package model;

public class Card {
	private int mana_cost;
	private String name; 
	private String effect_description;
	
	public String getEffect_description() {
		return effect_description;
	}
	public void setEffect_description(String effect_description) {
		this.effect_description = effect_description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMana_cost() {
		return mana_cost;
	}
	public void setMana_cost(int mana_cost) {
		this.mana_cost = mana_cost;
	}

	
}

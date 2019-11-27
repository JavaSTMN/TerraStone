package model;

public abstract class Spell extends Card{
	public Spell(int mana_cost,String name, String effect_description,String type) {
		super(mana_cost,name,effect_description,type);
	}
	public abstract void UseSpell(Object obj);
}

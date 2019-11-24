package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CardFX {
	private IntegerProperty mana_cost = new SimpleIntegerProperty();
	private StringProperty name = new SimpleStringProperty(); 
	private StringProperty effect_description = new SimpleStringProperty();
		
	public CardFX(int mana_cost,String name, String effect_description) {
		this.mana_cost.setValue(mana_cost);
		this.name.set(name);
		this.effect_description.set(effect_description);
	}
	public StringProperty getEffect_description() {
		return effect_description;
	}
	public void setEffect_description(String effect_description) {
		this.effect_description.set(effect_description);
	}
	public StringProperty getName() {
		return name;
	}
	public void setName(String name) {
		this.name.set(name);
	}
	public IntegerProperty getMana_cost() {
		return mana_cost;
	}
	public void setMana_cost(int mana_cost) {
		this.mana_cost.set(mana_cost);
	}

	
}

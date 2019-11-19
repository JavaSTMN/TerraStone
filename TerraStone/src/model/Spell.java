package model;

public abstract class Spell extends Card{
	private String type;
	public Spell(int mana_cost,String name, String effect_description,String type) {
		super(mana_cost,name,effect_description);
		this.setType(type);
	}
	public abstract void UseSpell(Object obj);
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
}

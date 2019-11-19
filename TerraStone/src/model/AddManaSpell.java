package model;

@SuppressWarnings("deprecation")
public class AddManaSpell extends Spell{
	private int value;
	
	public AddManaSpell(int mana_cost,String name, String effect_description,String type,int value) {
		super(mana_cost,name,effect_description,type);
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	@Override
	public void UseSpell(Object obj) {
		// TODO Auto-generated method stub
		int mana_gain = this.getValue();
		((Hero) obj).gain_mana(mana_gain);
		notifyObservers("UseSpell");
	}
}

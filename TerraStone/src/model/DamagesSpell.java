package model;

@SuppressWarnings("deprecation")
public class DamagesSpell extends Spell{
	private int value;
	private boolean random;
	
	public DamagesSpell(int mana_cost,String name, String effect_description,String type,int value,boolean random) {
		super(mana_cost,name,effect_description,type);
		this.value = value;
		this.random = random;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public boolean isRandom() {
		return random;
	}
	public void setRandom(boolean random) {
		this.random = random;
	}
	@Override
	public void UseSpell(Object obj) {
		// TODO Auto-generated method stub
		int dmg = this.getValue();
		if(this.isRandom()) dmg = 1;
		((ITarget) obj).takeDamages(dmg);
		notifyObservers("UseSpell");
	}

}

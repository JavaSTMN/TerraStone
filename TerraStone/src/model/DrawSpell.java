package model;

@SuppressWarnings("deprecation")
public class DrawSpell extends Spell{
	private int value;
	
	public DrawSpell(int mana_cost,String name, String effect_description,String type,int value) {
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
		((Player) obj).draw();
		notifyObservers("UseSpell");
	}


}

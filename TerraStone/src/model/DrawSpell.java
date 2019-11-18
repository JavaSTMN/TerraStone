package model;

@SuppressWarnings("deprecation")
public class DrawSpell extends Spell{
	private int value;
	
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

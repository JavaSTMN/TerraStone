package model;

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
		((Hand) obj).drawCard();
		
	}


}

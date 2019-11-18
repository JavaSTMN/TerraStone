package model;

public class MageHeroPower implements IHeroPower{
	public void useHeroPower(ITarget target) {		
		
		target.takeDamages(1);
		
	}
}

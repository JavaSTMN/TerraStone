package model;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class MageHeroPower extends Observable implements IHeroPower{
	@SuppressWarnings("deprecation")
	public void useHeroPower(ITarget target) {		
		
		target.takeDamages(1);
		notifyObservers("useHeroPower");
	}
}

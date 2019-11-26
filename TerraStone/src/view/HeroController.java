package view;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Hero;

public class HeroController {
	
	private Main main;
	
	@FXML
	private Label health;
	
	@FXML
	private Label heroName;
	
	@FXML
	private Label mana;
	
	@FXML
	private Label manaMax;
	
	private Hero hero;
	
	
	@FXML
	private void initialize() {
		
	}
	
	public void setMainApp(Main main) {
		this.main = main;
	}
	
	public void initHeroData() {
		System.out.println(this.hero.getName());
		this.heroName.setText(this.hero.getName());
		this.health.setText(Integer.toString(this.hero.getHealth()));
		this.mana.setText(Integer.toString(this.hero.getMana()));
		this.manaMax.setText(Integer.toString(this.hero.getMana_max()));

	}

	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

}

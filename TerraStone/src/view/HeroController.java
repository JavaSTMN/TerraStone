package view;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

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
	
	
	
	@FXML
	private void initialize() {
		
	}
	
	public void setMainApp(Main main) {
		this.main = main;
	}

}

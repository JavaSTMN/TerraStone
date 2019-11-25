package view;

import application.Main;
import javafx.fxml.FXML;
import model.Player;

public class PlayerController {
	
	private Main main;
	
	private Player player;
	
	PlayerController(Player p) {
		this.player = p;
		System.out.println(this.player);
	}
	
	@FXML
	private void initialize() {	}

	public void setMainApp(Main main) {
		this.main = main;
	}
	
	public void initHand() {
		System.out.println("INIT HAND FOR PLAYER");
		this.main.initialisationContenu(getClass().getResource("../view/Hand.fxml"), "hand");
	}
}

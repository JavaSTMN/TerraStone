package view;

import application.Main;
import javafx.fxml.FXML;

public class PlayerController {
	
	private Main main;
	
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

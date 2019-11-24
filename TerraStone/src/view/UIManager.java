package view;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Separator;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Player;

public class UIManager {
	
	private Main main;
	
	private Player p1 = new Player();
	
	private PlayerView pView1 = new PlayerView(p1);
	private PlayerController pc1 = new PlayerController(p1, pView1);
	
	public void setMainApp(Main main) {
		this.main = main;
	}
	

	@FXML
	private void initialize() {
	}

}

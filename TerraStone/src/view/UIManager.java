package view;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Player;

public class UIManager {
	
	private Main main;
	
	@FXML
	private AnchorPane playerOneArea;
	
	@FXML
	private AnchorPane playerTwoArea;
	
	private Player p1 = new Player();
	
	//pass a player argument after
	private PlayerController pC1 = new PlayerController();
	
	
	
	
	public UIManager() {
		
	}
	
	public void setMainApp(Main main) {
		this.main = main;
	}
	

	@FXML
	private void initialize() {
		try {
			Pane paneJ1 = FXMLLoader.load(getClass().getResource("../view/Player.fxml"));
			playerOneArea.getChildren().add(paneJ1); 
			
			Pane paneJ2 = FXMLLoader.load(getClass().getResource("../view/Player.fxml"));
			playerTwoArea.getChildren().add(paneJ2); 

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initPlayers() {
		this.main.initialisationContenu(getClass().getResource("../view/Player.fxml"), "player");
	}
	
	

}

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
import model.GameManager;
import model.Player;

public class UIManager {
	
	private Main main;
	
	@FXML
	private AnchorPane playerOneArea;
	
	@FXML
	private AnchorPane playerTwoArea;
	
	//private Player p1 = new Player();
	
	private GameManager game;
	
	//pass a player argument after
	private PlayerController pC1;
	
	//pass a player argument after
	private PlayerController pC2;
	
	
	
	public UIManager() {
		
	}
	
	public void setMainApp(Main main) {
		this.main = main;
	}
	

	@FXML
	private void initialize() {
		try {
			
			this.game = new GameManager();
			Player p1 = this.game.getP1();
			
			FXMLLoader player1Loader = new FXMLLoader(getClass().getResource("../view/Player.fxml"));
			pC1 = player1Loader.getController();

			Pane paneJ1 = player1Loader.load();
			playerOneArea.getChildren().add(paneJ1); 
			
			System.out.println("Player 1 pane");
			
			FXMLLoader player2Loader = new FXMLLoader(getClass().getResource("../view/Player.fxml"));
			pC2 = player2Loader.getController();

			Pane paneJ2 = player2Loader.load();
			playerTwoArea.getChildren().add(paneJ2); 
			
			System.out.println("Player 2 pane");

			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initPlayers() {
		this.main.initialisationContenu(getClass().getResource("../view/Player.fxml"), "player");
	}
	
	

}

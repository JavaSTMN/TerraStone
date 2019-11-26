package view;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.GameManager;
import model.Player;

public class UIManager {
	
	private Main main;
	
	@FXML
	private AnchorPane playerOneArea;
	
	@FXML
	private AnchorPane playerTwoArea;
	
	@FXML
	private Pane containerArea;
	
	private Separator separator = new Separator();
	
	//private Player p1 = new Player();
	
	private GameManager game;
	
	//pass a player argument after
	private PlayerController pC1;
	
	
	public void setMainApp(Main main) {
		this.main = main;
	}
	

	@FXML
	private void initialize() {
		try {
			
			this.game = new GameManager();
			Player p1 = this.game.getP1();
			//pC1 = new PlayerController(p1);
			
			Pane paneJ1 = FXMLLoader.load(getClass().getResource("../view/Player.fxml"));
			paneJ1.setPrefWidth(Screen.getPrimary().getVisualBounds().getWidth());
			paneJ1.setPrefHeight(Screen.getPrimary().getVisualBounds().getHeight()/2);
			playerOneArea.getChildren().add(paneJ1);
			
			Pane paneJ2 = FXMLLoader.load(getClass().getResource("../view/Player.fxml"));
			paneJ2.setLayoutY(Screen.getPrimary().getVisualBounds().getHeight()/4);
			paneJ2.setPrefWidth(Screen.getPrimary().getVisualBounds().getWidth());
			paneJ2.setPrefHeight(Screen.getPrimary().getVisualBounds().getHeight()/2);
			playerTwoArea.getChildren().add(paneJ2);
			
			//Separate the players area
			this.separator.setOrientation(Orientation.HORIZONTAL);
			this.separator.setPrefWidth(Screen.getPrimary().getVisualBounds().getWidth());
			this.separator.setPrefHeight(1);
			this.separator.setLayoutY(Screen.getPrimary().getVisualBounds().getHeight()/2);
			this.containerArea.getChildren().add(this.separator);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initPlayers() {
		this.main.initialisationContenu(getClass().getResource("../view/Player.fxml"), "player");
	}
	
	

}

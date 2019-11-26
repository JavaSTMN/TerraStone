package view;

import java.io.IOException;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;

import javafx.scene.Parent;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.Card;
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
	

	private GameManager game;
	
	//pass a player argument after
	private PlayerController pC1;
	
	//pass a player argument after
	private PlayerController pC2;
	
	
	private Player p1;
	
	private Player p2;
	
	
	private ObservableList<Player> players = FXCollections.observableArrayList();

	
	
	public UIManager() {
		
	}
	

	public void setMainApp(Main main) {
		this.main = main;
	}
	

	@FXML
	private void initialize() {
		try {
			
			this.game = new GameManager();
			this.p1 = this.game.getP1();
			this.p2 = this.game.getP2();
			
			game.init();
			
			this.separator.setOrientation(Orientation.HORIZONTAL);
			this.separator.setPrefWidth(Screen.getPrimary().getVisualBounds().getWidth());
			this.separator.setPrefHeight(1);
			this.separator.setLayoutY(Screen.getPrimary().getVisualBounds().getHeight()/2);
			this.containerArea.getChildren().add(this.separator);

      
			FXMLLoader player1Loader = new FXMLLoader(getClass().getResource("../view/Player.fxml"));
			Parent paneJ1 = (Parent) player1Loader.load();
			pC1 = player1Loader.<PlayerController>getController();
			pC1.setModel(p1);
			pC1.initPlayerHand();
			pC1.getPlayerHandController().initHandData();
			System.out.println("pC1 handController size " + pC1.getPlayerHandController().getCardList().size());

			players.add(p1);
			System.out.println("player " + p1.getHand());
			
			Pane pane1 = (Pane)paneJ1;



			pane1.setPrefWidth(Screen.getPrimary().getVisualBounds().getWidth());
			pane1.setPrefHeight(Screen.getPrimary().getVisualBounds().getHeight()/2);
			playerOneArea.getChildren().add(paneJ1); 
			
			
			FXMLLoader player2Loader = new FXMLLoader(getClass().getResource("../view/Player.fxml"));
			Parent paneJ2 =(Parent) player2Loader.load();

			pC2 = player2Loader.getController();
			players.add(p2);
			pC2.setModel(p2);
			pC2.initPlayerHand();
			addCardToHand(p2, pC2);


			pC2.getPlayerHandController().initHandData();
			
			Pane pane2 = (Pane)paneJ2;

			//System.out.println("Model from ui manager " + pC2.getModel());

			pane2.setLayoutY(Screen.getPrimary().getVisualBounds().getHeight()/4);
			pane2.setPrefWidth(Screen.getPrimary().getVisualBounds().getWidth());
			pane2.setPrefHeight(Screen.getPrimary().getVisualBounds().getHeight()/2);
			playerTwoArea.getChildren().add(paneJ2); 
			
			//initPlayersHand();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initPlayers() {
		this.main.initialisationContenu(getClass().getResource("../view/Player.fxml"), "player");
	}
	
	public void addCardToHand(Player player, PlayerController pC) {
		player.draw();
		int last = player.getHand().getCards().size() - 1;
		pC.getPlayerHandController().addCardToHand(player.getHand().getCards().get(last));
		
		String mana = Integer.toString((pC.getPlayerHandController().getCardList().get(last).getMana_cost()));

		pC.getPlayerHandController().getCardControllerList().get(3).initData(pC.getPlayerHandController().getCardList().get(last).getName(), mana, pC.getPlayerHandController().getCardList().get(last).getEffect_description());;

	}

}

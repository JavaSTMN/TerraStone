package view;

import java.io.IOException;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
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
			
			FXMLLoader player1Loader = new FXMLLoader(getClass().getResource("../view/Player.fxml"));
			Parent paneJ1 = (Parent) player1Loader.load();
			pC1 = player1Loader.<PlayerController>getController();
			pC1.setModel(p1);
			pC1.initPlayerHand();
			pC1.getPlayerHandController().initHandData();
			System.out.println("pC1 handController size " + pC1.getPlayerHandController().getCardList().size());

			players.add(p1);
			System.out.println("player " + p1.getHand());

			playerOneArea.getChildren().add(paneJ1); 
			
			
			FXMLLoader player2Loader = new FXMLLoader(getClass().getResource("../view/Player.fxml"));
			Parent paneJ2 =(Parent) player2Loader.load();

			pC2 = player2Loader.getController();
			players.add(p2);
			pC2.setModel(p2);
			pC2.initPlayerHand();
			addCardToHand(p2, pC2);
			String mana = Integer.toString((pC2.getPlayerHandController().getCardList().get(3).getMana_cost()));

			pC2.getPlayerHandController().getCardControllerList().get(3).initData(pC2.getPlayerHandController().getCardList().get(3).getName(), mana, pC2.getPlayerHandController().getCardList().get(3).getEffect_description());;


			pC2.getPlayerHandController().initHandData();

			//System.out.println("Model from ui manager " + pC2.getModel());

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
	}

}

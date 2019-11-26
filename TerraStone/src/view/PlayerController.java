package view;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import model.Card;
import model.Player;


public class PlayerController {
	
	private Main main;
	
	@FXML 
	private AnchorPane boardArea;

	
	@FXML 
	private AnchorPane handArea;
	
	@FXML 
	private AnchorPane deckArea;

	@FXML
	private AnchorPane heroArea;

	private HandController playerHandController;
	
	private HeroController heroController;
	
	private Player model;
	
	@FXML
	private void initialize() {
		
		try {
			
			System.out.println("INIT HAND FOR PLAYER");

			FXMLLoader handLoader = new FXMLLoader(getClass().getResource("../view/Hand.fxml"));
			Parent hand =(Parent) handLoader.load();
			setPlayerHandController(handLoader.getController());
			handArea.getChildren().add(hand);
		
			
			FXMLLoader heroLoader = new FXMLLoader(getClass().getResource("../view/Hero.fxml"));
			Parent hero = (Parent)heroLoader.load();
			setHeroController(heroLoader.getController());
			heroArea.getChildren().add(hero);
			
			
			System.out.println("END INIT HAND FOR PLAYER");

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void setMainApp(Main main) {
		this.main = main;
	}
	
	public void initHand() {
		//this.main.initialisationContenu(getClass().getResource("../view/Hand.fxml"), "hand");
	
		
	}

	public Player getModel() {
		return model;
	}

	public void setModel(Player model) {
		this.model = model;
	}

	public HandController getPlayerHandController() {
		return this.playerHandController;
	}

	public void setPlayerHandController(HandController playerHandController) {
		this.playerHandController = playerHandController;
	}
	
	public HeroController getHeroController() {
		return this.heroController;
	}
	
	public void setHeroController(HeroController heroController) {
		this.heroController = heroController;
	}
	
	public void initPlayerHand() {
		for(Card card : this.model.getHand().getCards()) {
			this.playerHandController.getCardList().add(card);
		}		
		System.out.println("Model from ui manager " + this.model);

	}
	
	public void initPlayerHero() {
		this.heroController.setHero(this.model.getHero());
	}
}

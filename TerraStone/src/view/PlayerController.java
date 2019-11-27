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
import javafx.scene.layout.Region;
import javafx.stage.Screen;
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
	
	private BoardController playerBoardController;
  
	private HeroController heroController;
	
	private Player model;
	
	@FXML
	private void initialize() {
		
		try {
			
			System.out.println("INIT HAND FOR PLAYER");

			FXMLLoader handLoader = new FXMLLoader(getClass().getResource("../view/Hand.fxml"));
			Parent hand =(Parent) handLoader.load();
			setPlayerHandController(handLoader.getController());
			Pane handZone = (Pane)hand;
			handZone.setLayoutY(-20);
			handArea.getChildren().add(handZone);
		
			
			FXMLLoader heroLoader = new FXMLLoader(getClass().getResource("../view/Hero.fxml"));
			Parent hero = (Parent)heroLoader.load();
			setHeroController(heroLoader.getController());
			heroArea.getChildren().add(hero);
			
			FXMLLoader boardLoader = new FXMLLoader(getClass().getResource("../view/Board.fxml")); 
			Parent board = (Parent) boardLoader.load();
			setPlayerBoardController(boardLoader.getController());
			((Region) board).setPrefWidth(Screen.getPrimary().getVisualBounds().getWidth());
			((Region) board).setPrefHeight(Screen.getPrimary().getVisualBounds().getHeight()* (2/3));
			boardArea.getChildren().add(board);			
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
		this.playerHandController.initHandController();
		
		for(int i = 0; i < this.playerHandController.getCardControllerList().size(); i++) {
			this.playerHandController.getCardControllerList().get(i).selectCard();
		}
	}

	public BoardController getPlayerBoardController() {
		return playerBoardController;
	}

	public void setPlayerBoardController(BoardController playerBoardController) {
		this.playerBoardController = playerBoardController;
	}
	
	@FXML
	public void draw() {
		int handSize = this.playerHandController.getCardList().size();
		if(handSize<10) {
			this.addCardToHand();
		}
	}
	
	public void addCardToHand() {
		//add card in the model
		System.out.println("last before" + this.model + "  : " + (this.model.getHand().getCards().size()-1));
		this.model.draw();
		int last = this.model.getHand().getCards().size()-1 ;
		//int last = this.playerHandController.getCardList().size();
		
		System.out.println("last " + this.model + "  : " + last);
		//add view of the new card to hand
		this.getPlayerHandController().addCardToHand(this.model.getHand().getCards().get(last));
		
		System.out.println("Card name " + this.getPlayerHandController().getCardList().get(last).getName());
		//display data
		String name = this.getPlayerHandController().getCardList().get(last).getName();
		System.out.println("new card to add " + this.getPlayerHandController().getCardList().get(last));
		String mana = Integer.toString((this.getPlayerHandController().getCardList().get(last).getMana_cost()));
		String description = this.getPlayerHandController().getCardList().get(last).getEffect_description();
		
		System.out.println(name + " " + mana + " " + description);
		this.getPlayerHandController().getCardControllerList().get(last).initData(name, mana, description);
		this.playerHandController.getCardControllerList().get(last).selectCard();
		last = this.playerHandController.getCardList().size()-1;
		
		
		System.out.println("After - last " + this.model + "  : " + last);
	}

	
	public void initPlayerHero() {
		this.heroController.setHero(this.model.getHero());
	}
}

package view;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import model.Player;


public class PlayerController {
	
	private Main main;
	
	@FXML 
	private AnchorPane boardArea;

	
	@FXML 
	private AnchorPane handArea;
	
	@FXML 
	private AnchorPane deckArea;

	private HandController playerHand;
	
	@FXML
	private void initialize() {
		
		try {
			
			System.out.println("INIT HAND FOR PLAYER");

			FXMLLoader handLoader = new FXMLLoader(getClass().getResource("../view/Hand.fxml"));
			playerHand = handLoader.getController();
			
			HBox hand = handLoader.load();
			handArea.getChildren().add(hand);
			
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
}

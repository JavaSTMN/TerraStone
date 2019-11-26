package view;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class PlayerController {
	
	private Main main;
	
	@FXML 
	private AnchorPane boardArea;

	
	@FXML 
	private AnchorPane handArea;
	
	@FXML 
	private AnchorPane deckArea;
	
	@FXML
	private void initialize() {
		
		try {
			
			System.out.println("INIT HAND FOR PLAYER");

			HBox hand = FXMLLoader.load(getClass().getResource("../view/Hand.fxml"));
			handArea.getChildren().add(hand);
			
			
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

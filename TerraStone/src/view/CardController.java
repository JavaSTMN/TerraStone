package view;


import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import model.CardFX;

public class CardController  {
	
	private Main main;
	
	@FXML
	private Label cardName;
	
	@FXML
	private Label manaValue;
	
	@FXML 
	private Label cardDescription;
	
	@FXML
	private BorderPane card;
	

	
	@FXML
	private void initialize() {
	
	}
	
	
	public void setMainApp(Main main) {
		this.main = main;
	}

}

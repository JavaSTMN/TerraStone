package view;

import java.util.Observable;
import java.util.Observer;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

@SuppressWarnings("deprecation")
public class CardView  implements Observer {
	
	@FXML
	private Label manaValue;
	
	@FXML
	private Label attackValue;
	
	@FXML 
	private Label hpValue;
	
	@FXML
	private Label cardName;
	
	@FXML 
	private Label cardDescription;
	
	@FXML
	private BorderPane card;
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}

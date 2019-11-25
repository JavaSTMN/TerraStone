package view;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import model.CardFX;

public class HandController {
	
	private Main main;
	
	private ObservableList<CardFX> cardList = FXCollections.observableArrayList();
	
	@FXML
	private HBox hand;
	
	@FXML
	private Label handLabel;
	
	@FXML
	private void initialize() {
		//TODO : Null Pointer Exception on the setVlaue of the card in CardView.java
		/*int nb = 1; 
		cardList.add(new CardFX(nb, "test1", "ceci est un test1"));
		//cardList.add(new CardFX(nb, "test2", "ceci est un test2"));
		//cardList.add(new CardFX(nb, "test3", "ceci est un test3"));
		
		for(CardFX card : cardList) {
			CardView c = new CardView(card);
			c.setValue(card);
			System.out.println("in hand controller1");
			
		}
		handLabel.setText(cardList.get(0).getName().getValue());*/
	}
	
	public void setMainApp(Main main) {
		this.main = main;
	}

}

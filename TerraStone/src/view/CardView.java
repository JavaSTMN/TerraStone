package view;


import application.CardMain;
import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import model.CardFX;

public class CardView  {
	
	private CardMain main;
	
	@FXML
	private Label cardName;
	
	@FXML
	private Label manaValue;
	
	@FXML 
	private Label cardDescription;
	
	@FXML
	private BorderPane card;
	
	private CardFX model;
	
	public CardView(CardFX c) {
		this.model = c;
	}
	
	@FXML
	private void initialize() {
		/*cardName.setText("dkmf,rm");
		cardDescription.setText("kreljgkreg");
		manaValue.setText("kzjflrz");
		
		this.model = model;
		cardName.setText(main.getCardList().get(1).getName().getValue());
		cardDescription.setText(main.getCardList().get(1).getEffect_description().getValue());
		manaValue.setText(main.getCardList().get(1).getMana_cost().getValue().toString());*/
	}
	
	public void setValue(CardFX c) {
		//this.main = main;
		cardName.setText(this.model.getName().getValue());
		cardDescription.setText(this.model.getEffect_description().getValue());
		manaValue.setText(this.model.getMana_cost().getValue().toString());
	
	}
	
	

}

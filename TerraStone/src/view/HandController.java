package view;

import java.io.IOException;
import java.util.ArrayList;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import model.Card;
import model.CardFX;
import model.DamagesSpell;
import model.DrawSpell;
import model.Monster;

public class HandController {
	
	private Main main;
	
	
	private ObservableList<Card> cardList = FXCollections.observableArrayList();
	
	@FXML
	private HBox hand;
	
	private ArrayList<CardController> cardControllerList = new ArrayList();
	
	@FXML
	private void initialize() { }
		
	
	public void initHandController() {
		try {

			for(int i = 0; i < cardList.size(); i++) {
				FXMLLoader cardLoader = new FXMLLoader(getClass().getResource("../view/Card.fxml"));
				Parent card = (Parent) cardLoader.load();
				cardControllerList.add(cardLoader.getController());
				hand.getChildren().add(card);
			}

			//ajout si joueur a piece 


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setMainApp(Main main) {
		this.main = main;
	}

	public ObservableList<Card> getCardList() {
		return cardList;
	}

	public void setCardList(ObservableList<Card> cardList) {
		this.cardList = cardList;
	}

	public ArrayList<CardController> getCardControllerList() {
		return this.cardControllerList;
	}
	
	public void initHandData() {

		for(int i = 0; i<cardControllerList.size(); i++) {
			String mana = Integer.toString((cardList.get(i).getMana_cost()));
			System.out.println(cardList.get(i));
			System.out.println(cardList.get(i).getType());
			int pv = 0;
			int dmg = 0;
			 switch(cardList.get(i).getType()) {
		    	case "DamagesSpell":
		    		dmg = ((DamagesSpell) cardList.get(i)).getValue();
		    		break;
		    	case "Monster":
		    		pv = ((Monster) cardList.get(i)).getHp();
		    		dmg = ((Monster) cardList.get(i)).getDamages();
		    		break;
			    default:
			    	break;
		    }
			cardControllerList.get(i).initData(cardList.get(i).getName(),mana , cardList.get(i).getEffect_description() ,pv, dmg,cardList.get(i).getType());
		}
	}
	
	public void addCardToHand(Card card) {
		FXMLLoader cardLoader = new FXMLLoader(getClass().getResource("../view/Card.fxml"));
		Parent parent;
		try {
			parent = (Parent) cardLoader.load();			
			cardControllerList.add(cardLoader.getController());
			hand.getChildren().add(parent);
			
			cardList.add(card);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}

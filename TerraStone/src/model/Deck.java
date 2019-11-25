package model;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.io.FileNotFoundException;

import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@SuppressWarnings("deprecation")
public class Deck extends Observable{
	private ArrayList<Card> cards;
	final int MAX_CARD=20; 
	
	public Deck() {
        JSONParser parser = new JSONParser();
        this.cards = new ArrayList<Card>();
        
        while(this.cards.size() < this.MAX_CARD) {
	        try {    
			JSONArray a = (JSONArray) parser.parse(new FileReader("/res/content.json"));
			
			  for (Object o : a)
			  {
			    JSONObject card = (JSONObject) o;
			    switch((String) card.get("type")) {
			    	case "DamagesSpell":
			    		cards.add(new DamagesSpell((int) card.get("mana_cost"),(String) card.get("name"),(String) card.get("effect_description"),(String) card.get("type"),(int) card.get("value"),(boolean) card.get("random")));
			    		break;
			    	case "Monster":
			    		cards.add(new Monster((int) card.get("mana_cost"),(String) card.get("name"),(String) card.get("effect_description"),(String) card.get("type"),(int) card.get("damages"),(int) card.get("hp")));
				    	break;
			    	case "DrawSpell":
			    		cards.add(new DrawSpell((int) card.get("mana_cost"),(String) card.get("name"),(String) card.get("effect_description"),(String) card.get("type"),(int) card.get("value")));
				    	break;
				    default:
				    	break;
			    }
	
			  }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
		}
	}
	public boolean removeCard(Card card) {
		for(Card hand_card : this.cards) {
			if(hand_card.equals(card)) {
				this.cards.remove(hand_card);
			}
		}
		notifyObservers("removeCard");
		return true;
	}
	public boolean addCard(Card card) {
		if(this.MAX_CARD == this.cards.size()) {
			return false;
		}
		this.cards.add(card);
		notifyObservers("addCard");
		return true;
	}
	public Card pickCard() {
		// TODO Auto-generated method stub
		Card retour = null;
		if(this.cards.size()>0) {
			Collections.shuffle(this.cards);
			retour = this.cards.get(0);
		}
		notifyObservers("pickCard");
		return retour;
	}
}

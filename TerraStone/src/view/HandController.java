package view;

import java.io.IOException;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import model.Card;
import model.CardFX;

public class HandController {
	
	private Main main;
	
	
	private ObservableList<Card> cardList = FXCollections.observableArrayList();
	
	@FXML
	private HBox hand;
	
	
	@FXML
	private void initialize() {
		
	try {
		
		for(int i = 0; i < 3; i++) {
			BorderPane pane = FXMLLoader.load(getClass().getResource("../view/Card.fxml"));
			hand.getChildren().add(pane);
		}
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	
	public void setMainApp(Main main) {
		this.main = main;
	}

}

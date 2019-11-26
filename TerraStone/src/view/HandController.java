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
import model.CardFX;

public class HandController {
	
	private Main main;
	
	private ObservableList<CardFX> cardList = FXCollections.observableArrayList();
	
	@FXML
	private HBox hand;
	
	
	@FXML
	private void initialize() {
		
		try {
			BorderPane pane1	 = FXMLLoader.load(getClass().getResource("../view/Card.fxml"));
			hand.getChildren().add(pane1);
			
			
			BorderPane pane2 = FXMLLoader.load(getClass().getResource("../view/Card.fxml"));
			hand.getChildren().add(pane2);
			
			
			BorderPane pane3 = FXMLLoader.load(getClass().getResource("../view/Card.fxml"));
			hand.getChildren().add(pane3);
			
			BorderPane pane4	 = FXMLLoader.load(getClass().getResource("../view/Card.fxml"));
			hand.getChildren().add(pane4);
			
			
			BorderPane pane5 = FXMLLoader.load(getClass().getResource("../view/Card.fxml"));
			hand.getChildren().add(pane5);
			
			
			BorderPane pane6 = FXMLLoader.load(getClass().getResource("../view/Card.fxml"));
			hand.getChildren().add(pane6);
			
			BorderPane pane7	 = FXMLLoader.load(getClass().getResource("../view/Card.fxml"));
			hand.getChildren().add(pane7);
			
			
			BorderPane pane8 = FXMLLoader.load(getClass().getResource("../view/Card.fxml"));
			hand.getChildren().add(pane8);
			
			
			BorderPane pane9 = FXMLLoader.load(getClass().getResource("../view/Card.fxml"));
			hand.getChildren().add(pane9);
			
			
			BorderPane pane10 = FXMLLoader.load(getClass().getResource("../view/Card.fxml"));
			hand.getChildren().add(pane10);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void setMainApp(Main main) {
		this.main = main;
	}

}

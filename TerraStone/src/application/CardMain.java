package application;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.CardFX;
import view.CardView;

public class CardMain extends Application {

	private Stage mainStage;
	private BorderPane mainContainer;
	private ObservableList<CardFX> cardList = FXCollections.observableArrayList();
	
	public CardMain() {
		int nb = 1; 
		cardList.add(new CardFX(nb, "test1", "ceci est un test1"));
		cardList.add(new CardFX(nb, "test2", "ceci est un test2"));
		cardList.add(new CardFX(nb, "test3", "ceci est un test3"));

	}
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			mainStage = primaryStage;
			mainStage.setTitle("TerraStone");
			initialisationConteneurPrincipal(getClass().getResource("../view/Card.fxml"));
			initialisationContenu();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initialisationConteneurPrincipal(URL location) {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		try {
			//Le chargement nous donne notre conteneur
			mainContainer = (BorderPane) loader.load();
			//On définit une scène principale avec notre conteneur
			Scene scene = new Scene(mainContainer);
			//Que nous affectons à notre Stage
			mainStage.setScene(scene);
			//Pour l'afficher
			mainStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void initialisationContenu() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(CardMain.class.getResource("../view/CardView.fxml"));
		try {
			//Nous récupérons notre conteneur qui contiendra les données
			//Pour rappel, c'est un AnchorPane...
			BorderPane conteneurPersonne = (BorderPane) loader.load();
			
			//Nous récupérons notre mappeur via l'objet FXMLLoader
			CardView controleur = loader.getController();
			//Nous lui passons notre instance de classe
			//pour qu'il puisse récupérer notre liste observable
			controleur.setValue(cardList.get(0));;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	
	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Get the main stage
	 * @return the main stage
	 */
	public Stage getMainStage() {
		return mainStage;
	}

	/**
	 * Set the main stage
	 * @param mainStage
	 */
	public void setMainStage(Stage mainStage) {
		this.mainStage = mainStage;
	}

	/**
	 * Get the main container
	 * @return the main container
	 */
	public BorderPane getMainContainer() {
		return mainContainer;
	}

	/**
	 * Set the main containers
	 * @param mainContainer
	 */
	public void setMainContainer(BorderPane mainContainer) {
		this.mainContainer = mainContainer;
	}

	
	public ObservableList<CardFX> getCardList() {
		return this.getCardList();
	}

}

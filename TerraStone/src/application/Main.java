package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	
	
	private Stage principalStage;
	private Pane principalContainer;
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			principalStage = primaryStage;
			principalStage.setTitle("TerraStone");
			
			/*BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();*/
			
			initialisationConteneurPrincipal();
			initialisationContenu();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void initialisationConteneurPrincipal() {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("menu.view/Menu.fxml"));
		try {
			//Le chargement nous donne notre conteneur
			principalContainer = (Pane) loader.load();
			//On définit une scène principale avec notre conteneur
			Scene scene = new Scene(principalContainer);
			//Que nous affectons à notre Stage
			principalStage.setScene(scene);
			//Pour l'afficher
			principalStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void initialisationContenu() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("menu.view/Menu.fxml"));
		try {
			//Nous récupérons notre conteneur qui contiendra les données
			//Pour rappel, c'est un AnchorPane...
			AnchorPane conteneurPersonne = (AnchorPane) loader.load();
			//Qui nous ajoutons à notre conteneur principal
			//Au centre, puisque'il s'agit d'un BorderPane
			principalContainer.setCenter(conteneurPersonne);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private Stage mainStage;
	private BorderPane mainContainer;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			mainStage = primaryStage;
			mainStage.setTitle("TerraStone");
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
		loader.setLocation(getClass().getResource("../view/Menu.fxml"));
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
		loader.setLocation(getClass().getResource("../view/Menu.fxml"));
		try {
			//Nous récupérons notre conteneur qui contiendra les données
			//Pour rappel, c'est un AnchorPane...
			BorderPane conteneurPersonne = (BorderPane) loader.load();
			//Qui nous ajoutons à notre conteneur principal
			//Au centre, puisque'il s'agit d'un BorderPane
			mainContainer.setCenter(conteneurPersonne);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

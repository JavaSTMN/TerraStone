package application;
	
import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import view.MenuView;
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
			initialisationConteneurPrincipal(getClass().getResource("../view/Menu.fxml"));
			initialisationContenu();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initialisationConteneurPrincipal(URL location) {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		//loader.setLocation(getClass().getResource("../view/Menu.fxml"));
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
			BorderPane conteneurPersonne = (BorderPane) loader.load();
			//Qui nous ajoutons à notre conteneur principal
			//Au centre, puisque'il s'agit d'un BorderPane
			mainContainer.setCenter(conteneurPersonne);
			MenuView menuCtrl = loader.getController();
			menuCtrl.setMainApp(this);
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
}

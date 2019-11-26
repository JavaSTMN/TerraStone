package application;
	
import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import view.HandController;
import view.MenuController;
import view.PlayerController;
import view.UIManager;
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
			initialisationContenu(getClass().getResource("../view/Menu.fxml"), "menu");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initialisationConteneurPrincipal(URL location) {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		//loader.setLocation(getClass().getResource("../view/Menu.fxml"));
		try {
			//close the main stage for menu and open it for manager
			this.mainStage.close();
			
			//Le chargement nous donne notre conteneur
			this.mainContainer = (BorderPane) loader.load();
			//On définit une scène principale avec notre conteneur
			Scene scene = new Scene(mainContainer);
			//Que nous affectons à notre Stage
			this.mainStage.setScene(scene);
			this.mainStage.show();
			//Set full screen
			this.mainStage.setFullScreen(true);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initialisationContenu(URL location, String type) {
		this.mainStage.setFullScreen(true);
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		try {
			//Nous récupérons notre conteneur qui contiendra les données
			BorderPane conteneurPersonne = (BorderPane) loader.load();
			//Qui nous ajoutons à notre conteneur principal
			this.initCtrl(type, loader);
			//Au centre, puisque'il s'agit d'un BorderPane
			this.mainContainer.setCenter(conteneurPersonne);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void initCtrl(String type, FXMLLoader loader) {
		switch(type) {
		case "menu": 
			MenuController menuCtrl = loader.getController();
			menuCtrl.setMainApp(this);	
			break;
		case "manager":
			UIManager managerCtrl = loader.getController();
			managerCtrl.setMainApp(this);
			managerCtrl.initPlayers();
			break;
		case "player":
			PlayerController playerCtrl = loader.getController();
			playerCtrl.setMainApp(this);
			playerCtrl.initHand();
			break;
		case "hand":
			//System.out.println("HAND : " + loader.getController());
			HandController handCtrl = loader.getController();
			handCtrl.setMainApp(this);
			break;
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

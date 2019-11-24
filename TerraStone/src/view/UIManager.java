package view;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Player;

public class UIManager {
	
	private Main main;
	
	@FXML
	private AnchorPane playerOneArea;
	
	@FXML
	private AnchorPane playerTwoArea;
	
	/*private Player p1 = new Player();
	
	private PlayerView pView1 = new PlayerView(p1);
	private PlayerController pc1 = new PlayerController(p1, pView1);
	*/
	
	
	public UIManager() {
		
	}
	
	public void setMainApp(Main main) {
		this.main = main;
	}
	

	@FXML
	private void initialize() {
		try {
			Pane paneJ1 = FXMLLoader.load(getClass().getResource("../view/Player.fxml"));
			playerOneArea.getChildren().add(paneJ1); 
			
			Pane paneJ2 = FXMLLoader.load(getClass().getResource("../view/Player.fxml"));
			playerTwoArea.getChildren().add(paneJ2); 

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}

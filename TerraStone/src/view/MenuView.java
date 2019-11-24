package view;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuView {
	
	@FXML
	private Button buttonPlay;
	
	private Main main;
	
	/**
	 * constructor
	 */
	public MenuView() {}
	
	@FXML
	private void initialize() {
		
	}
	
	public void setMainApp(Main main) {
		this.main = main;
	}
	
	@FXML
	public void pressPlay() {
		this.main.initialisationConteneurPrincipal(getClass().getResource("../view/UiManager.fxml"));
	}
	
	@FXML
	public void pressExit() {
		this.main.getMainStage().close();
	}

}

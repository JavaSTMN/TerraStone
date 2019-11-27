package view;


import application.Main;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import model.DamagesSpell;
import model.Monster;

public class CardController  {
	
	private Main main;
	
	@FXML
	private Label cardName;
	
	@FXML
	private Label manaValue;
	
	@FXML 
	private Label cardDescription;
	
	@FXML
	private Label ptAttack;
	
	@FXML
	private Label ptHealth;	
	
	@FXML
	private BorderPane card;
	
	private boolean selected = false;
	
	
	

	
	@FXML
	private void initialize() {
		
		Pane cardPane = (Pane)this.card;
		cardPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,  CornerRadii.EMPTY, BorderWidths.DEFAULT)));
			
	}
	
	public void selectCard() {
		
		System.out.println("select card");
		
		Pane testCard = (Pane)this.card;
		
		
		testCard.setOnMouseClicked(new EventHandler <MouseEvent>() {
			
			
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("CLICK");
				if(getSelected()) {
					setSelected(false);
					testCard.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,  CornerRadii.EMPTY, BorderWidths.DEFAULT)));
				} else {
					setSelected(true);
					testCard.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID,  CornerRadii.EMPTY, BorderWidths.DEFAULT)));
				}
				
				System.out.println(getSelected());
				
				
			}
		
		});
		
	}
	
	
	public void setMainApp(Main main) {
		this.main = main;
	}
	
	public void initData(String name, String mana, String description, int pv, int dmg, String type) {
		cardName.setText(name);
		manaValue.setText(mana);
		cardDescription.setText(description);
		 switch(type) {
	    	case "DamagesSpell":
	    		ptHealth.setText("");
	    		ptAttack.setText(Integer.toString(dmg));
	    		break;
	    	case "Monster":
	    		ptHealth.setText(Integer.toString(pv));
	    		ptAttack.setText(Integer.toString(dmg));
	    		break;
		    default:
		    	ptHealth.setText("");
		    	ptAttack.setText("");
		    	break;
	    }
	}
	
	public boolean getSelected() {
		return this.selected;
	}
	
	public void setSelected(boolean select) {
		this.selected = select;
	}
	
	public BorderPane getCard() {
		return this.card;
	}

}

package view;

import model.Player;

public class PlayerController {
	
	Player player;
	PlayerView plView;

	PlayerController(Player player, PlayerView plView){
		this.player = player;
		this.plView = plView;
	}
}

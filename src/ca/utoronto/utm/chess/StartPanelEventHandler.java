package ca.utoronto.utm.chess;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class StartPanelEventHandler implements EventHandler<ActionEvent>{
	
	View view;  

	public StartPanelEventHandler(View view) {
		this.view = view;
	}


	@Override
	public void handle(ActionEvent event) {
		String button_name = ((Button) event.getSource()).getText();
		if (button_name.equals("Start")) {
			this.view.changeToBoard();
		}else {
			this.view.changeToMultiplayer();
		}	
	}

}

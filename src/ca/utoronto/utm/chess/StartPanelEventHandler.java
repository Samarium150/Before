package ca.utoronto.utm.chess;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class StartPanelEventHandler implements EventHandler<ActionEvent>{
	
	View view;  

	StartPanelEventHandler(View view) {
		this.view = view;
	}


	@Override
	public void handle(ActionEvent event) {
		this.view.changeToBoard();
	}

}

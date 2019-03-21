package ca.utoronto.utm.chess;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * the handler class of the start panel
 */
public class StartPanelEventHandler implements EventHandler<ActionEvent>{
	
	private View view;

	StartPanelEventHandler(View view) {
		this.view = view;
	}


	@Override
	public void handle(ActionEvent event) {
		this.view.changeToBoard();
	}
}

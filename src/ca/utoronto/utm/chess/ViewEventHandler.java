package ca.utoronto.utm.chess;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

public class ViewEventHandler implements EventHandler<ActionEvent>{
	
	View view;
	
	public ViewEventHandler(View view){
		this.view = view;
	}

	@Override
	public void handle(ActionEvent event) {

		String command = ((MenuItem) event.getSource()).getId();
		
		if (command.equals("Quit")) {
			this.view.changeToStart();
		}
		
	}

}

package ca.utoronto.utm.chess;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;

public class ViewEventHandler implements EventHandler<ActionEvent>{
	
	View view;
	
	public ViewEventHandler(View view){
		this.view = view;
	}

	@Override
	public void handle(ActionEvent event) {

		String command = ((MenuItem) event.getSource()).getId();
		
		if(command.equals("New Game")){
			this.view.createNewGame();
		}else if(command.equals("Help")) {
			Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Instructions");
	        alert.setHeaderText("The Game of Chess");
	        alert.setContentText("THIS IS HOW YOU PLAY");
	        alert.showAndWait();
		}else if (command.equals("Quit")) {
			this.view.createNewGame();
			this.view.changeToStart();
		}else if(command.equals("Exit")){
			System.exit(0);
		}
		
	}

}

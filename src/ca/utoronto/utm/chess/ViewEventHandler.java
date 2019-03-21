package ca.utoronto.utm.chess;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;

/**
 * the handler class for the view
 */
public class ViewEventHandler implements EventHandler<ActionEvent>{
	
	private View view;
	
	ViewEventHandler(View view){
		this.view = view;
	}

	
	@Override
	public void handle(ActionEvent event) {
		String command = ((MenuItem) event.getSource()).getId();
		switch (command) {
			case "New Game":
				this.view.createNewGame();
				break;
			case "Help":
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Instructions");
				alert.setHeaderText("The Game of Chess");
				alert.setContentText("For instructions, please visit us at: \n\n"
						+ "https://github.com/Samarium150/Before/blob/master/README.md");
				alert.showAndWait();
				break;
			case "Main Menu":
				this.view.createNewGame();
				this.view.changeToStart();
				break;
			case "Exit":
				System.exit(0);
				break;
		}
	}
}
